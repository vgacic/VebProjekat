package com.in51_2021.vebProjekat.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Korisnik implements Serializable {

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() + '\'' +
                "}";
    }
}
