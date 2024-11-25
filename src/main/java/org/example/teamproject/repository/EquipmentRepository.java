package org.example.teamproject.repository;

import org.example.teamproject.dto.EquipmentDTO;
import org.example.teamproject.entity.Equipment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findByEquipmentName(String equipmentName);

    @EntityGraph(attributePaths = {"rentals"})
    Equipment findByBarcode(Long equipmentBarcode);

}
