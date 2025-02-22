package org.example.teamProject.controller;

import org.example.teamProject.entity.Rental;
import org.example.teamProject.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/index")
@RestController
public class MainRestController {

    @Autowired
    RentalService rentalService;

    // 연체자 db 에서 가져오기
    @GetMapping("/getRentalData")
    public List<Rental> getRentalData() {
        return rentalService.getDelinquentData();
    }

}
