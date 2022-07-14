package com.ricoliang.coindesk_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ricoliang.coindesk_api.model.RateInfo;
import com.ricoliang.coindesk_api.service.ExchangeService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@Validated
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    /**
     * 說明: 輸入幣別，返回匯率
     * @param currentId
     * @return
     */
    @GetMapping("/getRate/{currentId}")
    public String getRate(@PathVariable @NotNull Integer currentId) throws JsonProcessingException {

        return exchangeService.getRate(currentId);

    }

    /**
     *
     */
    @GetMapping("/getRateInfo/{currentId}")
    public RateInfo getRateInfo(@PathVariable @NotNull Integer currentId) throws ParseException {

        return  exchangeService.getRateInfo(currentId);
    }
}
