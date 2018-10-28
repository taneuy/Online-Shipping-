package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.ConvenienceProduct;
import sut.sa.g04.repository.ConvenienceProductRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConvenienceProductController {
    @Autowired
    private ConvenienceProductRepository convenienceProductRepository;
    public ConvenienceProductController(ConvenienceProductRepository convenienceProductRepository){
        this.convenienceProductRepository = convenienceProductRepository;
    }
    @GetMapping("/convenience/products")
    public Collection<ConvenienceProduct> ConvenienceProduct() {
        return convenienceProductRepository.findAll().stream().collect(Collectors.toList());
    }
}
