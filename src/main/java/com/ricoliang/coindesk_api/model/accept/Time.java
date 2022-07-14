package com.ricoliang.coindesk_api.model.accept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Time {
    private String updated;
    private String updatedISO;
    private String updateduk;

    public Time(){}

    public Time(String updated, String updatedUSO, String updatedduk) {
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updateduk = updatedduk;
    }

    public String getUpdated() {
        return updated;
    }

    public String getUpdatedISO() {
        return updatedISO;
    }

    public String getUpdatedduk() {
        return updateduk;
    }
}
