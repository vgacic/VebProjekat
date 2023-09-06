package com.in51_2021.vebProjekat.repository;


import com.in51_2021.vebProjekat.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {


    Korisnik getKorisnikByEmail(String email);

    Object getKorisnikByKorisnickoIme(String korisnickoIme);

    Korisnik getByEmail(String email);

    Korisnik getByKorisnickoIme(String korisnickoIme);
}
