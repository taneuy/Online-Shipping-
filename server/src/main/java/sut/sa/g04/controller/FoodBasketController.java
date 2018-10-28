package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodBasketController {
    @Autowired private FoodBasketRepository foodBasketRepository;
    public FoodBasketController(FoodBasketRepository foodBasketRepository){
        this.foodBasketRepository = foodBasketRepository;
    }
    @GetMapping("/food/baskets")
    public Collection<FoodBasket> FoodBasket() {
        return foodBasketRepository.findAll().stream().collect(Collectors.toList());
    }
}
