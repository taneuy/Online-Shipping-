package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.PostalAmount;
import sut.sa.g04.repository.PostalAmountRepository;
// import sut.sa.g04.repository.PostalOrderRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")
public class PostalAmountController {
    @Autowired private PostalAmountRepository postalAmountRepository;
    // @Autowired private PostalOrderRepository postalOrderRepository;

    public PostalAmountController(PostalAmountRepository postalAmountRepository){
        this.postalAmountRepository = postalAmountRepository;
    }

    @GetMapping("/postal/amounts")
    public Collection<PostalAmount> PostalAmount() {
        return postalAmountRepository.findAll().stream().collect(Collectors.toList());
    }
}