package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Citalac;
import com.in51_2021.vebProjekat.entity.Polica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CitalacDto {
    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;

    private Set<Polica> police=new HashSet<>();

    public CitalacDto(){}

    public CitalacDto(Long id, String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Polica wantToRead, Polica currentlyReading, Polica read,Set<Polica>police)
    {
        this.id=id;
        this.ime=ime;
        this.prezime=prezime;
        this.korisnickoIme=korisnickoIme;
        this.email=email;
        this.lozinka=lozinka;
        this.datumRodjenja=datumRodjenja;
        this.profilnaSlika=profilnaSlika;
        this.opis=opis;
        this.police=police;
    }

    public CitalacDto(Citalac citalac)
    {
        this.id=citalac.getId();
        this.ime=citalac.getIme();
        this.prezime= citalac.getPrezime();
        this.korisnickoIme= citalac.getKorisnickoIme();
        this.email= citalac.getEmail();
        this.lozinka=citalac.getLozinka();
        this.datumRodjenja=citalac.getDatumRodjenja();
        this.profilnaSlika= citalac.getProfilnaSlika();
        this.opis= citalac.getOpis();
        this.police=citalac.getPolice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }

    @Override
    public String toString() {
        return "CitalacDto{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", email='" + email + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", profilnaSlika='" + profilnaSlika + '\'' +
                ", opis='" + opis + '\'' +
                ", police=" + police +
                '}';
    }
}
