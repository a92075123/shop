package com.example.shop.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class AboutController {

    @GetMapping("about")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/about");
        return mv;
    }

}
