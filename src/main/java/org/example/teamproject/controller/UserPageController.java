package org.example.teamproject.controller;

import org.example.teamproject.entity.Rental;
import org.example.teamproject.service.RentalReturnService;
import org.example.teamproject.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/userPage")
@RestController
public class UserPageController {

    @Autowired
    UserPageService userPageService;

    @GetMapping("/getRentalData")
    public List<List<Rental>> getRentalData() {
        List<List<Rental>> tmp = userPageService.findAllByOrderByDesc();
        System.out.println(tmp);

        return tmp;
    }

}
