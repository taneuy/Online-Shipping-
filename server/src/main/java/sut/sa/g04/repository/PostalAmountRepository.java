package sut.sa.g04.repository;

import sut.sa.g04.entity.PostalAmount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface PostalAmountRepository extends JpaRepository<PostalAmount,Long>{
    PostalAmount findByBox(String box);
}
