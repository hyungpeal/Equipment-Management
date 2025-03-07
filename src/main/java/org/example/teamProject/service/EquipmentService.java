package org.example.teamProject.service;

import org.example.teamProject.entity.Equipment;
import org.example.teamProject.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }

    public Equipment insert(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    public void deleteAll(){
        equipmentRepository.deleteAll();
    }

    public List<Equipment> findByEquipmentName(String equipmentNameOrCategory){
        List<Equipment> result = equipmentRepository.findByEquipmentNameOrCategory(equipmentNameOrCategory);
        return result != null ? result : Collections.emptyList();
    }

    public Equipment findByEquipmentBarcode(Long barcode){
        return equipmentRepository.findByBarcode(barcode);
    }

}
