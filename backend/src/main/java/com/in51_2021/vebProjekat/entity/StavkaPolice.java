package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class StavkaPolice {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "knjiga_id")
    private Knjiga knjiga;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Recenzija recenzija;


    public StavkaPolice() {}

    public StavkaPolice(Knjiga knjiga,Recenzija recenzija){
        this.knjiga=knjiga;
        this.recenzija=recenzija;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }


    @Override
    public String toString() {
        return "StavkaPolice{" +
                "id=" + id +
                //", recenzija=" + recenzija +
                ", knjiga=" + knjiga +
                '}';
    }

}
