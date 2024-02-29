package fsb.ucar.customerService.service;

import fsb.ucar.customerService.entites.Customer;
import fsb.ucar.customerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getById(long id) {

        return this.customerRepository.findById(id);
    }

}
