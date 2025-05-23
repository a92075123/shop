package com.example.shop.controller;


import com.example.shop.service.ShopIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopIndexController {

    private final ShopIndexService shopIndexService;

    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

}
