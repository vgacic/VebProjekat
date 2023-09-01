package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.CitalacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitalacService {
    @Autowired
    private CitalacRepository citalacRepository;
}
