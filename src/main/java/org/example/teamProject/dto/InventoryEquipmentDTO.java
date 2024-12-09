package org.example.teamProject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InventoryEquipmentDTO {

    private Long barcode;

    private String equipmentName;

    private String acquisitionDate;

    private int quantity;

    private String category;

    private String storageLocation;

    private String image;

    private String note;

    private String status;

}
