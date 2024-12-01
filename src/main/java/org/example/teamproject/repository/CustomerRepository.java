package org.example.teamproject.repository;

import org.example.teamproject.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @EntityGraph(attributePaths = {"rentals"})
    Optional<Customer> findByCustomerNumber(int customerNumber);

}
