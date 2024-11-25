package org.example.teamproject.service;

import jakarta.transaction.Transactional;
import org.example.teamproject.dto.RentalDTO;
import org.example.teamproject.entity.Customer;
import org.example.teamproject.entity.Equipment;
import org.example.teamproject.entity.Rental;
import org.example.teamproject.entity.Status;
import org.example.teamproject.repository.CustomerRepository;
import org.example.teamproject.repository.EquipmentRepository;
import org.example.teamproject.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalReturnService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Transactional
    public Rental rentalEquipment(RentalDTO dto) {

        // Equipment 조회 및 상태 변경
        Equipment equipment = equipmentRepository.findById(dto.getBarcode())
                .orElseThrow(() -> new RuntimeException("기자재를 찾을 수 없음!"));
        if (equipment.getStatus() == Status.ON_RENTAL) {
            System.out.println(equipment.getStatus());
            throw new RuntimeException("기자재가 이미 대여중!");
        }
        equipment.setStatus(Status.ON_RENTAL);
        equipmentRepository.save(equipment);

        // Customer 조회 또는 생성
        Customer customer = customerRepository.findByCustomerId(dto.getCustomerId())
                .orElseGet(() -> customerRepository.save(
                        Customer.builder()
                                .customerName(dto.getCustomerName())
                                .customerPhone(dto.getCustomerPhone())
                                .build()
                ));

        // Rental 저장
        org.example.teamproject.entity.Rental rental = org.example.teamproject.entity.Rental.builder()
                .customer(customer)
                .equipment(equipment)
                .rentalDate(dto.getRentalDate())
                .returnDate(dto.getReturnDate())
                .build();

        return this.rentalRepository.save(rental);
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }
}
