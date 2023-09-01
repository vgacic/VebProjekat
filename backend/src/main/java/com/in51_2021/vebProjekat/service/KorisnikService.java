package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

}
