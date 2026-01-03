package com.internationaltrade.logistics.mapper;

import com.internationaltrade.logistics.goods.dto.GoodsResponseDto;
import com.internationaltrade.logistics.goods.entity.Goods;

public class GoodsMapper {

    public static GoodsResponseDto toDto(Goods goods) {
        GoodsResponseDto response = new GoodsResponseDto();

        response.setId(goods.getId());
        response.setName(goods.getName());
        response.setCategory(goods.getCategory());
        response.setPrice(goods.getPrice());
        response.setStock(goods.getStock());
        response.setCountryOfOrigin(goods.getCountryOfOrigin());
        response.setCreatedDate(goods.getCreatedDate());

        return response;
    }
}
