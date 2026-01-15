package com.internationaltrade.logistics.Sales.ServiceClass;

import com.internationaltrade.logistics.Sales.Repository.SalesOrderRepository;
import com.internationaltrade.logistics.Sales.ServiceInterface.SalesReportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SalesReportServiceClass implements SalesReportServiceInterface {

    @Autowired
    private SalesOrderRepository repo;

    @Override
    public Double getDailySales(LocalDate date){
        return repo.findAll().stream().filter(o -> o.getOrderDate().equals(date))
                .mapToDouble(o-> o.getQuantity()*100.0).sum();
    }
    @Override
    public Double getMonthlySales(int month, int year){
        return repo.findAll().stream().filter(o-> o.getOrderDate().getMonthValue() == month && o.getOrderDate()
                .getYear() == year).mapToDouble(o-> o.getQuantity()*100.0).sum();
    }
    @Override
    public Double getYearlySales(int year){
        return repo.findAll().stream().filter(o-> o.getOrderDate().getYear() == year)
                .mapToDouble(o -> o.getQuantity()*100.0).sum();
    }
}
