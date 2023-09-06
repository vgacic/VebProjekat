package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Polica;
import com.in51_2021.vebProjekat.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;

    public Polica savePolica(Polica polica) {
        return policaRepository.save(polica);
    }

    public Polica findOne(Long id) {
        return policaRepository.findById(id).orElse(null);
    }

    public Polica save(Polica polica){
        return policaRepository.save(polica);
    }
}
