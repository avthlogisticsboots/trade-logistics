package com.internationaltrade.logistics.Sales.DTO;

public class SalesOrderRequestDTO {
    private String CustomerName;
    private String ProductName;
    private int Quantity;

    public String getCustomerName() {return CustomerName;}
    public void setCustomerName(String customerName) {this.CustomerName = customerName;}

    public String getProductName() {return ProductName;}
    public void setProductName(String productName) {this.ProductName = productName;}

    public int getQuantity() {return Quantity;}

    public void setQuantity(int quantity) {this.Quantity = quantity;}
}

