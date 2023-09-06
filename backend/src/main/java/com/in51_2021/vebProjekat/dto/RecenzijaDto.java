package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Recenzija;

import java.util.Date;

public class RecenzijaDto {

    private Long id;

    private Float ocena;

    private String tekst;
    private Long idStavke;

    public RecenzijaDto(){}

    public RecenzijaDto(Long id,Float ocena,String tekst,Long idStavke)
    {
        this.id=id;
        this.ocena=ocena;
        this.tekst=tekst;
        this.idStavke=idStavke;

    }

    public Long getIdStavke() {
        return idStavke;
    }

    public void setIdStavke(Long idStavke) {
        this.idStavke = idStavke;
    }

    public RecenzijaDto(Recenzija recenzija){
        this.id= recenzija.getId();
        this.ocena= recenzija.getOcena();
        this.tekst= recenzija.getTekst();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }



}
