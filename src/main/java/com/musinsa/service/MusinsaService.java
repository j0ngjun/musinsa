package com.musinsa.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MusinsaService {
    private static final Logger logger = LoggerFactory.getLogger(MusinsaService.class);

    private SqlSessionTemplate sqlSessionTemplate;

    public MusinsaService(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private final String NAME_SPACE = "com.musinsa.MariadbMapper.";

    public Map<String, Object> lowestPrice() {
        Map<String, Object> retMap = new HashMap<String, Object>();

        // 최저가 정보 DB Select
        Map<String,Object> fileInfo = sqlSessionTemplate.selectOne(NAME_SPACE.concat("selectFileInfo"));


        return retMap;
    }

}
