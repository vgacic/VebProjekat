package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.KorisnikDto;
import com.in51_2021.vebProjekat.dto.ZanrDto;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Zanr;
import com.in51_2021.vebProjekat.service.ZanrService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/api")
public class ZanrController {

    @Autowired
    private ZanrService zanrService;

    @GetMapping("/zanrovi")
    public ResponseEntity<List<ZanrDto>> getZanrovi(HttpSession session)
    {
        List<Zanr> listaZanrova=zanrService.findAll();

        List<ZanrDto> zanroviDto=new ArrayList<>();
        for(Zanr zanr : listaZanrova)
        {
            ZanrDto zanrDto = new ZanrDto(zanr);
            zanroviDto.add(zanrDto);
        }
        return ResponseEntity.ok(zanroviDto);
    }
}
