package org.example.teamproject.dto;

import lombok.Data;

@Data
public class RentalDTO {
    private Long barcode;
    private String customerName;
    private String customerId;
    private String rentalDate;
    private String returnDate;
}
