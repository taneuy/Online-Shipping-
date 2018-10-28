package sut.sa.g04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g04.entity.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long id);
    Customer findByName(String name);
    Customer findByUsername(String username);
    Customer findByPassword(String password);
}
