package com.musinsa.controller;

import com.musinsa.service.MusinsaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
public class MusinsaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusinsaService musinsaService;

    @Test
    void lowestPriceList() throws Exception {

    }
}
