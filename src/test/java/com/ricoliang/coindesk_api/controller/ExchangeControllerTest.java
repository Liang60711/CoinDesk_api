package com.ricoliang.coindesk_api.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static Logger log = LoggerFactory.getLogger(ExchangeController.class);


    @Test
    void getRate() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getRate/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString();

        assertNotNull(body);
        log.info(body);
    }

    @Test
    void getRateInfo() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getRateInfo/2");
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString();

        assertNotNull(body);
        log.info(body);
    }
}