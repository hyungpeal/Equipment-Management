package org.example.teamProject.repository;

import org.example.teamProject.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @EntityGraph(attributePaths = {"rentals"})
    Optional<Customer> findByCustomerNumber(int customerNumber);

}
