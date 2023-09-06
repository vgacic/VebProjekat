package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Citalac;
import com.in51_2021.vebProjekat.entity.Recenzija;
import com.in51_2021.vebProjekat.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public List<Recenzija> findAll() {
        return recenzijaRepository.findAll();
    }
    public Recenzija save(Recenzija recenzija) { return recenzijaRepository.save(recenzija); }


}
