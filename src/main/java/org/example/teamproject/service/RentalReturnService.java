package org.example.teamproject.service;

import jakarta.transaction.Transactional;
import org.example.teamproject.dto.RentalDTO;
import org.example.teamproject.entity.Customer;
import org.example.teamproject.entity.Equipment;
import org.example.teamproject.entity.Status;
import org.example.teamproject.repository.CustomerRepository;
import org.example.teamproject.repository.EquipmentRepository;
import org.example.teamproject.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalReturnService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RentalRepository rentalRepository;

//    @Transactional
//    public org.example.teamproject.entity.Rental rentalEquipment(RentalDTO rentalDTO) {
//        // Equipment 조회 및 상태 변경
//        Equipment equipment = equipmentRepository.findById(barcode)
//                .orElseThrow(() -> new RuntimeException("Equipment not found"));
//        if (equipment.getStatus() != Status.ON_FREE) {
//            throw new RuntimeException("Equipment is already rented");
//        }
//        equipment.setStatus(Status.ON_RENTAL);
//        equipmentRepository.save(equipment);
//
//        // Customer 조회 또는 생성
//        Customer customer = customerRepository.findByCustomerId(customerId)
//                .orElseGet(() -> customerRepository.save(
//                        Customer.builder()
//                                .customerName(customerId)
//                                .customerPhone("UNKNOWN") // 기본값
//                                .status(Status.ON_RENTAL)
//                                .build()
//                ));
//
//        // Rental 저장
//        org.example.teamproject.entity.Rental rental = org.example.teamproject.entity.Rental.builder()
//                .customer(customer)
//                .equipment(equipment)
//                .rentalDate(rentalDate)
//                .returnDate(returnDate)
//                .build();
//
//        return this.rentalRepository.save(rental);
//    }
    
    // TODO 프론트에 table 의 phone 번호 받는 부분 추가하고 dto 에도 phone 번호 받게 만들기
}
