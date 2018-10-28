package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.TaxiArea;
import sut.sa.g04.repository.TaxiAreaRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class TaxiAreaController {
    @Autowired private TaxiAreaRepository taxiAreaRepository;

    public TaxiAreaController(TaxiAreaRepository taxiAreaRepository) {
        this.taxiAreaRepository = taxiAreaRepository;
    }

    @GetMapping("/taxi/areas")
    public Collection<TaxiArea> areas() {
        return taxiAreaRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/taxi/areas/getByAreaId/{areaId}")
    public TaxiArea TaxiArea2(@PathVariable Long areaId) {
        TaxiArea      AreaData = taxiAreaRepository.findByareaId(areaId);
        return AreaData;
    }
    @GetMapping("/taxi/areas/getByAreaType/{areaType}")
    public TaxiArea TaxiArea3(@PathVariable String areaType) {
        TaxiArea      AreaData = taxiAreaRepository.findByAreaType(areaType);
        return AreaData;
    }
    @GetMapping("/taxi/areas/getByAreaPrice/{areaPrice}")
    public TaxiArea TaxiArea4(@PathVariable Long areaPrice) {
        TaxiArea      AreaData = taxiAreaRepository.findByAreaPrice(areaPrice);
        return AreaData;
    }
}