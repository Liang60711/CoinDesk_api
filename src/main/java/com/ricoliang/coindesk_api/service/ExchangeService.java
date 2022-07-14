package com.ricoliang.coindesk_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ricoliang.coindesk_api.convert.JavaScriptMessageConverter;
import com.ricoliang.coindesk_api.model.RateInfo;
import com.ricoliang.coindesk_api.model.accept.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class ExchangeService {

    @Autowired
    private RateInfo rateInfo;

    public String getRate(Integer currentId) throws JsonProcessingException {
        Rate rateObject = getRateInstance();

        if (currentId == 1) {
            return rateObject.getBpi().getUSD().getRate();
        } else if (currentId == 2) {
            return rateObject.getBpi().getGBP().getRate();
        } else if (currentId == 3) {
            return rateObject.getBpi().getGBP().getRate();
        }

        return "Current id not found";

    }

    public RateInfo getRateInfo(Integer currentId) throws ParseException {
        Rate rateObject = getRateInstance();

        // 取得更新時間
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = format.parse(rateObject.getTime().getUpdatedISO());
        String resultTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        rateInfo.setUpdatedTime(resultTime);

        // 取得匯率資訊
        if (currentId == 1) {
            rateInfo.setInfo(rateObject.getBpi().getUSD());
        } else if (currentId == 2) {
            rateInfo.setInfo(rateObject.getBpi().getGBP());
        } else if (currentId == 3) {
            rateInfo.setInfo(rateObject.getBpi().getEUR());
        }

        return rateInfo;
    }


    /**
     * 取得 coindesk 資訊
     * @return Rate
     */
    public Rate getRateInstance(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new JavaScriptMessageConverter());
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

        Rate rate = restTemplate.getForObject(url, Rate.class);

        if (rate == null){
            return null;
        }

        return rate;
    }

}
