package com.example.shop.service;

import com.example.shop.common.AjaxResult;
import com.example.shop.dao.FoodOrderMapper;
import com.example.shop.service.vo.FoodOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ShopIndexService {
    private final FoodOrderMapper foodOrderMapper;
    public AjaxResult getProductData() {
        List<FoodOrder> products = foodOrderMapper.selectAll();
        Map map = new HashMap<>();
        map.put("products", products);
        return AjaxResult.success("success", map);
    }
}
