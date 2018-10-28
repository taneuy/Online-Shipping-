package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConvenienceOrderController {

    @Autowired private ConvenienceOrderRepository convenienceOrderRepository;
    @Autowired private ConvenienceProductRepository convenienceProductRepository;
    @Autowired private ConvenienceSetProductRepository convenienceSetProductRepository;
    @Autowired private CustomerRepository customerRepository;

    public ConvenienceOrderController(ConvenienceOrderRepository convenienceOrderRepository){
        this.convenienceOrderRepository = convenienceOrderRepository;
    }
    @GetMapping("/convenience/orders")
    public Collection<ConvenienceOrder> ConvenienceOrder() {
        return convenienceOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/convenience/orders/getdata/{orderId}")
    public Optional<ConvenienceOrder> ConvenienceOrders(@PathVariable Long orderId) {
        Optional<ConvenienceOrder> order = convenienceOrderRepository.findById(orderId);
        return order;
    }
    @PostMapping("/convenience/orders/new/{adder}")
    public ConvenienceOrder newConvenienceOrder(@PathVariable String adder) {
        ConvenienceOrder newConvenienceOrder = new ConvenienceOrder();
        Customer customerOrder = customerRepository.findByName(adder);
        newConvenienceOrder.setAdder(customerOrder);
        return  convenienceOrderRepository.save(newConvenienceOrder);
    }

    @PostMapping("/convenience/orders/addProduct/{idProduct}/{listProductName}")
    public ConvenienceOrder addProduct(@PathVariable long idProduct, @PathVariable String[] listProductName) {

        ConvenienceOrder order = convenienceOrderRepository.findByOrderId(idProduct);
        ConvenienceProduct product;
        for (String ProductName : listProductName) {
            product = convenienceProductRepository.findByProductName(ProductName);

            ConvenienceSetProduct newConvenienceSet = new ConvenienceSetProduct();
            newConvenienceSet.setProduct(product);
            newConvenienceSet.setOrderId(idProduct);
            convenienceSetProductRepository.save(newConvenienceSet);
            order.getListProduct().add(newConvenienceSet);
        }
        return  convenienceOrderRepository.save(order);
    }
}
