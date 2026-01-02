package com.internationaltrade.logistics.goods.controller;

import com.internationaltrade.logistics.goods.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {
    private GoodsService goodsService;
}
