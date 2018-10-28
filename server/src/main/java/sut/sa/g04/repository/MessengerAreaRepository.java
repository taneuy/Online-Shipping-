package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.MessengerArea;

@RepositoryRestResource
public interface MessengerAreaRepository extends JpaRepository<MessengerArea,Long>{
    MessengerArea findByAreaId(Long areaId);
    MessengerArea findByAreaType(String areaType);
    MessengerArea findByAreaPrice(Long areaPrice);
}
