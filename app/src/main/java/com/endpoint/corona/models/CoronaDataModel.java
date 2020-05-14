package com.endpoint.corona.models;

import java.io.Serializable;
import java.util.List;

public class CoronaDataModel implements Serializable {

private String title;
private double rate;

    public CoronaDataModel(String title, double rate) {
        this.title = title;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
