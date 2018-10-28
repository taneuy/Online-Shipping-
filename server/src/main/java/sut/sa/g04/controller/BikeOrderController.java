package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@RestController

public class BikeOrderController {
    @Autowired private BikeOrderRepository bikeOrderRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private BikeAreaRepository bikeAreaRepository;
    @Autowired private BikePaymentRepository bikePaymentRepository;

    public BikeOrderController(BikeOrderRepository bikeOrderRepository){
        this.bikeOrderRepository = bikeOrderRepository;
    }

    @GetMapping("/bike/orders")
    public Collection<BikeOrder> BikeOrder() {
        return bikeOrderRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/bikeOrders/{username}/{paymentType}/{areaType}/{pickLocation}/{dropLocation}/{totalPrice}")
    public BikeOrder newBikeOrder(@RequestBody BikeOrder newOrder,
                                      @PathVariable String username,
                                      @PathVariable String areaType,
                                      @PathVariable String pickLocation,
                                      @PathVariable String dropLocation,
                                      @PathVariable String paymentType,
                                      @PathVariable Long totalPrice
    ) {

        Customer customer = customerRepository.findByName(username);
        BikeArea area = bikeAreaRepository.findByAreaType(areaType);
        BikePayment payment = bikePaymentRepository.findByPaymentType(paymentType);

        Long areaPrice = area.getAreaPrice();

        newOrder.setCustomer(customer);
        newOrder.setBikeArea(area);
        newOrder.setBikePayment(payment);
        newOrder.setPickLocation(pickLocation);
        newOrder.setDropLocation(dropLocation);
        newOrder.setTotalPrice(20 + areaPrice);
        return bikeOrderRepository.save(newOrder);
    }
}

