package com.in51_2021.vebProjekat.controller;

import com.in51_2021.vebProjekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/cao")
    public String cao(){return "cao cao";}








}
