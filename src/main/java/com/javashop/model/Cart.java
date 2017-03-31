package com.javashop.model;


import java.util.Date;
import java.util.UUID;

public class Cart {
    private UUID id;
    private Date creation;
    private Date update;

    public Cart() {

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getUpdate() { return update;}

    public void setUpdate(Date update) {
        this.update = update;
    }
}
