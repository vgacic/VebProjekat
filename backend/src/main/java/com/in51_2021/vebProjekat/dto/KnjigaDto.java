package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.entity.Zanr;

import java.util.Date;

public class KnjigaDto {

    private Long id;
    private String naslov;
    private String ISBN;

    private Date datumObjavljivanja;

    private int brojStrana;

    private String opis;
    private Zanr zanr;
    private double ocena;
    private PodaciOAutoruZaKnjiguDto podaciOAutoruZaKnjiguDto;

    public KnjigaDto(){}

    public KnjigaDto(Long id, String naslov, String ISBN, Date datumObjavljivanja, int brojStrana, String opis,double ocena,Autor autor,Zanr zanr)
    {
        this.id=id;
        this.naslov=naslov;

        this.ISBN=ISBN;
        this.datumObjavljivanja=datumObjavljivanja;
        this.brojStrana=brojStrana;
        this.opis=opis;
        this.ocena=ocena;
        this.podaciOAutoruZaKnjiguDto=new PodaciOAutoruZaKnjiguDto(autor.getId(),autor.getIme(),autor.getPrezime());
        this.zanr=zanr;
    }

    public KnjigaDto(Knjiga knjiga)
    {
        Autor autor=new Autor();  //ovo ovako ide?
        this.id= knjiga.getId();
        this.naslov= knjiga.getNaslov();
        this.ISBN= knjiga.getISBN();
        this.datumObjavljivanja=knjiga.getDatumObjavljivanja();
        this.brojStrana= knjiga.getBrojStrana();
        this.opis=knjiga.getOpis();
        this.ocena= knjiga.getOcena();
        this.podaciOAutoruZaKnjiguDto=new PodaciOAutoruZaKnjiguDto(autor.getId(),autor.getIme(),autor.getPrezime());
        this.zanr=knjiga.getZanr();
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

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
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

    public PodaciOAutoruZaKnjiguDto getAutor() {
        return podaciOAutoruZaKnjiguDto;
    }

    public void setAutor(PodaciOAutoruZaKnjiguDto autor) {
        this.podaciOAutoruZaKnjiguDto = autor;
    }

    @Override
    public String toString() {
        return "KnjigaDto{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
               // ", naslovnaFotografija='" + naslovnaFotografija + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", datumObjavljivanja=" + datumObjavljivanja +
                ", brojStrana=" + brojStrana +
                ", opis='" + opis + '\'' +
                ", zanr=" + zanr +
                ", ocena=" + ocena+
                '}';
    }
}
