package com.simao.dao.model;

import java.util.Date;

public class Devices {
    private byte[] uuid;

    private String name;

    private Date createdAt;

    public Devices(byte[] uuid, String name, Date createdAt) {
        this.uuid = uuid;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Devices() {
        super();
    }

    public byte[] getUuid() {
        return uuid;
    }

    public void setUuid(byte[] uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}