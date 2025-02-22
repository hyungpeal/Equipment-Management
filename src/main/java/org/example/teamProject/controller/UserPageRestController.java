package org.example.teamProject.controller;

import org.example.teamProject.entity.Rental;
import org.example.teamProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/userPage")
@RestController
public class UserPageRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getRentalData")
    public List<List<Rental>> getRentalData() {
        List<List<Rental>> tmp = customerService.findAllByOrderByDesc();
        System.out.println(tmp);

        return tmp;
    }

    @GetMapping("/getRentalSearch")
    public List<Rental> getRentalSearch(@RequestParam("keyword") String keyword) {
        return customerService.rentalSearchAll(keyword);
    }

    @GetMapping("/getReturnSearch")
    public List<Rental> getReturnSearch(@RequestParam("keyword") String keyword) {
        return customerService.returnSearchAll(keyword);
    }

}
