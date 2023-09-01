package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
}
