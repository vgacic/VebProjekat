package com.in51_2021.vebProjekat.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Admin extends Korisnik implements Serializable {

    public Admin(){}
    public Admin(String email, String ime) {
        super(email, ime);
    }

    public Admin(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, UlogaKorisnika uloga)
    {
        super(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga);
    }


    @Override
    public String toString() {
        return "Admin{" +
                super.toString() + '\'' +
                "}";
    }
}
