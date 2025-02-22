package org.example.teamProject.repository;

import org.example.teamProject.entity.Equipment;
import org.example.teamProject.entity.Rental;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query("SELECT e FROM Equipment e " +
            "where LOWER(e.equipmentName) LIKE LOWER(CONCAT('%', :equipmentNameOrCategory, '%' )) " +
            "   OR LOWER(e.category) LIKE LOWER(CONCAT('%', :equipmentNameOrCategory, '%')) ")
    List<Equipment> findByEquipmentNameOrCategory(String equipmentNameOrCategory);

    @EntityGraph(attributePaths = {"rentals"})
    Equipment findByBarcode(Long equipmentBarcode);

    @Query("SELECT r FROM Rental r " +
            "JOIN r.customer c " +
            "JOIN r.equipment e " +
            "WHERE LOWER(c.customerName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(e.equipmentName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Rental> findByCustomerOrEquipmentName(String keyword);

}
