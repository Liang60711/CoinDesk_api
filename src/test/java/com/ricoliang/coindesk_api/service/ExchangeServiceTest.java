package com.ricoliang.coindesk_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ricoliang.coindesk_api.model.RateInfo;
import com.ricoliang.coindesk_api.model.accept.Rate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExchangeServiceTest {

    @Autowired
    ExchangeService exchangeService;


    @Test
    public void getRateInstance() {
        Rate rateObject = exchangeService.getRateInstance();
        assertNotNull(rateObject);
    }

    @Test
    public void getRate() throws JsonProcessingException {
        Rate rateObject = exchangeService.getRateInstance();

        String value1 = exchangeService.getRate(1);
        String value2 = exchangeService.getRate(0);

        assertNotNull(value1);
        assertEquals("Current id not found", value2);
    }

    @Test
    public void getRateInfo() throws ParseException {
        Rate rateObject = exchangeService.getRateInstance();

        RateInfo value1 = exchangeService.getRateInfo(1);
        RateInfo value2 = exchangeService.getRateInfo(0);

        assertNotNull(value1.getInfo().getRate());
        assertNull(value2);

        assertEquals("USD", value1.getInfo().getCode());
        assertEquals("United States Dollar", value1.getInfo().getDescription());
        assertNotNull(value1.getUpdatedTime());
        assertNull(value2);

    }
}