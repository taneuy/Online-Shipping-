package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.PostalCategory;
import sut.sa.g04.repository.PostalCategoryRepository;
// import sut.sa.g04.repository.PostalOrderRepository;

// import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")

public class PostalCategoryController {
    @Autowired private PostalCategoryRepository postalCategoryRepository;
    // @Autowired private PostalOrderRepository postalOrderRepository;

    public PostalCategoryController(PostalCategoryRepository postalCategoryRepository){
        this.postalCategoryRepository = postalCategoryRepository;
        // this.postalOrderRepository = postalOrderRepository;
    }

    @GetMapping("/postal/categories")
    public Collection<PostalCategory> PostalCategory() {
        return postalCategoryRepository.findAll().stream().collect(Collectors.toList());
    }

}