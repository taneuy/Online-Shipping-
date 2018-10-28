package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.FoodMenu;
import sut.sa.g04.repository.FoodMenuRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodMenuController {
    @Autowired private FoodMenuRepository foodMenuRepository;
    public FoodMenuController(FoodMenuRepository foodMenuRepository){
        this.foodMenuRepository = foodMenuRepository;
    }
    @GetMapping("/food/menus")
    public Collection<FoodMenu> FoodMenu() {
        return foodMenuRepository.findAll().stream().collect(Collectors.toList());
    }

}
