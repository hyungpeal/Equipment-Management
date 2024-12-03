package org.example.teamproject.controller;

import org.example.teamproject.dto.RentalReturnDataDTO;
import org.example.teamproject.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rentalReturnPage")
@RestController
public class RentalReturnRestController {

    @Autowired
    RentalService rentalService;

    @GetMapping("/getEquipmentData")
    public RentalReturnDataDTO getEquipmentData(@RequestParam("barcode") Long barcode) {

        return rentalService.getEquipmentDataByBarcode(barcode);

    }

    @PostMapping("/rentalReturn")
    public ResponseEntity<String> rentalEquipment(@ModelAttribute RentalReturnDataDTO rentalReturnDataDTO) {

//        System.out.println(rentalReturnDataDTO.getStatus());

        if(rentalReturnDataDTO.getStatus().equals("ON_FREE")) {

            rentalService.rentalEquipment(rentalReturnDataDTO);
            return ResponseEntity.ok().body("{\"status\": \"rental\"}");

        } else if(rentalReturnDataDTO.getStatus().equals("ON_RENTAL")) {

            rentalService.returnEquipment(rentalReturnDataDTO);
            return ResponseEntity.ok().body("{\"status\": \"return\"}");

        }

        return ResponseEntity.badRequest().body("{\"status\": \"error\"}");
    }

}
