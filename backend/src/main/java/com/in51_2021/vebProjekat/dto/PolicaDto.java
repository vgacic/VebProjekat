package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.entity.StavkaPolice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PolicaDto {
    private Long id;

    private String naziv;

    private boolean primarna;

    private List<NaslovIdKnjigeDto> knjige;

    public PolicaDto(Long id,String naziv,boolean primarna,Korisnik korisnik,List<NaslovIdKnjigeDto> knjige) {
        this.id = id;
        this.naziv = naziv;
        this.primarna = primarna;
        this.knjige = knjige;
    }

    public PolicaDto(Polica polica) {
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.primarna = polica.isPrimarna();
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

    public List<NaslovIdKnjigeDto> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<NaslovIdKnjigeDto> knjige) {
        this.knjige = knjige;
    }
}
