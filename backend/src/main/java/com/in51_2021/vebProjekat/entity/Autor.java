package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor extends Korisnik{

    @Column(name = "aktivan")
    private boolean aktivan;


    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<Knjiga> autoroveKnjige=new HashSet<>();



    public Autor()
    {
        super();
        this.aktivan=false;
        this.setUloga(UlogaKorisnika.AUTOR);
    }
    public Autor(String email,String ime)
    {
        super(email,ime);
        this.aktivan=false;
        this.setUloga(UlogaKorisnika.AUTOR);

    }

    public Autor(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika,String opis,UlogaKorisnika uloga,boolean aktivan)
    {
        super(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga);
        this.aktivan=aktivan;
    }

    public Set<Knjiga> getAutoroveKnjige(){
        return autoroveKnjige;
    }

    public void setAutoroveKnjige(Set<Knjiga> autoroveKnjige)
    {
        this.autoroveKnjige=autoroveKnjige;
    }


    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    @Override
    public String toString() {
        return "Autor{" +
                super.toString() + '\'' +
                ", aktivan=" + aktivan + '\'' +
                ", knjige=" + autoroveKnjige + '\'' +
                '}';
    }

}
