package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.entity.UlogaKorisnika;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AutorDto {
    public Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;

    private UlogaKorisnika ulogaKorisnika;
    private boolean aktivan;


    private Set<Knjiga> knjige = new HashSet<>();

    private Set<Polica>obicnePolice=new HashSet<>();

    public AutorDto(){}

    public AutorDto(Long id, String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, UlogaKorisnika ulogaKorisnika, boolean aktivan, Set<Knjiga> knjige, Set<Polica> obicnePolice) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.opis = opis;
        this.ulogaKorisnika = ulogaKorisnika;
        this.aktivan = aktivan;
        this.knjige = knjige;
        this.obicnePolice = obicnePolice;
    }


    public AutorDto(Autor autor)
    {
        this.id = autor.getId();
        this.ime = autor.getIme();
        this.prezime = autor.getPrezime();
        this.korisnickoIme = autor.getKorisnickoIme();
        this.email = autor.getEmail();
        this.lozinka = autor.getLozinka();
        this.datumRodjenja = autor.getDatumRodjenja();
        this.profilnaSlika = autor.getProfilnaSlika();
        this.opis = autor.getOpis();
        this.ulogaKorisnika=autor.getUloga();
        this.aktivan=autor.isAktivan();
        this.knjige = autor.getAutoroveKnjige();
        this.obicnePolice=autor.getPolice();
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

    public UlogaKorisnika getUlogaKorisnika() {
        return ulogaKorisnika;
    }

    public void setUlogaKorisnika(UlogaKorisnika ulogaKorisnika) {
        this.ulogaKorisnika = ulogaKorisnika;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Set<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Set<Polica> getObicnePolice() {
        return obicnePolice;
    }

    public void setObicnePolice(Set<Polica> obicnePolice) {
        this.obicnePolice = obicnePolice;
    }
}
