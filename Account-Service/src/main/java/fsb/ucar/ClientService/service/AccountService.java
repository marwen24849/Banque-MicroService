package fsb.ucar.ClientService.service;


import fsb.ucar.ClientService.client.CustomerrestClient;
import fsb.ucar.ClientService.entites.BankAccount;
import fsb.ucar.ClientService.model.Customer;
import fsb.ucar.ClientService.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerrestClient client;

    public BankAccount getAccount(String id){

        return this.accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Pas Trouve"));

    }

    public List<BankAccount> getAll(){
        return this.accountRepository.findAll();
    }

    public BankAccount add(BankAccount account){

        account.setAccountId(UUID.randomUUID().toString());
        return this.accountRepository.save(account);
    }

    public BankAccount update(String id,BankAccount account){
        BankAccount account1 = this.getAccount(id);
        Customer customer = this.client.findCustomerByTd(account.getCustomerId());
        if(customer == null)
            throw new RuntimeException("Customer non Trouve");
        account.setAccountId(id);
        return this.accountRepository.save(account);

    }
    public void delete(String id){
        BankAccount account1 = this.getAccount(id);
        this.accountRepository.deleteById(id);
    }

}
