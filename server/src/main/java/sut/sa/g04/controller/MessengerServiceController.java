package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.MessengerService;
import sut.sa.g04.repository.MessengerServiceRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MessengerServiceController {
    @Autowired private MessengerServiceRepository messengerServiceRepository;
    public MessengerServiceController(MessengerServiceRepository messengerServiceRepository){
        this.messengerServiceRepository = messengerServiceRepository;
    }
    @GetMapping("/messenger/services")
    public Collection<MessengerService> MessengerService() {
        return messengerServiceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/messenger/services/getByServiceId/{serviceId}")
    public MessengerService MessengerService2(@PathVariable Long serviceId) {
        MessengerService serviceData = messengerServiceRepository.findByServiceId(serviceId);
        return serviceData;
    }
    @GetMapping("/messenger/services/getByServiceType/{serviceType}")
    public MessengerService MessengerService3(@PathVariable String serviceType) {
        MessengerService serviceData = messengerServiceRepository.findByServiceType(serviceType);
        return serviceData;
    }
    @GetMapping("/messenger/services/getByServicePrice/{servicePrice}")
    public MessengerService MessengerService4(@PathVariable Long servicePrice) {
        MessengerService serviceData = messengerServiceRepository.findByServicePrice(servicePrice);
        return serviceData;
    }
}
