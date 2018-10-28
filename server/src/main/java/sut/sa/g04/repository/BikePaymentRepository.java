package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.BikePayment;

@RepositoryRestResource
public interface BikePaymentRepository extends JpaRepository<BikePayment,Long>{
    BikePayment findByPaymentId(Long paymentId);
    BikePayment findByPaymentType(String paymentType);
}

