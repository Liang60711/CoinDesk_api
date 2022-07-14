package com.ricoliang.coindesk_api.model.accept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    @JsonProperty
    private CurrencyInfo USD;
    @JsonProperty
    private CurrencyInfo GBP;
    @JsonProperty
    private CurrencyInfo EUR;

    public Currency() {
    }

    public Currency(CurrencyInfo USD, CurrencyInfo GBP, CurrencyInfo EUR) {
        this.USD = USD;
        this.GBP = GBP;
        this.EUR = EUR;
    }

    public CurrencyInfo getUSD() {
        return USD;
    }

    public CurrencyInfo getGBP() {
        return GBP;
    }

    public CurrencyInfo getEUR() {
        return EUR;
    }
}
