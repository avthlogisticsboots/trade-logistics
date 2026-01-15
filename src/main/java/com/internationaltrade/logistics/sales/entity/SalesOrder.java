package com.internationaltrade.logistics.Sales.Entity;

import com.internationaltrade.logistics.Sales.Enum.OrderStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales_orders")
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ticketno;

    private String customerName;
    private String productName;
    private int quantity;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTicketno() {return ticketno;}
    public void setTicketno(String ticketno) {this.ticketno = ticketno;}

    public String getCustomerName() {return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}

    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public LocalDate getOrderDate() {return orderDate;}
    public void setOrderDate(LocalDate orderDate) {this.orderDate = orderDate;}

    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus status) {this.status = status;}
}
