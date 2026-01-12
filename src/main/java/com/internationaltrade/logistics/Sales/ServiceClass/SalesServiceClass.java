package com.internationaltrade.logistics.Sales.ServiceClass;
import com.internationaltrade.logistics.Sales.DTO.SalesOrderRequestDTO;
import com.internationaltrade.logistics.Sales.Entity.*;
import com.internationaltrade.logistics.Sales.Enum.OrderStatus;
import com.internationaltrade.logistics.Sales.Repository.*;
import com.internationaltrade.logistics.Sales.ServiceInterface.SalesServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class SalesServiceClass implements SalesServiceInterface {

    @Autowired
    private SalesOrderRepository orderRepo;

    @Autowired
    private SalesInvoiceRepository invoiceRepo;

    @Autowired
    private PackingSlipRepository packingRepo;

    @Override
    public SalesOrder placeOrder(SalesOrderRequestDTO dto) {

        SalesOrder order = new SalesOrder();
        order.setTicketno("TKT-" + System.currentTimeMillis());
        order.setCustomerName(dto.getCustomerName());
        order.setProductName(dto.getProductName());
        order.setQuantity(dto.getQuantity());
        order.setOrderDate(LocalDate.now());
        order.setStatus(OrderStatus.Created);

        order = orderRepo.save(order);

        PackingSlip packing = new PackingSlip();
        packing.setPackingSlipNo("PK-" + System.currentTimeMillis());
        packing.setCreateDate(LocalDate.now());
        packing.setSalesOrder(order);
        packingRepo.save(packing);

        SalesInvoice invoice = new SalesInvoice();
        invoice.setInvoiceNo("INV-" + System.currentTimeMillis());
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setAmount(dto.getQuantity() * 100.0);
        invoice.setSalesOrder(order);
        invoiceRepo.save(invoice);

        return order;
    }

    @Override
    public SalesOrder shipOrder(Long orderId) {

        SalesOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.Shipped);
        return orderRepo.save(order);
    }

    @Override
    public SalesOrder packOrder(Long orderId) {

        SalesOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.Packed);

        return orderRepo.save(order);
    }
}
