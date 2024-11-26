package org.example.teamproject.controller;

import org.example.teamproject.entity.Rental;
import org.example.teamproject.service.RentalReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/userPage")
@RestController
public class UserPageController {

    @Autowired
    RentalReturnService rentalReturnService;

    @GetMapping("/getRentalData")
    public List<Rental> getRentalData() {
        List<Rental> tmp = rentalReturnService.findAll();
        System.out.println(tmp);
        return tmp;
    }

}
