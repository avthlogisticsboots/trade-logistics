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

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getPackingSlipNo() {return packingSlipNo;}
    public void setPackingSlipNo(String packingSlipNo) {this.packingSlipNo = packingSlipNo;}

    public LocalDate getCreateDate() {return createDate;}
    public void setCreateDate(LocalDate createDate) {this.createDate = createDate;}

    public SalesOrder getSalesOrder() {return salesOrder;}
    public void setSalesOrder(SalesOrder salesOrder) {this.salesOrder = salesOrder;}

}
