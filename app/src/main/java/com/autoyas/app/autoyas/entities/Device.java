package com.autoyas.app.autoyas.entities;

/**
 * Created by link on 12/05/17.
 */

public class Device {

    private int id;
    private String name;
    private String macAdress;
    private boolean status;

    public Device(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
