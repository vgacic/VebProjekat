package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.entity.StavkaPolice;

import java.util.HashSet;
import java.util.Set;

public class PolicaDto {
    private Long id;

    private String naziv;

    private boolean primarna;

    private Korisnik korisnik;
    private Set<StavkaPolice>stavkePolice=new HashSet<>();

    PolicaDto(){}
    PolicaDto(Long id,String naziv,boolean primarna,Korisnik korisnik,Set<StavkaPolice> stavkePolice)
    {
        this.id = id;
        this.naziv = naziv;
        this.primarna = primarna;
        this.korisnik = korisnik;
        this.stavkePolice=stavkePolice;
    }

    public PolicaDto(Polica polica) {
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.primarna = polica.isPrimarna();
        this.korisnik = polica.getKorisnik();
        this.stavkePolice = polica.getStavkePolice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isPrimarna() {
        return primarna;
    }

    public void setPrimarna(boolean primarna) {
        this.primarna = primarna;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Set<StavkaPolice> getStavkePolice() {
        return stavkePolice;
    }

    public void setStavkePolice(Set<StavkaPolice> stavkePolice) {
        this.stavkePolice = stavkePolice;
    }

    @Override
    public String toString() {
        return "PolicaDto{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", primarna=" + primarna +
                ", korisnik=" + korisnik +
                ", stavkePolice=" + stavkePolice +
                '}';
    }
}
