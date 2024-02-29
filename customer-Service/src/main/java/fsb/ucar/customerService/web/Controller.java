package fsb.ucar.customerService.web;


import fsb.ucar.customerService.entites.Customer;
import fsb.ucar.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customer")
public class Controller {

    @Autowired
    private CustomerService customerService;

    @GetMapping("All")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(this.customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id){
        return new ResponseEntity<>(this.customerService.getById(id).get(), HttpStatus.OK);
    }

    @PostMapping("Add")
    public ResponseEntity<Object> addCustoomer(@RequestBody Customer customer){
        return new ResponseEntity<>(this.customerService.addCustomer(customer),HttpStatus.CREATED);
    }



}
