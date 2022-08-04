package com.musinsa.controller;

import com.musinsa.service.MusinsaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("musinsaController")
@RequestMapping(value="/api")
public class MusinsaController {
    private static final Logger logger = LoggerFactory.getLogger(MusinsaController.class);

    private MusinsaService musinsaService;

    public MusinsaController(MusinsaService musinsaService) {
        this.musinsaService = musinsaService;
    }

    @RequestMapping(value = "/lowestPrice", method = RequestMethod.GET)
    public Map<String, Object> lowestPrice(){
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("home", "home");

        musinsaService.lowestPrice();

        return retMap;
    }
}
