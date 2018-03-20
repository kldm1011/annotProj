package de.myDom.domain;

import java.io.Serializable;

public class Auto implements Serializable {

    private final String marke;
    private final String model;
    private final int ps;

    public Auto(String marke, String model, int ps) {
        this.marke = marke;
        this.model = model;
        this.ps = ps;
    }

    public String getMarke() {
        return marke;
    }

    public String getModel() {
        return model;
    }

    public int getPs() {
        return ps;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marke='" + marke + '\'' +
                ", model='" + model + '\'' +
                ", ps=" + ps +
                '}';
    }
}
