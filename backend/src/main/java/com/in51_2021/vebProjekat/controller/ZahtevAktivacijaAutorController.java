package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.ZahtevAktivacijaAutorDto;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.UlogaKorisnika;
import com.in51_2021.vebProjekat.entity.ZahtevAktivacijaAutor;
import com.in51_2021.vebProjekat.service.ZahtevAktivacijaAutorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/api")
public class ZahtevAktivacijaAutorController {
    @Autowired
    private  ZahtevAktivacijaAutorService zahtevAktivacijaAutorService;

    @GetMapping("/zahtevi")
    public ResponseEntity<List<ZahtevAktivacijaAutorDto>> getZahtevi(HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");
        if(korisnik==null)
        {
            return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
        }
        if(!korisnik.getUloga().equals(UlogaKorisnika.ADMINISTRATOR))
        {
            return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
        }
        List<ZahtevAktivacijaAutor> zahtevAktivacijaAutorList=zahtevAktivacijaAutorService.findAll();
        List<ZahtevAktivacijaAutorDto> dtos = new ArrayList<>();
        for(ZahtevAktivacijaAutor z : zahtevAktivacijaAutorList)
        {
            ZahtevAktivacijaAutorDto dto = new ZahtevAktivacijaAutorDto(z);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/kreirajZahtev") //nema fronta
    public ResponseEntity kreirajZahtev(@RequestBody ZahtevAktivacijaAutor zahtevAktivacijaAutor, HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");
        if(korisnik!=null)
        {
            return new ResponseEntity("Zahtev za aktivaciju moze podneti samo neulogovan korisnik", HttpStatus.FORBIDDEN);
        }
        zahtevAktivacijaAutorService.saveZahtev(zahtevAktivacijaAutor);
        return new ResponseEntity("Uspesno sacuvano",HttpStatus.OK);
    }

    @GetMapping("/obradi/{id}")
    public ResponseEntity<String> obradi(@PathVariable Long id, @RequestParam Boolean obradi, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        if (!korisnik.getUloga().equals(UlogaKorisnika.ADMINISTRATOR)) {
            return new ResponseEntity<>("Niste administrator", HttpStatus.FORBIDDEN);
        }

        ZahtevAktivacijaAutor zahtevAktivacijaAutor = zahtevAktivacijaAutorService.findById(id);

        zahtevAktivacijaAutorService.obradi(obradi, zahtevAktivacijaAutor);

        return new ResponseEntity<>("Uspesno obradjen", HttpStatus.OK);
    }
}
