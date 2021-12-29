package com.projet_API.tp5.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressQueryResult {
    @JsonProperty
    private AdressFeatureData[] features;

    public AddressQueryResult() {}

    public AdressFeatureData[] getFeatures() {
        return features;
    }
    public void setFeatures(AdressFeatureData[] features) {
        this.features = features;
    }
}
