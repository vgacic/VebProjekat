package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Autor;
import com.in51_2021.vebProjekat.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
    public Autor findById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }
}
