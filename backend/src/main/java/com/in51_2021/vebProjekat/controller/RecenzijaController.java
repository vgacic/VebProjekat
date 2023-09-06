package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.RecenzijaDto;
import com.in51_2021.vebProjekat.dto.StavkaPoliceDto;
import com.in51_2021.vebProjekat.dto.ZanrDto;
import com.in51_2021.vebProjekat.entity.*;
import com.in51_2021.vebProjekat.service.KorisnikService;
import com.in51_2021.vebProjekat.service.RecenzijaService;
import com.in51_2021.vebProjekat.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/api")
public class RecenzijaController {

    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    @GetMapping("/recenzije")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije(HttpSession session)
    {
        List<Recenzija> listaRecenzija=recenzijaService.findAll();

        List<RecenzijaDto> recenzijeDto=new ArrayList<>();
        for(Recenzija recenzija : listaRecenzija)
        {
            RecenzijaDto recenzijaDto = new RecenzijaDto(recenzija);
            recenzijeDto.add(recenzijaDto);
        }
        return ResponseEntity.ok(recenzijeDto);
    }
    @PostMapping("/dodajRecenziju")
    public ResponseEntity<String> dodajRecenziju(@RequestBody RecenzijaDto recenzijaDto,HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");

        if(korisnik==null)
        {
            return new ResponseEntity("Morate biti ulogovani da biste dodali novu recenziju",HttpStatus.FORBIDDEN);

        }

       // recenzijaDto.setKorisnik(korisnik);

        StavkaPolice stavkaPolice = stavkaPoliceService.findById(recenzijaDto.getIdStavke());
        boolean temp=false;
        for(Polica p:korisnik.getPolice())
        {
            for(StavkaPolice s:p.getStavkePolice())
            {
                if(s.getId().equals(stavkaPolice.getId())){
                    temp=true;
                    break;
                }
            }
        }

        if(temp==false){
            return new ResponseEntity<>("Stavka police nije tvoja",HttpStatus.FORBIDDEN);
        }

        Recenzija recenzija = new Recenzija();
        recenzija.setTekst(recenzijaDto.getTekst());
        recenzija.setOcena(recenzijaDto.getOcena());
        recenzija.setKorisnik(korisnik);
        recenzija.setDatumRecenzije(new Date());
        stavkaPolice.setRecenzija(recenzija);
        stavkaPoliceService.save(stavkaPolice);
        return new ResponseEntity("Recenzija dodata",HttpStatus.OK);
    }

    @PutMapping("/recenzije/izmena/{id}")
    public ResponseEntity izmeniRecenziju(@PathVariable (name="id") Long id,@RequestBody Recenzija recenzija,HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");
        if(korisnik==null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        StavkaPolice stavka = stavkaPoliceService.findById(id);



        stavka.getRecenzija().setOcena(recenzija.getOcena());
        stavka.getRecenzija().setTekst(recenzija.getTekst());
        stavkaPoliceService.save(stavka);

        return new ResponseEntity("Recenzija uspesno izmenjena",HttpStatus.OK);
    }

    @GetMapping("/recenzijaPoStavki/{idStavke}")
    public ResponseEntity<RecenzijaDto> getRecenzija(@PathVariable Long idStavke)
    {
        StavkaPolice stavkaPolice=stavkaPoliceService.findById(idStavke);
        RecenzijaDto recenzijaDto = new RecenzijaDto();

        recenzijaDto.setOcena(stavkaPolice.getRecenzija().getOcena());
        recenzijaDto.setTekst(stavkaPolice.getRecenzija().getTekst());
        return new ResponseEntity<>(recenzijaDto,HttpStatus.OK);
    }

}
