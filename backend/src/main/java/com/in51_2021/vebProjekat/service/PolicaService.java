package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
}
