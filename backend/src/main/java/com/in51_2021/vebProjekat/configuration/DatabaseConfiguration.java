package com.in51_2021.vebProjekat.configuration;

import com.in51_2021.vebProjekat.entity.*;
import com.in51_2021.vebProjekat.repository.AdminRepository;
import com.in51_2021.vebProjekat.repository.KnjigaRepository;
import com.in51_2021.vebProjekat.repository.PolicaRepository;
import com.in51_2021.vebProjekat.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.Instant;

public class DatabaseConfiguration {
    @Autowired
    private ZanrRepository zanrRepository;

    @Autowired
    private KnjigaRepository knjigaRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PolicaRepository policaRepository;
    public boolean instantiate(){

        Zanr zanr1=new Zanr("Krimi");
        Zanr zanr2=new Zanr("Misterija");
        Zanr zanr3=new Zanr("Akcija");
        Zanr zanr4=new Zanr("Romansa");
        zanrRepository.save(zanr1);
        zanrRepository.save(zanr2);
        zanrRepository.save(zanr3);
        zanrRepository.save(zanr4);

        Knjiga knjiga1=new Knjiga("Kapije atine","slika1","978-86-10-04702-8", "2022-01-20",300,8,zanr3);
        Knjiga knjiga2=new Knjiga("It starts with us","slika2","978-13-98-51817-9","2022-01-20",300,10,zanr4); //samo ga je pretvorilo u int
        Knjiga knjiga3=new Knjiga("It ends with us","slika3","978-14-71-15626-7","2016-10-02",300,10,zanr4);

        knjigaRepository.save(knjiga1);
        knjigaRepository.save(knjiga2);
        knjigaRepository.save(knjiga3);

        Polica p1=new Polica("Want to read",true);
        Polica p2=new Polica("Read",true);
        Polica p3=new Polica("Currently reading",true);
        Polica p4=new Polica("Procitacu opet",false);
        Polica p5=new Polica("Omiljene",false);

        policaRepository.save(p1);
        policaRepository.save(p2);
        policaRepository.save(p3);
        policaRepository.save(p4);
        policaRepository.save(p5);

        Recenzija r1=new Recenzija(7,"Recenzija1", Date.from(Instant.now()));

        StavkaPolice stavkaPolice1=new StavkaPolice(knjiga1,r1);


        Korisnik k1=new Korisnik("Valentina","Gacic","vaki123","vaki@gmail.com","admin","2002-06-01","slika1","admin",UlogaKorisnika.ADMINISTRATOR);
        Korisnik k2=new Korisnik();































        return true;
    }

}
