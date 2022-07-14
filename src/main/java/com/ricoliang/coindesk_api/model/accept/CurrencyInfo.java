package com.ricoliang.coindesk_api.model.accept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CurrencyInfo {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    private float rate_float;

    public CurrencyInfo() {
    }

    public CurrencyInfo(String code, String symbol, String rate, String description, float rate_float) {
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
        this.rate_float = rate_float;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public float getRate_float() {
        return rate_float;
    }
}
