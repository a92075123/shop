package com.example.shop.service;

import com.example.shop.common.AjaxResult;
import com.example.shop.common.GlobalException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class TabPageService {

    public AjaxResult getPage(String templateName) {
        try {
            ClassPathResource resource = new ClassPathResource("templates/" + templateName+".html");
            if(!resource.exists()){
                throw new GlobalException("找不到相關頁面");
            }
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
            Map map =new HashMap<>();
            map.put("content", content.toString());
            return AjaxResult.success("success", map);
        } catch (IOException e) {
            throw new GlobalException("發生異常");
        }
    }
}
