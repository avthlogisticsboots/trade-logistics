package com.internationaltrade.logistics.Sales.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "packing_slips")
public class PackingSlip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String packingSlipNo;
    private LocalDate createDate;

    @OneToOne
    private SalesOrder salesOrder;
}
