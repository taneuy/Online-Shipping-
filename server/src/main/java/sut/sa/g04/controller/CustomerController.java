package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.Customer;
import sut.sa.g04.repository.CustomerRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
    @Autowired private CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public Collection<Customer> Customer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/customers/{username}/{password}")
    public boolean customer1(@PathVariable String username, @PathVariable String password) {
        Customer user = customerRepository.findByUsername(username);
        String p = user.getPassword();
        System.out.println(username);
        System.out.println(p + " = " + password);
        return p.matches(password);
    }
    @GetMapping("/customers/getById/{id}")
    public Customer Customer2(@PathVariable Long id) {
        Customer   customerData    = customerRepository.findByCustomerId(id);
        return customerData;
    }
    @GetMapping("/customers/getByName/{name}")
    public Customer Customer3(@PathVariable String name) {
        Customer   customerData    = customerRepository.findByName(name);
        return customerData;
    }
    @PostMapping("/customers/{username}/{password}/{name}/{phone}/{email}/{address}")
    public Customer customer(
        @PathVariable String username, 
        @PathVariable String password,
        @PathVariable String name,
        @PathVariable String phone,
        @PathVariable String email,
        @PathVariable String address) {
            Customer newCustomer = new Customer();
            newCustomer.setUsername(username);
            newCustomer.setPassword(password);
            newCustomer.setName(name);
            newCustomer.setPhone(phone);
            newCustomer.setEmail(email);
            newCustomer.setAddress(address);
        return customerRepository.save(newCustomer);
    }
}
