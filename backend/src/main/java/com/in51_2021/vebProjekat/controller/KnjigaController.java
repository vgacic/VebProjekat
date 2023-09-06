package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.KnjigaDto;
import com.in51_2021.vebProjekat.dto.KorisnikDto;
import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.UlogaKorisnika;
import com.in51_2021.vebProjekat.service.KnjigaService;
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
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private KorisnikService korisnikService;

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


    @PostMapping("/dodajKnjigu")
    public String dodajKnjigu(@RequestBody Knjiga knjiga)
    {
        this.knjigaService.save(knjiga);
        return "Uspesno dodata knjiga";
    }

    @DeleteMapping("/obrisiKnjigu/{id}")
    public ResponseEntity<String> obrisiKnjigu(@PathVariable Long id)
    {
        knjigaService.deleteKnjiga(id);
        return new ResponseEntity<>("Knjiga je obrisana",HttpStatus.OK);
    }


    @PutMapping("/izmenaKnjige/{id}")
    public ResponseEntity izmeniKnjigu(@PathVariable Long id,@RequestBody KnjigaDto knjigaDto,HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");

        if(korisnik==null)
        {
            return new ResponseEntity("Morate biti prijavljeni da biste izmenili knjigu!",HttpStatus.UNAUTHORIZED);
        }
        if(korisnik.getUloga().equals(UlogaKorisnika.CITALAC))
        {
            return new ResponseEntity("Nisi admin ni autor,ne mozes menjati knjigu.",HttpStatus.UNAUTHORIZED);
        }
        Knjiga knjiga=knjigaService.findById(id);
        if(knjiga==null)
        {
            return new ResponseEntity("Knjiga nije pronadjena",HttpStatus.NOT_FOUND);
        }
       /* if(korisnik.getUloga().equals(UlogaKorisnika.AUTOR)&&!knjigaService.jeLiOdTogAutora(knjiga,(Autor)korisnikService.findById(korisnik.getIdKnjige())))
        {
            return new ResponseEntity("Smes menjati samo tvoju knjigu!",HttpStatus.FORBIDDEN);
        }*/ //PITAJ DEJANA

        knjiga=knjigaService.izmeniKnjigu(knjiga,knjigaDto.getNaslov(),knjigaDto.getISBN(),knjigaDto.getDatumObjavljivanja(),knjigaDto.getBrojStrana(),knjigaDto.getOpis());

        knjigaService.save(knjiga);
        return new ResponseEntity("Uspesno izmenjena knjiga",HttpStatus.OK);

    }
}
