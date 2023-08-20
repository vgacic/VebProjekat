package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Recenzija;

import java.util.Date;

public class RecenzijaDto {

    private Long id;

    private Long ocena;

    private String tekst;

    private Date datumRecenzije;

    public RecenzijaDto(){}

    public RecenzijaDto(Long id,Long ocena,String tekst,Date datumRecenzije)
    {
        this.id=id;
        this.ocena=ocena;
        this.tekst=tekst;
        this.datumRecenzije=datumRecenzije;
    }

    public RecenzijaDto(Recenzija recenzija){
        this.id= recenzija.getId();
        this.ocena= recenzija.getOcena();
        this.tekst= recenzija.getTekst();
        this.datumRecenzije=recenzija.getDatumRecenzije();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOcena() {
        return ocena;
    }

    public void setOcena(Long ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(Date datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    @Override
    public String toString() {
        return "RecenzijaDto{" +
                "id=" + id +
                ", ocena=" + ocena +
                ", tekst='" + tekst + '\'' +
                ", datumRecenzije=" + datumRecenzije +
                '}';
    }
}
