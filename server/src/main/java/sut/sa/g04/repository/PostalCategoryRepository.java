package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g04.entity.PostalCategory;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface PostalCategoryRepository extends JpaRepository<PostalCategory,Long>{
    PostalCategory findByCategory(String category);
}
