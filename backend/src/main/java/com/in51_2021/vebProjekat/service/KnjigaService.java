package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.repository.AutorRepository;
import com.in51_2021.vebProjekat.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    AutorRepository autorRepository;


    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    public List<Knjiga> findAllByNaslov(String naslov) {
        return knjigaRepository.findAllByNaslov(naslov);
    }

    public Knjiga findOne(Long id) {
        return knjigaRepository.findById(id).orElse(null);
    }

    public Knjiga save(Knjiga knjiga) { return knjigaRepository.save(knjiga);}

    public void deleteKnjiga(Long id) {  knjigaRepository.deleteById(id);}

    public Knjiga findById(Long id) { return knjigaRepository.findById(id).orElse(null);}

   /* public boolean jeLiOdTogAutora(Autor autor,Knjiga knjiga) {
        for(Autor a : knjiga.getAutor())
        {
            if(a.getIdKnjige().equals(knjiga.getAutor()))
            {
                return true;
            }
        }
        return false;
    }*/

    public Knjiga izmeniKnjigu(Knjiga knjiga, String naslov, String isbn, Date datumObjavljivanja, int brojStrana, String opis) {

        if(brojStrana!=0)
        {
            knjiga.setBrojStrana(brojStrana);
        }
        if(isbn!=null)
        {
            knjiga.setISBN(isbn);
        }
        if(naslov!=null)
        {
            knjiga.setNaslov(naslov);
        }
        if(datumObjavljivanja!=null)
        {
            knjiga.setDatumObjavljivanja(datumObjavljivanja);
        }
        if(opis!=null)
        {
            knjiga.setOpis(opis);
        }


        return knjiga;
    }
}
