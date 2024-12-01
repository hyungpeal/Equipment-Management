package org.example.teamproject.service;

import org.example.teamproject.entity.Rental;
import org.example.teamproject.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPageService {

    @Autowired
    RentalRepository rentalRepository;

    public List<Rental> findAllByOrderByDesc() {
        return rentalRepository.findAll(Sort.by(Sort.Order.desc("rentalDate")));
    }

}
