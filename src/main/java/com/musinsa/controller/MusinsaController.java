package com.musinsa.controller;

import com.musinsa.service.MusinsaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController("musinsaController")
@RequestMapping(value="/product")
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

        // 필수 값 체크
        if(param.get("category") == null || param.get("category").equals("")) {
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

    @RequestMapping(value = "/allList", method = RequestMethod.GET)
    public Map<String, Object> allList() {
        Map<String, Object> retMap = new HashMap<>();
        Map<String, Object> resultData = new HashMap<>();
        int resultCode;
        String resultMsg;

        try {
            resultData = this.musinsaService.allList();
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<String, Object> insertProduct(@RequestBody Map<String, Object> param) {
        Map<String, Object> retMap = new HashMap<>();
        Map<String, Object> resultData = new HashMap<>();
        int resultCode = HttpStatus.BAD_REQUEST.value();
        String resultMsg = "";
        boolean retFlag = true;

        // 필수 값 체크
        if(param.get("brand") == null || param.get("brand").equals("")) {
            resultMsg = "Fail : 브랜드 값은 필수입니다.";
        }else if(param.get("category") == null || param.get("category").equals("")) {
            resultMsg = "Fail : 카테고리 값은 필수입니다.";
        }else if(param.get("price") == null || param.get("price").equals("")) {
            resultMsg = "Fail : 가격 값은 필수입니다.";
        }else {
            retFlag = false;
        }

        if(retFlag){
            retMap.put("resultCode", resultCode);
            retMap.put("resultMsg", resultMsg);
            return retMap;
        }

        try {
            resultData = this.musinsaService.insertProduct(param);
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

    @RequestMapping(value = "/{productKey}", method = RequestMethod.PUT)
    public Map<String, Object> updateProduct(@PathVariable int productKey, @RequestBody Map<String, Object> param) {
        Map<String, Object> retMap = new HashMap<>();
        int resultCode;
        String resultMsg;

        // 상품 키 세팅
        param.put("productKey", productKey);

        // 필수 값 체크
        if((param.get("brand") == null || param.get("brand").equals("")) &&
                (param.get("category") == null || param.get("category").equals("")) &&
                (param.get("price") == null || param.get("price").equals(""))) {
            resultMsg = "Fail : 업데이트 항목 값은 필수입니다.";
            resultCode = HttpStatus.BAD_REQUEST.value();
            retMap.put("resultCode", resultCode);
            retMap.put("resultMsg", resultMsg);
            return retMap;
        }

        try {
            this.musinsaService.updateProduct(param);
            resultCode = HttpStatus.OK.value();
            resultMsg = "Success";
        }catch (Exception e) {
            resultCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            resultMsg = "Fail : " + e.getMessage();
        }

        retMap.put("resultCode", resultCode);
        retMap.put("resultMsg", resultMsg);

        return retMap;
    }

    @RequestMapping(value = "/{productKey}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteProduct(@PathVariable int productKey, @RequestBody Map<String, Object> param) {
        Map<String, Object> retMap = new HashMap<>();
        int resultCode;
        String resultMsg;

        // 상품 키 세팅
        param.put("productKey", productKey);

        try {
            this.musinsaService.deleteProduct(param);
            resultCode = HttpStatus.OK.value();
            resultMsg = "Success";
        }catch (Exception e) {
            resultCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            resultMsg = "Fail : " + e.getMessage();
        }

        retMap.put("resultCode", resultCode);
        retMap.put("resultMsg", resultMsg);

        return retMap;
    }
}
