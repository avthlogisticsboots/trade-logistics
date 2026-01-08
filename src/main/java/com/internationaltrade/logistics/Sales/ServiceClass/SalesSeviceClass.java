package com.internationaltrade.logistics.Sales.ServiceClass;

import com.internationaltrade.logistics.Sales.ServiceInterface.SalesServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SalesSeviceClass implements SalesServiceInterface {
    @Autowired
    private salesOrderRepository orderRepo
}
