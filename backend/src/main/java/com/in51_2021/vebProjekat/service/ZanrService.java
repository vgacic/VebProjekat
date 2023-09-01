package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanrService {
    @Autowired
    private AdminRepository adminRepository;
}
