package com.internationaltrade.logistics.sales.controller;

import com.internationaltrade.logistics.Sales.DTO.SalesOrderRequestDTO;
import com.internationaltrade.logistics.Sales.Entity.SalesOrder;
import com.internationaltrade.logistics.Sales.ServiceInterface.SalesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesServiceInterface salesService;

    @PostMapping("/order")
    public SalesOrder placeOrder(@RequestBody SalesOrderRequestDTO dto){
        return salesService.placeOrder(dto);
    }

    @PutMapping("/ship/{orderId}")
    public SalesOrder shipOrder(@PathVariable Long orderId){
        return salesService.shipOrder(orderId);
    }

    @PutMapping("/pack/{orderId}")
    public SalesOrder packOrder(@PathVariable Long orderId){
        return salesService.packOrder(orderId);
    }
}
