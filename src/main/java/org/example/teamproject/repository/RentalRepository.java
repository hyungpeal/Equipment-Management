package org.example.teamproject.repository;


import org.example.teamproject.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalRepository extends JpaRepository<org.example.teamproject.entity.Rental, Long> {

    Optional<Rental> findFirstByEquipmentBarcodeOrderByRentalDateDesc(Long barcode);

}
