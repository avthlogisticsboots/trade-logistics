package com.internationaltrade.logistics.Sales.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sales_orders")
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

}
