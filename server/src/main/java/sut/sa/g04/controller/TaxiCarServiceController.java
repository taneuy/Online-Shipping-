package sut.sa.g04.controller;

import sut.sa.g04.entity.TaxiCarService;
import sut.sa.g04.repository.TaxiCarServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class TaxiCarServiceController {
    @Autowired private TaxiCarServiceRepository taxiCarServiceRepository;

    public TaxiCarServiceController(TaxiCarServiceRepository taxiCarServiceRepository) {
        this.taxiCarServiceRepository = taxiCarServiceRepository;
    }

    @GetMapping("/taxi/CarServices")
    public Collection<TaxiCarService> taxiCarServices() {
        return taxiCarServiceRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/taxi/service/getByServiceId/{serviceId}")
    public TaxiCarService TaxiCarService(@PathVariable Long serviceId) {
        TaxiCarService      AreaData = taxiCarServiceRepository.findByServiceId(serviceId);
        return AreaData;
    }
}