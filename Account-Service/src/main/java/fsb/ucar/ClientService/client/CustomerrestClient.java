package fsb.ucar.ClientService.client;

import fsb.ucar.ClientService.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER")
public interface CustomerrestClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "Customer-Service", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerByTd(@PathVariable long id);

    @GetMapping("/customer/All")
    List<Customer> allCustomer();

    default  Customer getDefaultCustomer(long id, Exception exception ){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstname("PasTrouve");
        customer.setLastname("PasTrouve");
        customer.setEmail("PasTrouve@Gmail.famach");
        return customer;

    }
}
