package org.example.teamproject.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Equipment {

    @Id
    private Long barcode;

    @Column(nullable = false)
    private String equipmentName;

    @Column(nullable = false)
    private String acquisitionDate;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String category;

    private String storageLocation;

    @Column(nullable = false)
    private String image;

    private String note;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();


    @Builder(toBuilder = true)
    public Equipment(Long barcode, String equipmentName,
                     String acquisitionDate, int quantity,
                     String category, String storageLocation,
                     String image, Status status, String note) {
        this.barcode = barcode;
        this.equipmentName = equipmentName;
        this.acquisitionDate = acquisitionDate;
        this.quantity = quantity;
        this.category = category;
        this.storageLocation = storageLocation;
        this.image = image;
        this.status = status;
        this.note = note;
    }
}
