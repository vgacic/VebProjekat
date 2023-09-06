package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.KnjigaDto;
import com.in51_2021.vebProjekat.dto.KorisnikDto;
import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.service.KnjigaService;
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
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/knjige")
    public ResponseEntity<List<KnjigaDto>> getKnjige(HttpSession session)
    {
        List<Knjiga> listaKnjiga=knjigaService.findAll();
        List<KnjigaDto> knjigeDto=new ArrayList<>();
        for(Knjiga knjiga : listaKnjiga)
        {
            KnjigaDto knjigaDto = new KnjigaDto(knjiga);
            knjigeDto.add(knjigaDto);
        }
        return ResponseEntity.ok(knjigeDto);
    }
    //http://localhost:8880/api/search?query=naslov
    @GetMapping("/search")
    public ResponseEntity<List<KnjigaDto>> search(@RequestParam String query) {
        List<Knjiga> knjige = knjigaService.findAllByNaslov(query);
        if(knjige.isEmpty())
        {
            return new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }

        List<KnjigaDto> knjigeDto = new ArrayList<>();
        for (Knjiga k : knjige) {
            knjigeDto.add(new KnjigaDto(k));

        }
        System.out.println(query);
        return new ResponseEntity(knjigeDto, HttpStatus.OK);
    }

    @GetMapping("/knjiga/{id}")
    private ResponseEntity<KnjigaDto>getKnjiga(@PathVariable Long id)
    {
        Knjiga knjiga = knjigaService.findOne(id);
        KnjigaDto knjigaDto=new KnjigaDto(knjiga);
        return new ResponseEntity<>(knjigaDto,HttpStatus.OK);
    }
}
