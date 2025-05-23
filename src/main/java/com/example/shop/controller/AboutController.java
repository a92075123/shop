package com.example.shop.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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
