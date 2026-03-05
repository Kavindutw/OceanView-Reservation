package com.example.oceanviewreservation.model;

import java.math.BigDecimal;

public class RoomType {
    private int id;
    private String code;
    private String name;
    private BigDecimal ratePerNight;

    public RoomType() {}

    public RoomType(int id, String code, String name, BigDecimal ratePerNight) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.ratePerNight = ratePerNight;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public BigDecimal getRatePerNight() { return ratePerNight; }

    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setRatePerNight(BigDecimal ratePerNight) { this.ratePerNight = ratePerNight; }
}
