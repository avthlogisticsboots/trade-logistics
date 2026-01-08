package com.internationaltrade.logistics.Sales.Controller;

import com.internationaltrade.logistics.Sales.ServiceInterface.SalesReportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sales/report")
public class SalesReportController {

    @Autowired
    SalesReportServiceInterface reportService;

    @GetMapping("/Daily")
    public Double daily(@RequestParam )

    @GetMapping("/Monthly")
    public Double

    @GetMapping("Yearly")
    public Double
}
