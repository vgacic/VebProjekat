package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.StatusZahteva;
import com.in51_2021.vebProjekat.entity.ZahtevAktivacijaAutor;

import java.util.Date;

public class ZahtevAktivacijaAutorDto {
    private Long id;

    private StatusZahteva status;

    private String email;

    private String telefon;

    private String poruka;

    private Autor autor;

    private Date datum;

    public ZahtevAktivacijaAutorDto(){}

    public ZahtevAktivacijaAutorDto(Long id, StatusZahteva statusZahteva, String email, String telefon, String poruka, Autor autor, Date datum) {
        this.id = id;
        this.status = status;
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.autor = autor;
        this.datum = datum;
    }

    public ZahtevAktivacijaAutorDto(ZahtevAktivacijaAutor zahtevAktivacija){
        this.id = zahtevAktivacija.getId();
        this.datum = zahtevAktivacija.getDatum();
        this.email = zahtevAktivacija.getEmail();
        this.poruka = zahtevAktivacija.getPoruka();
        this.telefon = zahtevAktivacija.getTelefon();
        this.status = zahtevAktivacija.getStatus();
        this.autor = zahtevAktivacija.getAutor();
    }

    @Override
    public String toString() {
        return "ZahtevAktivacijaAutorDto{" +
                "id=" + id +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", poruka='" + poruka + '\'' +
                ", autor=" + autor +
                ", datum=" + datum +
                '}';
    }
}
