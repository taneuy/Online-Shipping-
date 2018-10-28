package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.Customer;
import sut.sa.g04.entity.PostalAmount;
import sut.sa.g04.entity.PostalCategory;
import sut.sa.g04.entity.PostalOrder;
import sut.sa.g04.repository.CustomerRepository;
import sut.sa.g04.repository.PostalAmountRepository;
import sut.sa.g04.repository.PostalCategoryRepository;
import sut.sa.g04.repository.PostalOrderRepository;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@RestController

public class PostalOrderController {
    @Autowired private PostalOrderRepository postalOrderRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private PostalCategoryRepository postalCategoryRepository;
    @Autowired private PostalAmountRepository postalAmountRepository;

    public PostalOrderController(PostalOrderRepository postalOrderRepository){
        this.postalOrderRepository = postalOrderRepository;
    }

    @GetMapping("/postal/orders")
    public Collection<PostalOrder> PostalOrder() {
        return postalOrderRepository.findAll().stream().collect(Collectors.toList());
    }
 

    @PostMapping("/postal/orders/{name}/{category}/{box}")
    public PostalOrder newPostalOrder(@RequestBody PostalOrder newPostalOrder,
                              @PathVariable String name,
                              @PathVariable String box,
                              @PathVariable String category
    ) {

        Customer orderCustomer = customerRepository.findByName(name);
        PostalAmount orderAmount = postalAmountRepository.findByBox(box);
        PostalCategory orderCategory = postalCategoryRepository.findByCategory(category);

        newPostalOrder.setCustomerorder(orderCustomer);
        newPostalOrder.setCategory(orderCategory);
        newPostalOrder.setAmount(orderAmount);

        newPostalOrder.setOrderDate(new Date());
        return postalOrderRepository.save(newPostalOrder);
    }

}