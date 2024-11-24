package org.example.teamproject.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "equipment_barcode", nullable = false)
    private Equipment equipment;

    @Column(nullable = false) // ISO 8601 형식으로 저장
    private String rentalDate;

    private String returnDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "TEXT DEFAULT 'ON_RENTAL'")
    private Status status;

    @Builder
    public Rental(Customer customer, Equipment equipment, String rentalDate, String returnDate, Status status) {
        this.customer = customer;
        this.equipment = equipment;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = (status == null) ? Status.ON_RENTAL : status;
    }
}
