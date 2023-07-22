package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="stavka_police")
public class StavkaPolice {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="stavka_police_knjiga",referencedColumnName = "id")
    private Knjiga knjiga;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "stavka_police_id",referencedColumnName = "id")
    private Set<Recenzija> recenzija=new HashSet<>();


    public StavkaPolice() {}

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

    public Set<Recenzija> getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Set<Recenzija> recenzija) {
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
