package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Knjiga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naslov")
    private String naslov;
    @Column(name = "naslovnaFotografija")
    private String naslovnaFotografija;

    @Column(unique = true,name = "ISBN")
    private String ISBN;

    @Column(name = "datumObjavljivanja")
    private Date datumObjavljivanja;

    @Column(name ="brojStrana")
    private Long brojStrana;
    @Column(name = "opis")
    private String opis;

    @OneToOne  //knjiga ima jedan zanr
    @JoinColumn(name = "zanr_id")
    private Zanr zanr;

    @Column(name = "ocena")
    private double ocena;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Autor autor;

    public Knjiga(){}


    public Knjiga(String naslov,String naslovnaFotografija,String ISBN,Date datumObjavljivanja,Long brojStrana,double ocena,Zanr zanr)
    {
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.ISBN = ISBN;
        this.datumObjavljivanja = datumObjavljivanja;
        this.brojStrana = brojStrana;
        this.opis = opis;
        this.ocena = ocena;
        this.zanr = zanr;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public Long getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(Long brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
