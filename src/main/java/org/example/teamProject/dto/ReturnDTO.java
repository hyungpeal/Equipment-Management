package org.example.teamProject.dto;

import lombok.Data;

@Data
public class ReturnDTO {
    private String image;
    private String equipmentName;
    private Long barcode;
    private String customerName;
    private Long customerId;
    private String customerPhone;
    private String rentalDate;
    private String returnDate;
    private String note;
}
