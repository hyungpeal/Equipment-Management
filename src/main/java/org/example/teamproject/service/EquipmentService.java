package org.example.teamproject.service;

import org.example.teamproject.entity.Equipment;
import org.example.teamproject.repository.EquipmentRepository;
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

    public List<Equipment> findByEquipmentName(String equipmentName){
        List<Equipment> result = equipmentRepository.findByEquipmentName(equipmentName);
        return result != null ? result : Collections.emptyList();
    }

    public Equipment findByEquipmentBarcode(Long barcode){
        return equipmentRepository.findByBarcode(barcode);
    }

}
