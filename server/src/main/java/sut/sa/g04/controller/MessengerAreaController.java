package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.MessengerArea;
import sut.sa.g04.repository.MessengerAreaRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MessengerAreaController {
    @Autowired private MessengerAreaRepository messengerAreaRepository;
    public MessengerAreaController(MessengerAreaRepository messengerAreaRepository){
        this.messengerAreaRepository = messengerAreaRepository;
    }
    @GetMapping("/messenger/areas")
    public Collection<MessengerArea> MessengerArea() {
        return messengerAreaRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/messenger/areas/getByAreaId/{areaId}")
    public MessengerArea MessengerArea2(@PathVariable Long areaId) {
        MessengerArea      AreaData = messengerAreaRepository.findByAreaId(areaId);
        return AreaData;
    }
    @GetMapping("/messenger/areas/getByAreaType/{areaType}")
    public MessengerArea MessengerArea3(@PathVariable String areaType) {
        MessengerArea      AreaData = messengerAreaRepository.findByAreaType(areaType);
        return AreaData;
    }
    @GetMapping("/messenger/areas/getByAreaPrice/{areaPrice}")
    public MessengerArea MessengerArea4(@PathVariable Long areaPrice) {
        MessengerArea      AreaData = messengerAreaRepository.findByAreaPrice(areaPrice);
        return AreaData;
    }
}
