package com.snhu.final_project.Models;

public class StockUpdatePayload {
    private String company;
    private String country;
    private String industry;
    private String sector;
    private String ticker;
    private float change;
    private float gap;
    private float price;
    private int volume;

    public String getCompany() { return this.company; }

    public String getCountry() {
        return this.country;
    }

    public String getIndustry() {
        return this.industry;
    }

    public String getSector() {
        return this.sector;
    }

    public String getTicker() {
        return ticker;
    }

    public float getChange() {
        return this.change;
    }

    public float getGap() {
        return this.gap;
    }

    public float getPrice() {
        return this.price;
    }

    public int getVolume() {
        return this.volume;
    }
}
