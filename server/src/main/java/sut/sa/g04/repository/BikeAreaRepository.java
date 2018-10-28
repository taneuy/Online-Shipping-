package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.BikeArea;

@RepositoryRestResource
public interface BikeAreaRepository extends JpaRepository<BikeArea,Long>{
    BikeArea findByAreaId(Long areaId);
    BikeArea findByAreaType(String areaType);
    BikeArea findByAreaPrice(Long areaPrice);
}
