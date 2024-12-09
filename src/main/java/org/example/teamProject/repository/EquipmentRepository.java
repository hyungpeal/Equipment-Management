package org.example.teamProject.repository;

import org.example.teamProject.entity.Equipment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findByEquipmentName(String equipmentName);

    @EntityGraph(attributePaths = {"rentals"})
    Equipment findByBarcode(Long equipmentBarcode);

}
