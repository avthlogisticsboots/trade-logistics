package com.internationaltrade.logistics.goods.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsResponseDto {

    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private String countryOfOrigin;
    private LocalDateTime createdDate;
}