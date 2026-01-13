package com.internationaltrade.logistics.Sales.ServiceInterface;

import java.time.LocalDate;

public interface SalesReportServiceInterface {
    Double getDailySales (LocalDate date);
    Double getMonthlySales (int month, int year);
    Double getYearlySales (int year);
}
