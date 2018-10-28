package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g04.entity.ConvenienceSetProduct;
import sut.sa.g04.repository.ConvenienceSetProductRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConvenienceSetProductController {
    @Autowired
    private ConvenienceSetProductRepository convenienceSetProductRepository;
    public ConvenienceSetProductController(ConvenienceSetProductRepository convenienceSetProductRepository){
        this.convenienceSetProductRepository = convenienceSetProductRepository;
    }
    @GetMapping("/convenience/setProducts")
    public Collection<ConvenienceSetProduct> ConvenienceSetProduct() {
        return convenienceSetProductRepository.findAll().stream().collect(Collectors.toList());
    }
}

