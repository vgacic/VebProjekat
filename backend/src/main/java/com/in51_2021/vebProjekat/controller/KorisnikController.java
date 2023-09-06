package com.in51_2021.vebProjekat.controller;
import com.in51_2021.vebProjekat.dto.KorisnikDto;
import com.in51_2021.vebProjekat.dto.NazivIdPoliceDto;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.service.KorisnikService;
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
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/cao")
    public String cao() {
        return "cao cao";
    }


    //svi korisnici
    @GetMapping("/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session) {
        List<Korisnik> listaKorisnika = korisnikService.findAll();

        List<KorisnikDto> korisniciDto = new ArrayList<>();
        for (Korisnik korisnik : listaKorisnika) {
            KorisnikDto korisnikDto = new KorisnikDto(korisnik);
            korisniciDto.add(korisnikDto);
        }
        return ResponseEntity.ok(korisniciDto);
    }

    //pretraga korisnika po id-ju

    @GetMapping(value = {"/korisnik/{id}", "/korisnik"})
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable(required = false) Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (id == null && korisnik != null) {
            id = korisnik.getId();
        }

        korisnik = korisnikService.findOne(id); //iz repository pozove metodu za nalazenje po idju

        if (korisnik == null) {
            return new ResponseEntity("Korisnik nije pronadjen.", HttpStatus.NOT_FOUND);
        }

        List<NazivIdPoliceDto> policeDtos = new ArrayList<>(); //niz objekata polica u niz stringova naziva
        for (Polica p : korisnik.getPolice()) {
            policeDtos.add(new NazivIdPoliceDto(p.getId(), p.getNaziv()));
        }

        KorisnikDto korisnikDto = new KorisnikDto(
                korisnik.getId(),
                korisnik.getIme(),
                korisnik.getPrezime(),
                korisnik.getKorisnickoIme(),
                korisnik.getEmail(),
                korisnik.getLozinka(),
                korisnik.getDatumRodjenja(),
                korisnik.getProfilnaSlika(),
                korisnik.getOpis(),
                korisnik.getUloga(),
                policeDtos
        );

        return new ResponseEntity<>(korisnikDto, HttpStatus.OK);
    }
}
