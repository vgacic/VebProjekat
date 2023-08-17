package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "korisnik")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    protected String ime;
    @Column
    protected String prezime;

    @Column(unique = true)
    protected String korisnickoIme;

    @Column(unique = true)
    protected String email;
    @Column
    protected String lozinka;

    @Column
    protected Date datumRodjenja;

    @Column
    protected String profilnaSlika;

    @Column
    protected String opis;

    @Column
    @Enumerated(EnumType.STRING)
    private UlogaKorisnika uloga;

    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)  //korisnik ima vise polica(regular,want to read,currently reading,read)
    private Set<Polica> police=new HashSet<>();


    public void napraviPrimarnePolice(){
        police.add(new Polica("WantToRead",TipPolice.WANT_TO_READ));
        police.add(new Polica("CurrentlyReading",TipPolice.CURRENTLY_READING));
        police.add(new Polica("Read",TipPolice.READ);
    }
    public Korisnik(String email, String ime) { //konstruktor koji postavlja ulogu novog korisnika na citaoca i pravi njegove primarne police
        this.email=email;
        this.ime=ime;
        this.uloga=UlogaKorisnika.CITALAC;
        napraviPrimarnePolice();

    }


    public Korisnik(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, UlogaKorisnika uloga)
    {
        this.ime=ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.opis = opis;
        this.uloga = uloga;
        this.police=new HashSet<>();

    }
    public Korisnik(){};

    public UlogaKorisnika getUloga() {
        return uloga;
    }

    public void setUloga(UlogaKorisnika uloga) {
        this.uloga = uloga;
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
        return "Korisnik{" +
                ", emailAdresa='" + email + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", opis='" + opis + '\'' +
                ", uloga=" + ulogaKorisnika + '\'' +
                '}';
    }


}
