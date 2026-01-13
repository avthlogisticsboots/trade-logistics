package com.internationaltrade.logistics.Sales.Controller;

import com.internationaltrade.logistics.Sales.ServiceInterface.SalesReportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/sales/report")
public class SalesReportController {

    @Autowired
    SalesReportServiceInterface reportService;

    @GetMapping("/daily")
    public Double daily(@RequestParam String date){
        return reportService.getDailySales(LocalDate.parse(date));
    }
    @GetMapping("/monthly")
    public Double monthly(@RequestParam int month, @RequestParam int year){
        return reportService.getMonthlySales(month, year);
    }
    @GetMapping("yearly")
    public Double yearly(@RequestParam int year){
        return reportService.getYearlySales(year);
    }
}
