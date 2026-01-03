package com.internationaltrade.logistics.goods.service.implementation;

import com.internationaltrade.logistics.exception.DuplicateResourceException;
import com.internationaltrade.logistics.exception.ResourceNotFoundException;
import com.internationaltrade.logistics.goods.dto.GoodsRequestDto;
import com.internationaltrade.logistics.goods.dto.GoodsResponseDto;
import com.internationaltrade.logistics.goods.entity.Goods;
import com.internationaltrade.logistics.goods.repository.GoodsRepository;
import com.internationaltrade.logistics.goods.service.GoodsService;
import com.internationaltrade.logistics.mapper.GoodsMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    @Override
    public Page<GoodsResponseDto> getAllGoods(Integer pageNumber, Integer size) {

        if (pageNumber == null || size == null || pageNumber < 0 || size <= 0) {
            throw new IllegalArgumentException("Page number >= 0 and size must be > 0");
        }

        Pageable pageable = PageRequest.of(pageNumber, size);

        Page<Goods> goodsPage = goodsRepository.findAll(pageable);

        return goodsPage.map(GoodsMapper::toGoodsResponseDto);
    }

    @Override
    public GoodsResponseDto getGoodsById(Long goodsId) {

        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                () -> new ResourceNotFoundException("Goods not found with id " + goodsId)
        );

        return GoodsMapper.toGoodsResponseDto(goods);
    }

    @Transactional
    @Override
    public GoodsResponseDto addGoods(GoodsRequestDto dto) {

        String goodsName = dto.getName().trim();

        if (goodsRepository.existsByNameIgnoreCase(goodsName)) {
            throw new DuplicateResourceException("Goods already exists with name " + goodsName);
        }

        Goods newGoods = new Goods();
        newGoods.setName(goodsName);

        newGoods.setCategory(dto.getCategory());
        newGoods.setPrice(dto.getPrice());
        newGoods.setCountryOfOrigin(dto.getCountryOfOrigin());
        newGoods.setStock(0);

        return GoodsMapper.toGoodsResponseDto(goodsRepository.save(newGoods));
    }

    @Transactional
    @Override
    public GoodsResponseDto updateGoods(Long goodsId, GoodsRequestDto dto) {

        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                () -> new ResourceNotFoundException("Goods not found with id " + goodsId)
        );

        goods.setName(dto.getName());
        goods.setCategory(dto.getCategory());
        goods.setPrice(dto.getPrice());
        goods.setCountryOfOrigin(dto.getCountryOfOrigin());

        return GoodsMapper.toGoodsResponseDto(goodsRepository.save(goods));
    }

    @Transactional
    @Override
    public void deleteGoods(Long goodsId) {

        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                () -> new ResourceNotFoundException("\"Goods not found with id \" + goodsId")
        );

        goodsRepository.delete(goods);
    }

}
