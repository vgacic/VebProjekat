package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.dto.ZahtevAktivacijaAutorDto;
import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.StatusZahteva;
import com.in51_2021.vebProjekat.entity.ZahtevAktivacijaAutor;
import com.in51_2021.vebProjekat.repository.ZahtevAktivacijaAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevAktivacijaAutorService {
    @Autowired
    private ZahtevAktivacijaAutorRepository zahtevAktivacijaAutorRepository;
    @Autowired
    private AutorService autorService;
    @Autowired
    private JavaMailSender javaMailSender;

    public List<ZahtevAktivacijaAutor> findAll() {
        return zahtevAktivacijaAutorRepository.findAll();
    }

    public ZahtevAktivacijaAutor saveZahtev(ZahtevAktivacijaAutor zahtevAktivacijaAutor) {
        return  zahtevAktivacijaAutorRepository.save(zahtevAktivacijaAutor);
    }

    public ZahtevAktivacijaAutor findById(Long id) {
        return zahtevAktivacijaAutorRepository.findById(id).orElse(null);
    }

    public void obradi(Boolean obradi, ZahtevAktivacijaAutor zahtevAktivacijaAutor) {
        if (obradi) {
            Autor autor = zahtevAktivacijaAutor.getAutor();
            autor.setLozinka("123123");
            autor.setEmail(zahtevAktivacijaAutor.getEmail());
            autorService.save(autor);
            posaljiMejl("valentinagacic1@gmail.com", "Zahtev odobren", "Vasa lozinka je 123123, a email " + zahtevAktivacijaAutor.getEmail());
            zahtevAktivacijaAutor.setStatus(StatusZahteva.ODOBREN);
        } else {
            posaljiMejl("valentinagacic1@gmail.com", "Zahtev odbijen", "Vas zahtev je odbijen!!!");
            zahtevAktivacijaAutor.setStatus(StatusZahteva.ODBIJEN);
        }

        saveZahtev(zahtevAktivacijaAutor);
    }

    public void posaljiMejl(String to, String naslov, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gacic.in51.2021@uns.ac.rs");
        message.setTo(to);
        message.setSubject(naslov);
        message.setText(text);
        javaMailSender.send(message);
    }
}
