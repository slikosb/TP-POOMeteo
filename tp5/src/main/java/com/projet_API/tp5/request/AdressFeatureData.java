package com.projet_API.tp5.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdressFeatureData {
    private AddressData properties;
    private GeometryData geometry;

    public AdressFeatureData() {

    }

    public AddressData getProperties() {
        return properties;
    }

    public void setProperties(AddressData properties) {
        this.properties = properties;
    }

    public GeometryData getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryData geometry) {
        this.geometry = geometry;
    }
}
