package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.dto.ZahtevAktivacijaAutorDto;
import com.in51_2021.vebProjekat.entity.ZahtevAktivacijaAutor;
import com.in51_2021.vebProjekat.repository.ZahtevAktivacijaAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevAktivacijaAutorService {
    @Autowired
    private ZahtevAktivacijaAutorRepository zahtevAktivacijaAutorRepository;

    public List<ZahtevAktivacijaAutor> findAll() {
        return zahtevAktivacijaAutorRepository.findAll();
    }

    public ZahtevAktivacijaAutor saveZahtev(ZahtevAktivacijaAutor zahtevAktivacijaAutor) {
        return  zahtevAktivacijaAutorRepository.save(zahtevAktivacijaAutor);
    }
}
