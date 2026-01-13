package com.internationaltrade.logistics.Sales.Repository;

import com.internationaltrade.logistics.Sales.Entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}
