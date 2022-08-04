package com.musinsa.controller;

import com.musinsa.service.MusinsaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("musinsaController")
@RequestMapping(value="/api")
public class MusinsaController {
    private final MusinsaService musinsaService;

    public MusinsaController(MusinsaService musinsaService) {
        this.musinsaService = musinsaService;
    }

    @RequestMapping(value = "/lowestPriceList", method = RequestMethod.GET)
    public Map<String, Object> lowestPriceList() {
        Map<String, Object> retMap = new HashMap<>();
        Map<String, Object> resultData = new HashMap<>();
        int resultCode;
        String resultMsg;

        try {
            resultData = this.musinsaService.lowestPriceList();
            resultCode = HttpStatus.OK.value();
            resultMsg = "Success";
        }catch (Exception e) {
            resultCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            resultMsg = "Fail : " + e.getMessage();
        }

        retMap.put("resultCode", resultCode);
        retMap.put("resultMsg", resultMsg);
        retMap.put("resultData", resultData);

        return retMap;
    }

    @RequestMapping(value = "/lowestBrand", method = RequestMethod.GET)
    public Map<String, Object> lowestBrand() {
        Map<String, Object> retMap = new HashMap<>();
        Map<String, Object> resultData = new HashMap<>();
        int resultCode;
        String resultMsg;

        try {
            resultData = this.musinsaService.lowestBrand();
            resultCode = HttpStatus.OK.value();
            resultMsg = "Success";
        }catch (Exception e) {
            resultCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            resultMsg = "Fail : " + e.getMessage();
        }

        retMap.put("resultCode", resultCode);
        retMap.put("resultMsg", resultMsg);
        retMap.put("resultData", resultData);

        return retMap;
    }

    @RequestMapping(value = "/categoryHighLow", method = RequestMethod.GET)
    public Map<String, Object> categoryHighLow(@RequestParam Map<String, Object> param) {
        Map<String, Object> retMap = new HashMap<>();
        Map<String, Object> resultData = new HashMap<>();
        int resultCode;
        String resultMsg;

        if(param.get("category") == null || param.get("category").equals("")){
            resultCode = HttpStatus.BAD_REQUEST.value();
            resultMsg = "Fail : 카테고리 값은 필수입니다.";
            retMap.put("resultCode", resultCode);
            retMap.put("resultMsg", resultMsg);
            return retMap;
        }

        try {
            resultData = this.musinsaService.categoryHighLow(param);
            if(resultData == null){
                resultCode = HttpStatus.BAD_REQUEST.value();
                resultMsg = "해당하는 카테고리의 가격 정보가 없습니다.";
            }else {
                resultCode = HttpStatus.OK.value();
                resultMsg = "Success";
            }
        }catch (Exception e) {
            resultCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            resultMsg = "Fail : " + e.getMessage();
        }

        retMap.put("resultCode", resultCode);
        retMap.put("resultMsg", resultMsg);
        retMap.put("resultData", resultData);

        return retMap;
    }
}
