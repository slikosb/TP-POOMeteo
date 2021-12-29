package com.projet_API.tp5.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoQueryResult {
    private MeteoData forecast[];

    public MeteoQueryResult() {
    }

    public MeteoData[] getForecast() {
        return forecast;
    }

    public void setForecast(MeteoData forecast[]) {
        this.forecast = forecast;
    }
}
