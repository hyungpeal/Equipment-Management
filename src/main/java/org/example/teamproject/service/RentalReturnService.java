package org.example.teamproject.service;

import jakarta.transaction.Transactional;
import org.example.teamproject.dto.RentalReturnDataDTO;
import org.example.teamproject.entity.Customer;
import org.example.teamproject.entity.Rental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.example.teamproject.entity.Equipment;
import org.example.teamproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.example.teamproject.entity.Status;
import org.example.teamproject.repository.EquipmentRepository;
import org.example.teamproject.repository.RentalRepository;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

@Service
public class RentalReturnService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RentalRepository rentalRepository;

    public RentalReturnDataDTO getEquipmentDataByBarcode(Long barcode) {
        // Equipment 조회
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(barcode);

        if (optionalEquipment.isEmpty()) {
            throw new IllegalArgumentException("해당 바코드의 기자재를 찾을 수 없습니다.");
        }

        Equipment equipment = optionalEquipment.get();
        RentalReturnDataDTO dto = new RentalReturnDataDTO();

        // BeanUtils로 Equipment -> DTO 복사
        BeanUtils.copyProperties(equipment, dto);
        dto.setStatus(equipment.getStatus().toString()); // enum은 문자열로 수동 변환 필요

        // 상태에 따른 추가 처리
        if (equipment.getStatus() == Status.ON_FREE) {
            // 대여 가능 상태면 바로 반환해주기
            return dto;
        } else if (equipment.getStatus() == Status.ON_RENTAL) {
            // 대여 중 상태면 날짜 정보와 빌린 사람 정보 추가해서 반환해주기
            Rental rental = rentalRepository.findFirstByEquipmentBarcodeOrderByRentalDateDesc(barcode)
                    .orElseThrow(() -> new IllegalArgumentException("해당 기자재의 대여 정보를 찾을 수 없습니다."));

            // BeanUtils로 Rental -> DTO 복사
            BeanUtils.copyProperties(rental, dto);
            BeanUtils.copyProperties(rental.getCustomer(), dto); // Customer 데이터를 DTO로 복사
            return dto;
        } else {
            throw new IllegalStateException("알 수 없는 상태입니다.");
        }
    }

    // 빌리기 함수
    @Transactional
    public void rentalEquipment(RentalReturnDataDTO dto) {

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
        Customer customer = customerRepository.findByCustomerNumber(dto.getCustomerNumber())
                .orElseGet(() -> customerRepository.save(
                        Customer.builder()
                                .customerNumber(dto.getCustomerNumber())
                                .customerName(dto.getCustomerName())
                                .customerPhone(dto.getCustomerPhone())
                                .build()
                ));

        // Rental 저장
        Rental rental = Rental.builder()
                .customer(customer)
                .equipment(equipment)
                .rentalDate(dto.getRentalDate())
                .returnDate(dto.getReturnDate())
                .build();

        rentalRepository.save(rental);
    }

    
    // 반납 함수
    @Transactional
    public void returnEquipment(RentalReturnDataDTO dto) {

        // Equipment 조회 및 상태 변경
        Equipment equipment = equipmentRepository.findById(dto.getBarcode())
                .orElseThrow(() -> new RuntimeException("기자재를 찾을 수 없음!"));
        if (equipment.getStatus() == Status.ON_FREE) {
            System.out.println(equipment.getStatus());
            throw new RuntimeException("이 기자재는 이미 반납됐습니다!");
        }
        equipment.setStatus(Status.ON_FREE);
        equipmentRepository.save(equipment);

        // 반납한 날짜 저장 후 상태 변경
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(fmt);


        Rental rental = rentalRepository.findById(dto.getRentalId())
                .orElseThrow(() -> new RuntimeException("대여 정보를 찾을 수 없음!"));

        rental.setActualReturnDate(formattedDate);
        rental.setStatus(Status.ON_RETURN);

    }

}
