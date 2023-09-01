package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
}
