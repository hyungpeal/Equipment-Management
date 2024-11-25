package org.example.teamproject.dto;

import lombok.Data;

@Data
public class RentalDTO {
    private Long barcode;
    private String customerName;
    private Long customerId;
    private String customerPhone;
    private String rentalDate;
    private String returnDate;
}
