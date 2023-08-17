package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "tip")
    private TipPolice tip;
    @Column
    private boolean primarna;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name="polica_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="stavkaPolice_id",referencedColumnName = "id"))
    private Set<StavkaPolice> stavkePolice=new HashSet<>();


    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    public Polica(String naziv, boolean primarna) {
        this.naziv = naziv;
        this.primarna = primarna;

    }

    public Polica() {
        this.tip = TipPolice.REGULAR;
    }

    public Polica(String naziv) {

        this.naziv = naziv;
        this.tip = TipPolice.REGULAR;
    }
    public Polica(String naziv, TipPolice tip) {
        this.naziv = naziv;
        this.tip = tip;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<StavkaPolice> getStavkaPolice() {
        return stavkaPolice;
    }

    public void setStavkaPolice(Set<StavkaPolice> stavkaPolice) {
        this.stavkaPolice = stavkaPolice;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean getPrimarna() {
        return primarna;
    }

    public void setPrimarna(boolean primarna) {
        this.primarna = primarna;
    }

    @Override
    public String toString() {
        return "Polica{" +
                "id=" + id + '\'' +
                ", naziv='" + naziv + '\'' +
                ", stavkaPolice=" + stavkaPolice + '\'' +
                ", tip=" + tip.toString() + '\'' +
                '}';
    }
}
