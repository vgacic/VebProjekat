package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.dto.CookieDto;
import com.in51_2021.vebProjekat.dto.KorisnikDto;
import com.in51_2021.vebProjekat.entity.Korisnik;
import com.in51_2021.vebProjekat.dto.LoginDto;
import com.in51_2021.vebProjekat.dto.RegistracijaDto;
import com.in51_2021.vebProjekat.entity.UlogaKorisnika;
import com.in51_2021.vebProjekat.service.KorisnikService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:8081"}, allowCredentials = "true")
public class PocetnaStranicaController {

    @Autowired
    private KorisnikService korisnikService;


    @GetMapping("/api/")
    public String pocetna(){
        return "Pocetna stranica : PRIJAVA / REGISTRACIJA";
    }

    @PostMapping("/prijava")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session)
    {

        System.out.println(session.getId());
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik"); //korisnik koji nije jos ulogovan

        if(korisnik != null)
            return new ResponseEntity<>("Već ste prijavljeni!", HttpStatus.ALREADY_REPORTED);

        Korisnik prijavljen=korisnikService.login(loginDto.getEmail(),loginDto.getLozinka());
        if(prijavljen == null)
        {
            return new ResponseEntity<>("Neuspesna prijava",HttpStatus.NOT_FOUND);
        }


        session.setAttribute("korisnik",prijavljen);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Set-Cookie","JSESSIONID=" + session.getIdKnjige() + "; Max-Age=604800");
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
        return new ResponseEntity<>("Uspesno prijavljen", HttpStatus.OK);
    }


    @PostMapping("/registracija")
    public ResponseEntity<String> registracija(@RequestBody RegistracijaDto registracijaDto)
    {
       if(registracijaDto.getLozinka()==null)
       {
           return new ResponseEntity("Unesite lozinku",HttpStatus.BAD_REQUEST);
       }

       if(registracijaDto.getPotvrdaLozinke()==null)
       {
           return new ResponseEntity("Potvrdite lozinku",HttpStatus.BAD_REQUEST);
       }
        Korisnik rk1=korisnikService.findByEmail(registracijaDto.getEmail());
        if(rk1!=null){
            return new ResponseEntity("Mail vec postoji",HttpStatus.BAD_REQUEST);
        }

        if(!registracijaDto.getLozinka().equals(registracijaDto.getPotvrdaLozinke()))
        {
            return new ResponseEntity("Lozinka i ponovljena lozinka moraju biti iste",HttpStatus.FORBIDDEN);
        }

        Korisnik rk2=korisnikService.findByKorisnickoIme(registracijaDto.getKorisnickoIme());
        if(rk2!=null){
            return new ResponseEntity("Korisnicko ime vec postoji",HttpStatus.BAD_REQUEST);
        }
        korisnikService.register(registracijaDto);
        Korisnik k=new Korisnik();
        k.setIme(registracijaDto.getIme());
        k.setPrezime(registracijaDto.getPrezime());
        k.setKorisnickoIme(registracijaDto.getKorisnickoIme());
        k.setEmail(registracijaDto.getEmail());
        k.setLozinka(registracijaDto.getLozinka());
        k.setUloga(UlogaKorisnika.CITALAC);
        KorisnikDto dto=new KorisnikDto(k);

        return ResponseEntity.ok("Uspesno registrovan korisnik");
    }


    @PostMapping("/odjava")
    public ResponseEntity<String> logout(HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");

        if(korisnik==null)
        {
            return new ResponseEntity<>("Ne mozes se izlogovati ako nisi ulogovan..",HttpStatus.FORBIDDEN);
        }
        session.invalidate();
        return new ResponseEntity<>("Uspesna odjava",HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<Boolean> admin(HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");

        if(korisnik==null)
        {
            return new ResponseEntity<>(false,HttpStatus.FORBIDDEN);
        }
        if(!korisnik.getUloga().equals(UlogaKorisnika.ADMINISTRATOR))
        {
            return new ResponseEntity<>(false,HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);

    }




}
