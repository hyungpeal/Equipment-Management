package org.example.teamproject.controller;

import org.example.teamproject.dto.EquipmentDTO;
import org.example.teamproject.dto.RentalDTO;
import org.example.teamproject.entity.Equipment;
import org.example.teamproject.entity.Rental;
import org.example.teamproject.service.EquipmentService;
import org.example.teamproject.service.RentalReturnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rentalReturnPage")
@RestController
public class RentalReturnRestController {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    RentalReturnService rentalReturnService;

    @GetMapping("/getEquipmentData")
    public EquipmentDTO getEquipmentData(@RequestParam("barcode") Long barcode) {

        Equipment equipment = equipmentService.findByEquipmentBarcode(barcode);
        if(equipment == null) {
            return null;
        }
        EquipmentDTO dto = new EquipmentDTO();
        BeanUtils.copyProperties(equipment, dto);
        return dto;
    }

    @PostMapping("/")
    public ResponseEntity<Rental> rentalEquipment(@RequestBody RentalDTO rentalDTO) {

        Rental rental = rentalReturnService.rentalEquipment(rentalDTO);

        return ResponseEntity.ok(rental);
    }

}
