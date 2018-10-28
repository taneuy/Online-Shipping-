package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.TaxiCarService;

@RepositoryRestResource
public interface TaxiCarServiceRepository extends JpaRepository<TaxiCarService,Long>{
    TaxiCarService findByServiceId(Long serviceId);
    TaxiCarService findByCarType(String carType);
    TaxiCarService findByCarPrice(Long carPrice);
}
