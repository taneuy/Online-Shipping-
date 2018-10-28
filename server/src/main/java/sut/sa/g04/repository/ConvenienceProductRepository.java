package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.ConvenienceProduct;

@RepositoryRestResource
public interface ConvenienceProductRepository extends JpaRepository<ConvenienceProduct,Long>{
    ConvenienceProduct findByProductName (String productName);
}
