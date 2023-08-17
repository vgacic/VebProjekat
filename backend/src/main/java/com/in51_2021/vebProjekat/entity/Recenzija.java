package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "recenzija")
public class Recenzija {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ocena")
    private Long ocena;

    @Column(name = "teks")
    private String tekst;

    @Column(name="datumRecenzije")
    private Date datumRecenzije;

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;


    public Recenzija(){

    }


    public Recenzija(Long ocena, String tekst,Date datumRecenzije) {
        this.ocena = ocena;
        this.tekst = tekst;
        this.datumRecenzije = datumRecenzije;
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
    public String getTekst() {return tekst;}
    public void setTekst(String tekst) {this.tekst = tekst;}
    public Date getDatumRecenzije() {return datumRecenzije;}
    public void setDatumRecenzije(Date datumRecenzije) {this.datumRecenzije = datumRecenzije;}
    public Korisnik getKorisnik() {return korisnik;}
    public void setKorisnik(Korisnik korisnik) {this.korisnik = korisnik;}


    @Override
    public String toString() {
        return "Recenzija{" +
                "id=" + id +
                ", ocena=" + ocena +
                ", tekst='" + tekst + '\'' +
                ", datumRecenzije=" + datumRecenzije +
                //", korisnik=" + korisnik +
                '}';
    }

}
