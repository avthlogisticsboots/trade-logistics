package com.internationaltrade.logistics.Sales.ServiceInterface;

import com.internationaltrade.logistics.Sales.DTO.SalesOrderRequestDTO;
import com.internationaltrade.logistics.Sales.Entity.SalesInvoice;
import com.internationaltrade.logistics.Sales.Entity.SalesOrder;

import java.time.LocalDate;

public interface SalesServiceInterface {
    SalesOrder placeOrder(SalesOrderRequestDTO dto);

    SalesOrder shipOrder(Long OrderID);

}