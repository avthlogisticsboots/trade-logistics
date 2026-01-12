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

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getInvoiceNo() {return invoiceNo;}
    public void setInvoiceNo(String invoiceNo) {this.invoiceNo = invoiceNo;}

    public LocalDate getInvoiceDate() {return invoiceDate;}
    public void setInvoiceDate(LocalDate invoiceDate) {this.invoiceDate = invoiceDate;}

    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}

    public SalesOrder getSalesOrder() {return salesOrder;}
    public void setSalesOrder(SalesOrder salesOrder) {this.salesOrder = salesOrder;}
}
