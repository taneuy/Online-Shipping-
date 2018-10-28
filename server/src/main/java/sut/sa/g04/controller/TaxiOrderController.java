package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class TaxiOrderController {
    @Autowired private TaxiOrderRepository taxiOrderRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private TaxiCarServiceRepository taxiCarServiceRepository;
    @Autowired private TaxiAreaRepository taxiAreaRepositor;
    public TaxiOrderController(TaxiOrderRepository taxiOrderRepository) {
        this.taxiOrderRepository = taxiOrderRepository;
    }

    @GetMapping("/taxi/orders")
    public Collection<TaxiOrder> taxiOrder() {
        return taxiOrderRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/taxiOrders/{username}/{carType}/{areaType}/{Location1}/{Location2}/{note}/{totalPrice}")
    public TaxiOrder newOrder(@RequestBody TaxiOrder newOrder,
                        @PathVariable String username,
                        @PathVariable String areaType,
                        @PathVariable String carType,
                        @PathVariable String Location1,
                        @PathVariable String Location2,
                        @PathVariable String note,
                        @PathVariable Long totalPrice){

        Customer customer = customerRepository.findByName(username);
        TaxiArea area = taxiAreaRepositor.findByAreaType(areaType);
        TaxiCarService carTy = taxiCarServiceRepository.findByCarType(carType);

        Long carPrice = carTy.getCarPrice();
        Long areaPrice = area.getAreaPrice();

        newOrder.setCustomer(customer);
        newOrder.setTaxiArea(area);
        newOrder.setTaxicarService(carTy);
        newOrder.setLocation1(Location1);
        newOrder.setLocation2(Location2);
        newOrder.setNote(note);
        newOrder.setTotalPrice(carPrice + areaPrice);
        return taxiOrderRepository.save(newOrder);

                        }

}
