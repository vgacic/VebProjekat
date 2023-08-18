package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Citalac extends Korisnik{
    public Citalac(){}

    public Citalac(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, UlogaKorisnika uloga){
        super(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga);
    }
}
