package com.in51_2021.vebProjekat.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@DiscriminatorValue("Autor")
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivan;


    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Set<Knjiga> autoroveKnjige;


    public Set<Knjiga> getAutoroveKnjige(){
        return autoroveKnjige;
    }

    public void setAutoroveKnjige(Set<Knjiga> autoroveKnjige)
    {
        this.autoroveKnjige=autoroveKnjige;
    }


    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    @Override
    public String toString() {
        return "Autor{" +
                super.toString() + '\'' +
                ", aktivan=" + aktivan + '\'' +
                ", knjige=" + autoroveKnjige + '\'' +
                '}';
    }

}
