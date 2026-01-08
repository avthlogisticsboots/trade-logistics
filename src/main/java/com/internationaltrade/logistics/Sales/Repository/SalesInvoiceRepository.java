package com.internationaltrade.logistics.Sales.Repository;

import com.internationaltrade.logistics.Sales.Entity.SalesInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long> {
}
