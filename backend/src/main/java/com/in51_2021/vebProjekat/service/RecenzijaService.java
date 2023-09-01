package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;
}
