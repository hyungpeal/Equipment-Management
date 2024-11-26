package org.example.teamproject.controller;

import org.example.teamproject.dto.InventoryEquipmentDTO;
import org.example.teamproject.dto.RentalDTO;
import org.example.teamproject.dto.RentalReturnDataDTO;
import org.example.teamproject.entity.Equipment;
import org.example.teamproject.entity.Rental;
import org.example.teamproject.service.RentalReturnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rentalReturnPage")
@RestController
public class RentalReturnRestController {

    @Autowired
    RentalReturnService rentalReturnService;

    @GetMapping("/getEquipmentData")
    public RentalReturnDataDTO getEquipmentData(@RequestParam("barcode") Long barcode) {

        return rentalReturnService.getEquipmentDataByBarcode(barcode);

    }

    @PostMapping("/rentalReturn")
    public ResponseEntity<?> rentalEquipment(@ModelAttribute RentalReturnDataDTO rentalReturnDataDTO) {

//        System.out.println(rentalReturnDataDTO.getStatus());

        if(rentalReturnDataDTO.getStatus().equals("ON_FREE")) {

            rentalReturnService.rentalEquipment(rentalReturnDataDTO);
            return ResponseEntity.ok().build();

        } else if(rentalReturnDataDTO.getStatus().equals("ON_RENTAL")) {

            rentalReturnService.returnEquipment(rentalReturnDataDTO);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.badRequest().build();
    }

}
