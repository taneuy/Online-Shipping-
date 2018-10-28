package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.TaxiArea;
@RepositoryRestResource
public interface TaxiAreaRepository extends JpaRepository<TaxiArea, Long> {
    TaxiArea findByareaId(Long id);
    TaxiArea findByAreaType(String areaType);
    TaxiArea findByAreaPrice(Long areaPrice);
}