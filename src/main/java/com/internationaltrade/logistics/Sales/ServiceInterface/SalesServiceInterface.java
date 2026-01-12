package com.internationaltrade.logistics.Sales.ServiceInterface;

import com.internationaltrade.logistics.Sales.DTO.SalesOrderRequestDTO;
import com.internationaltrade.logistics.Sales.Entity.SalesOrder;

public interface SalesServiceInterface {
    SalesOrder placeOrder(SalesOrderRequestDTO dto);

    SalesOrder shipOrder(Long OrderID);

    SalesOrder packOrder(Long orderId);

}