package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.MessengerService;

@RepositoryRestResource
public interface MessengerServiceRepository extends JpaRepository<MessengerService,Long>{
    MessengerService findByServiceId(Long serviceId);
    MessengerService findByServiceType(String serviceType);
    MessengerService findByServicePrice(Long servicePrice);
}
