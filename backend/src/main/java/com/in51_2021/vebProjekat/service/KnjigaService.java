package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    public List<Knjiga> findAllByNaslov(String naslov) {
        return knjigaRepository.findAllByNaslov(naslov);
    }

    public Knjiga findOne(Long id) {
        return knjigaRepository.findById(id).orElse(null);
    }
}
