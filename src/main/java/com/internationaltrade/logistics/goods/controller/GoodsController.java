package com.internationaltrade.logistics.goods.controller;

import com.internationaltrade.logistics.goods.dto.GoodsRequestDto;
import com.internationaltrade.logistics.goods.dto.GoodsResponseDto;
import com.internationaltrade.logistics.goods.service.GoodsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {
    private GoodsService goodsService;

    @GetMapping
    public ResponseEntity<Page<GoodsResponseDto>> getAllGoods(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        Page<GoodsResponseDto> response = goodsService.getAllGoods(pageNumber, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{goodsId}")
    public ResponseEntity<GoodsResponseDto> getGoodsById(@PathVariable Long goodsId) {
        GoodsResponseDto response = goodsService.getGoodsById(goodsId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GoodsResponseDto> addGoods(
            @Valid @RequestBody GoodsRequestDto goods
    ) {
        GoodsResponseDto response = goodsService.addGoods(goods);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
