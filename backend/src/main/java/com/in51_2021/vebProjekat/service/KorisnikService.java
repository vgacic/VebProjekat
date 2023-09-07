package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.dto.RegistracijaDto;
import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.entity.UlogaKorisnika;
import com.in51_2021.vebProjekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.util.*;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private PolicaService policaService;

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();

    }

    public Korisnik findOne(Long id) {
        return korisnikRepository.findById(id).orElse(null);
    }

    public Korisnik login(String email, String lozinka) {
        Korisnik korisnik = korisnikRepository.getKorisnikByEmail(email);
        if (korisnik == null || !korisnik.getLozinka().equals(lozinka)) {
            return null;
        }
        return korisnik;
    }

    public void register(RegistracijaDto registracijaDto) {

        Korisnik korisnik = new Korisnik(
                registracijaDto.getIme(),
                registracijaDto.getPrezime(),
                registracijaDto.getKorisnickoIme(),
                registracijaDto.getEmail(),
                registracijaDto.getLozinka(),
                Date.from(Instant.now()),
                "slika123",
                "opis123",
                UlogaKorisnika.CITALAC

        );

        Polica read = new Polica("Read", true);
        Polica currently_reading = new Polica("Currently Reading", true);
        Polica want_to_read = new Polica("Want to Read", true);

        policaService.savePolica(read);
        policaService.savePolica(currently_reading);
        policaService.savePolica(want_to_read);



        Set<Polica> police = korisnik.getPolice();

        if (police == null)
            System.out.println("Police su null");


        police.add(read);
        police.add(currently_reading);
        police.add(want_to_read);

        if (police.isEmpty()) {
            System.out.println("Dodavanje polica korisniku prilikom registracije nije uspelo.");
        } else {
            System.out.println("Police su uspesno dodate registrovanom korisniku.");
        }
        korisnik.setPolice(police);

        this.save(korisnik);
    }

    public void registrujAutora(RegistracijaDto registracijaDto) {
        Autor korisnik = new Autor(
                registracijaDto.getIme(),
                registracijaDto.getPrezime(),
                registracijaDto.getKorisnickoIme(),
                registracijaDto.getEmail(),
                registracijaDto.getLozinka(),
                Date.from(Instant.now()),
                "slika123",
                "opis123",
                UlogaKorisnika.AUTOR,
                false

        );

        this.save(korisnik);
    }


    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public Korisnik findByEmail(String email) {
        return korisnikRepository.getByEmail(email);
    }

    public Korisnik findByKorisnickoIme(String korisnickoIme) {
        return korisnikRepository.getByKorisnickoIme(korisnickoIme);
    }

    public Korisnik findById(Long id) {
        return korisnikRepository.findById(id).orElse(null);
    }


    //public Korisnik saveKorisnik(Korisnik korisnik) {
     //   return KorisnikRepository.save(korisnik);
    //}
}
