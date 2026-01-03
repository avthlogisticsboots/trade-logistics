package com.internationaltrade.logistics.goods.service;

import com.internationaltrade.logistics.goods.dto.GoodsRequestDto;
import com.internationaltrade.logistics.goods.dto.GoodsResponseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface GoodsService {
    Page<GoodsResponseDto> getAllGoods(Integer pageNumber, Integer size);

    GoodsResponseDto getGoodsById(Long goodsId);

    GoodsResponseDto addGoods(GoodsRequestDto goods);

}
