package org.example.teamproject.controller;

import org.example.teamproject.entity.Equipment;
import org.example.teamproject.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    EquipmentService service;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/rentalReturnPage")
    public String rentalReturnPage() {

        return "rentalReturnPage";
    }

    @GetMapping("/inventoryPage")
    public String inventoryPage() {
        return "inventoryPage";
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }

}
