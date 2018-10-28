package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sut.sa.g04.entity.BikeArea;
import sut.sa.g04.repository.BikeAreaRepository;


import java.util.Collection;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BikeAreaController {
    @Autowired private BikeAreaRepository bikeAreaRepository;
    
    public BikeAreaController(BikeAreaRepository bikeAreaRepository){
        this.bikeAreaRepository = bikeAreaRepository;
    }
    @GetMapping("/bike/areas")
    public Collection <BikeArea> areas() {
        return bikeAreaRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/bike/areas/getByAreaId/{areaId}")
    public BikeArea BikeArea2(@PathVariable Long areaId) {
        BikeArea      AreaData = bikeAreaRepository.findByAreaId(areaId);
        return AreaData;
    }
    @GetMapping("/bike/areas/getByAreaType/{areaType}")
    public BikeArea BikeArea3(@PathVariable String areaType) {
        BikeArea      AreaData = bikeAreaRepository.findByAreaType(areaType);
        return AreaData;
    }
    @GetMapping("/bike/areas/getByAreaPrice/{areaPrice}")
    public BikeArea BikeArea4(@PathVariable Long areaPrice) {
        BikeArea      AreaData = bikeAreaRepository.findByAreaPrice(areaPrice);
        return AreaData;
    }
}
