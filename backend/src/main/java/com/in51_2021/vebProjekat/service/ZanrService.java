package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.Zanr;
import com.in51_2021.vebProjekat.repository.AdminRepository;
import com.in51_2021.vebProjekat.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZanrService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ZanrRepository zanrRepository;

    public List<Zanr> findAll() {
        return zanrRepository.findAll();
    }

    public Zanr save(Zanr zanr) {
        return zanrRepository.save(zanr);
    }
}
