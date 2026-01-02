package com.internationaltrade.logistics.goods.repository;

import com.internationaltrade.logistics.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
