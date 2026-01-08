package com.internationaltrade.logistics.Sales.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sales_invoice")
public class SalesInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNo;
    private LocalDate invoiceDate;
    private Double amount;

    @OneToOne
    private SalesOrder salesOrder;
}
