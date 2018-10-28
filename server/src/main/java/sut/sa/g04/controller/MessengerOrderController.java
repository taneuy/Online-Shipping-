package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MessengerOrderController {
    @Autowired private CustomerRepository customerRepository;
    @Autowired private MessengerOrderRepository messengerOrderRepository;
    @Autowired private MessengerServiceRepository messengerServiceRepository;
    @Autowired private MessengerAreaRepository messengerAreaRepository;
    public MessengerOrderController(MessengerOrderRepository messengerOrderRepository){
        this.messengerOrderRepository = messengerOrderRepository;
    }
    @GetMapping("/messenger/orders")
    public Collection<MessengerOrder> MessengerArea() {
        return messengerOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/messengerOrders/{username}/{service}/{area}//{receiverName}/{receiverPhone}/{receiverLocation}/{note}")
    public MessengerOrder newOrder(
        @RequestBody MessengerOrder newOrder,
        @PathVariable String username,
        @PathVariable String service,
        @PathVariable String area,
        @PathVariable String receiverName,
        @PathVariable String receiverPhone,
        @PathVariable String receiverLocation,
        @PathVariable String note) {
            Customer    paidCustomer = customerRepository.findByName(username);
            MessengerService    paidService = messengerServiceRepository.findByServiceType(service);
            MessengerArea       paidArea = messengerAreaRepository.findByAreaType(area);

            Long servicePrice = paidService.getServicePrice();
            Long areaPrice = paidArea.getAreaPrice();

            newOrder.setPaidCustomer(paidCustomer);
            newOrder.setPaidService(paidService);
            newOrder.setPaidArea(paidArea);
            newOrder.setReceiverName(receiverName);
            newOrder.setReceiverPhone(receiverPhone);
            newOrder.setReceiverAddress(receiverLocation);
            newOrder.setNote(note);
            newOrder.setTotalPrice(servicePrice + areaPrice);
            return messengerOrderRepository.save(newOrder);
    }
}
