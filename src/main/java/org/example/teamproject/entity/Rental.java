package org.example.teamproject.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"customer", "equipment"})
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
    private String rentalDate; // 대여일

    private String returnDate; // 반납 예정 일

    private String actualReturnDate; // 실제 반납한 날짜

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "TEXT DEFAULT 'ON_RENTAL'")
    private Status status;

    @Builder
    public Rental(Customer customer, Equipment equipment, String rentalDate, String returnDate, String actualReturnDate, Status status) {
        this.customer = customer;
        this.equipment = equipment;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
        this.status = (status == null) ? Status.ON_RENTAL : status;
    }
}
