package com.ricoliang.coindesk_api.model.accept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    private Time time;
    private String disclaimer;
    private String chartName;
    private Currency bpi;

    public Rate() {}

    public Rate(Time time, String disclaimer, String chartName, Currency bpi) {
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
    }

    public Time getTime() {
        return time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public Currency getBpi() {
        return bpi;
    }
}

