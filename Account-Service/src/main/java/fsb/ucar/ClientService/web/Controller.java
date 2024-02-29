package fsb.ucar.ClientService.web;

import fsb.ucar.ClientService.client.CustomerrestClient;
import fsb.ucar.ClientService.entites.BankAccount;
import fsb.ucar.ClientService.model.Customer;
import fsb.ucar.ClientService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "Account")
@RestController
public class Controller {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerrestClient customerrestClient;

    @GetMapping("All")
    public ResponseEntity<Object> getAll(){
        List<BankAccount> accounts = this.accountService.getAll();
        accounts.forEach(account -> {
            Customer customer = this.customerrestClient.findCustomerByTd(account.getCustomerId());
            account.setCustomer(customer);
        });
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        BankAccount account = this.accountService.getAccount(id);
        Customer customer= this.customerrestClient.findCustomerByTd(account.getCustomerId());
        account.setCustomer(customer);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PostMapping("Add")
    public ResponseEntity<Object> addAccount(@RequestBody BankAccount account){
        return new ResponseEntity<>(this.accountService.add(account),HttpStatus.OK);
    }
    @PutMapping("Update/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody BankAccount account){
        return new ResponseEntity<>(this.accountService.update(id,account),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        this.accountService.delete(id);
        return new ResponseEntity<>("Suppression terminate",HttpStatus.OK);
    }
}
