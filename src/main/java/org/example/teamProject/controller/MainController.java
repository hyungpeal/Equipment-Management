package org.example.teamProject.controller;

import org.example.teamProject.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
