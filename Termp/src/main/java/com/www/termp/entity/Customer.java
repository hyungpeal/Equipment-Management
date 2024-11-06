package com.www.termp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private Date rentalDate;
    private Date returnDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Customer(Long customerId, String customerName, String customerPhone, Date rentalDate, Date returnDate, Status status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
    }
}
