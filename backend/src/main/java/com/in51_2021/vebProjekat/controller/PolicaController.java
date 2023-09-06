package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.NaslovIdKnjigeDto;
import com.in51_2021.vebProjekat.dto.PolicaDto;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.entity.StavkaPolice;
import com.in51_2021.vebProjekat.service.KorisnikService;
import com.in51_2021.vebProjekat.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:8081"}, allowCredentials = "true")
public class PolicaController {
    @Autowired
    private PolicaService policaService;
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/polica/{id}")
    private ResponseEntity<PolicaDto> getPolica(@PathVariable Long id) {
        Polica polica = policaService.findOne(id);

        PolicaDto policaDto = new PolicaDto(polica);
        List<NaslovIdKnjigeDto> knjige = new ArrayList<>();
        for (StavkaPolice s : polica.getStavkePolice()) {
            NaslovIdKnjigeDto dto = new NaslovIdKnjigeDto(s.getKnjiga().getId(), s.getKnjiga().getNaslov());
            if (s.getRecenzija() != null) {
                dto.setOcena(s.getRecenzija().getOcena());
            }
            knjige.add(dto);
        }
        policaDto.setKnjige(knjige);
        return new ResponseEntity<>(policaDto, HttpStatus.OK);
    }

    @PostMapping("/napraviPolicu")
    private ResponseEntity<String> napraviPolicu(@RequestParam String nazivPolice, HttpSession session){
        Korisnik korisnik=(Korisnik)session.getAttribute("korisnik");


        korisnik = korisnikService.findOne(korisnik.getId());
       for(Polica p : korisnik.getPolice())
       {
           if(p.getNaziv().equals(nazivPolice))
           {
               return new ResponseEntity<>("Vec postoji polica sa datim imenom!",HttpStatus.BAD_REQUEST);
           }
       }
       Polica polica = new Polica(nazivPolice,false);

       korisnik.getPolice().add(polica);

       korisnikService.save(korisnik);


        return new ResponseEntity<>("Uspesno dodata polica!",HttpStatus.OK);
    }
}
