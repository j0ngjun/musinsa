package com.musinsa.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusinsaService {
    private final SqlSessionTemplate sqlSessionTemplate;

    public MusinsaService(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private final String NAME_SPACE = "com.musinsa.MariadbMapper.";

    public Map<String, Object> lowestPriceList() {
        Map<String, Object> retMap = new HashMap<>();
        int totalPrice = 0;

        // 모든 카테고리의 상품 구매 시 최저가 정보 DB Select
        List<Map<String, Object>> lowestPriceList = sqlSessionTemplate.selectList(NAME_SPACE.concat("selectLowestPriceList"));
        retMap.put("lowestPriceList", lowestPriceList);

        for(Map<String, Object> lowestPrice : lowestPriceList){
            totalPrice += (int) lowestPrice.get("price");
        }

        retMap.put("totalPrice", totalPrice);

        return retMap;
    }

    public Map<String, Object> lowestBrand() {
        Map<String, Object> retMap = new HashMap<>();

        // 한 브랜드로만 구매 시 최저가 정보 DB Select
        Map<String, Object> lowestBrand = sqlSessionTemplate.selectOne(NAME_SPACE.concat("selectLowestBrand"));
        retMap.put("lowestBrand", lowestBrand);

        return retMap;
    }

    public Map<String, Object> categoryHighLow(Map<String, Object> param) {
        Map<String, Object> retMap = new HashMap<>();

        // 카테고리 내 최저가 정보 DB Select
        Map<String, Object> lowestPrice = sqlSessionTemplate.selectOne(NAME_SPACE.concat("selectCategoryHighestLowestPrice"), param);
        param.put("highest", true);
        Map<String, Object> highestPrice = sqlSessionTemplate.selectOne(NAME_SPACE.concat("selectCategoryHighestLowestPrice"), param);

        if(lowestPrice == null && highestPrice == null) {
            return null;
        }

        retMap.put("lowestPrice", lowestPrice);
        retMap.put("highestPrice", highestPrice);

        return retMap;
    }

    public Map<String, Object> allList() {
        Map<String, Object> retMap = new HashMap<>();

        // 모든 상품 정보 List DB Select
        List<Map<String, Object>> allList = sqlSessionTemplate.selectList(NAME_SPACE.concat("selectAllList"));
        retMap.put("allList", allList);

        return retMap;
    }

    public Map<String, Object> insertProduct(Map<String, Object> param) throws Exception {
        Map<String, Object> retMap = new HashMap<>();

        // 브랜드 상품 가격 추가 DB Insert
        int result = sqlSessionTemplate.insert(NAME_SPACE.concat("insertProduct"), param);
        if(result <= 0) {
            throw new Exception("상품 등록 중 오류가 발생하였습니다.");
        }else {
            retMap.put("productKey", param.get("productKey"));
        }

        return retMap;
    }

    public void updateProduct(Map<String, Object> param) throws Exception {
        // 브랜드 상품 가격 업데이트 DB Insert
        int result = sqlSessionTemplate.update(NAME_SPACE.concat("updateProduct"), param);
        if(result <= 0) {
            throw new Exception("상품 업데이트 중 오류가 발생하였습니다.");
        }
    }

    public void deleteProduct(Map<String, Object> param) throws Exception {
        // 브랜드 상품 가격 삭제 DB Insert
        int result = sqlSessionTemplate.delete(NAME_SPACE.concat("deleteProduct"), param);
        if(result <= 0) {
            throw new Exception("상품 삭제 중 오류가 발생하였습니다.");
        }
    }

}
