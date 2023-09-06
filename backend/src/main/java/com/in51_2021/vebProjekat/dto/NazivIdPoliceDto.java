package com.in51_2021.vebProjekat.dto;

public class NazivIdPoliceDto {
    private Long id;
    private String naziv;

    public NazivIdPoliceDto(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
