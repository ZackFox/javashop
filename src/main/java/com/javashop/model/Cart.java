package com.javashop.model;


import java.util.Date;
import java.util.UUID;

public class Cart {
    private UUID id;
    private Date creation;
    private Date update;

    public Cart() {
//REVU лишнее
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation; //REVU дата - объект, который можно изменить снаружи.
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getUpdate() { return update;}

    public void setUpdate(Date update) {
        this.update = update;
    }
}
