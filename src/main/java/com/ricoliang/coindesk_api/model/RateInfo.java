package com.ricoliang.coindesk_api.model;

import com.ricoliang.coindesk_api.model.accept.CurrencyInfo;
import org.springframework.stereotype.Component;

@Component
public class RateInfo {

    public String updatedTime;
    public CurrencyInfo info;

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public CurrencyInfo getInfo() {
        return info;
    }

    public void setInfo(CurrencyInfo info) {
        this.info = info;
    }

    public RateInfo() {
    }

    public RateInfo(String updatedTime, CurrencyInfo info) {
        this.updatedTime = updatedTime;
        this.info = info;
    }
}
