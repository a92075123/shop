package com.example.shop.controller;

import com.example.shop.common.AjaxResult;
import com.example.shop.service.TabPageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class TabPageController {


    private final TabPageService tabPageService;
    /**
     * 讀取template檔案範例
     * @param templateName 要讀取的template檔案名稱（不包含路徑）
     * @return template檔案內容
     */
    @PostMapping("/pageTab")
    public AjaxResult getTemplate(@RequestBody String templateName) {
          return tabPageService.getPage(templateName);
    }
}
