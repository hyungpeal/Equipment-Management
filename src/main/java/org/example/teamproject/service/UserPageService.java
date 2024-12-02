package org.example.teamproject.service;

import org.example.teamproject.entity.Rental;
import org.example.teamproject.entity.Status;
import org.example.teamproject.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPageService {

    @Autowired
    RentalRepository rentalRepository;

    public List<List<Rental>> findAllByOrderByDesc() {
        List<Rental> result = rentalRepository.findAll(Sort.by(Sort.Order.desc("rentalDate")));

        List<List<Rental>> resultList = new ArrayList<>();

        List<Rental> rentals = new ArrayList<>();
        List<Rental> returns = new ArrayList<>();

        for(Rental r : result) {

            if (r.getStatus().equals(Status.ON_RENTAL)){
                rentals.add(r);
            } else if (r.getStatus().equals(Status.ON_RETURN)){
                returns.add(r);
            }

        }

        resultList.add(rentals);
        resultList.add(returns);

        return resultList;
    }

}
