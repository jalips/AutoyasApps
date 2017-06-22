package com.autoyas.app.autoyas.entities;

import java.util.Date;

/**
 * Created by link on 22/06/17.
 */

public class Stat {

    private int id;
    private float data;
    private String createdAt;
    private String statisticType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }
}
