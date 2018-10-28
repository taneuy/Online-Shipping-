package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.FoodOrder;

@RepositoryRestResource

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    FoodOrder findByOrderId(Long orderId);
}

