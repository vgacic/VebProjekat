package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.RecenzijaDto;
import com.in51_2021.vebProjekat.dto.StavkaPoliceDto;
import com.in51_2021.vebProjekat.dto.ZanrDto;
import com.in51_2021.vebProjekat.entity.Citalac;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Recenzija;
import com.in51_2021.vebProjekat.entity.Zanr;
import com.in51_2021.vebProjekat.service.KorisnikService;
import com.in51_2021.vebProjekat.service.RecenzijaService;
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
public class RecenzijaController {

    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private KorisnikService korisnikService;

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
   /* @PostMapping("/dodajRecenziju/{stavkaId}")
    public ResponseEntity<String> dodajRecenziju(@PathVariable Long id,StavkaPoliceDto stavkaPoliceDto,HttpSession session)
    {

    }*/

}
