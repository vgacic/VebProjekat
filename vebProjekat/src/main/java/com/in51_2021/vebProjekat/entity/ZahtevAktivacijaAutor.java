package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "zahtev_aktivacije_autor_naloga")
public class ZahtevAktivacijaAutor implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="telefon")
    private String telefon;

    @Column(name="poruka")
    private String poruka;
    @Column(name = "datum")
    private Date datum;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {})
    @JoinColumn(name = "autor_id",referencedColumnName = "id")
    private Autor autor;

    @Column(name = "status")
    private StatusZahteva status;


    public ZahtevAktivacijaAutor(){this.status=StatusZahteva.NA_CEKANJU;}

    public String getEmailAdresa() {
        return email;
    }
    public void setEmailAdresa(String emailAdresa) {
        this.email = emailAdresa;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }
    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Autor getAutor() {return autor;}
    public void setAutor(Autor autor) {this.autor = autor;}

    public StatusZahteva getStatus() {return status;}
    public void setStatus(StatusZahteva status) {this.status = status;}


    @Override
    public String toString() {
        return "ZahtevAktivacijaAutor{" +
                //", id=" + id + '\'' +
                ", email=" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", poruka='" + poruka + '\'' +
                ", datum=" + datum + '\'' +
                ", status=" + status + '\'' +
//                ", autor=" + autor + '\'' +
                '}';
    }

}
