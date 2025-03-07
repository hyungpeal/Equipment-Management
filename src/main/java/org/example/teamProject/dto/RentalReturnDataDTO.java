package org.example.teamProject.dto;

import lombok.Data;

@Data
public class RentalReturnDataDTO {

    private Long barcode;

    private String equipmentName;

    private int quantity;

    private String image;

    private String note;

    private String status;

    private Long rentalId;

    private String rentalDate;

    private String returnDate;

    private int customerNumber;

    private String customerName;

    private String customerPhone;

}
