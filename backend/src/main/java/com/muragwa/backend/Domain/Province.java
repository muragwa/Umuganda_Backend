package com.muragwa.backend.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Province {
    @Id
    private int id;
    private String name;
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}