package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Citalac;
import com.in51_2021.vebProjekat.entity.Recenzija;
import com.in51_2021.vebProjekat.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public List<Recenzija> findAll() {
        return recenzijaRepository.findAll();
    }

    public Recenzija save(Recenzija recenzija) {
        return recenzijaRepository.save(recenzija);
    }


    public Recenzija findOne(Long id) {
        Optional<Recenzija> nadjena = recenzijaRepository.findById(id);
        if (nadjena.isPresent()) {
            return nadjena.get();
        }
         else return null;

    }
}
