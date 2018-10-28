package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.BikePayment;
import sut.sa.g04.repository.BikePaymentRepository;


import java.util.Collection;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")

public class BikePaymentController {
    @Autowired private BikePaymentRepository bikePaymentRepository;
    

    public BikePaymentController(BikePaymentRepository bikePaymentRepository){
        this.bikePaymentRepository = bikePaymentRepository;
    }

    @GetMapping("/bike/payments")
    public Collection<BikePayment> BikePayment() {
        return bikePaymentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/bike/payments/getByPaymentId/{paymentId}")
    public BikePayment BikePayment(@PathVariable Long paymentId) {
        BikePayment      AreaData = bikePaymentRepository.findByPaymentId(paymentId);
        return AreaData;
    }

}
