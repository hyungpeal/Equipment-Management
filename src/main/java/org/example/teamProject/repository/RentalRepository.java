package org.example.teamProject.repository;


import org.example.teamProject.entity.Rental;
import org.example.teamProject.entity.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<org.example.teamProject.entity.Rental, Long> {

    Optional<Rental> findFirstByEquipmentBarcodeOrderByRentalDateDesc(Long barcode);

    @Query("SELECT r FROM Rental r " +
            "JOIN r.customer c " +
            "JOIN r.equipment e " +
            "WHERE LOWER(c.customerName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(e.equipmentName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Rental> findByCustomerOrEquipmentName(String keyword);

    List<Rental> findByStatus(Status status, Sort returnDate);
}
