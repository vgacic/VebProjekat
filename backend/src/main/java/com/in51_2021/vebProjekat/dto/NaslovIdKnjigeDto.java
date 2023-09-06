package com.in51_2021.vebProjekat.dto;

public class NaslovIdKnjigeDto {
    private Long id;
    private String naslov;
    private Float ocena;

    public NaslovIdKnjigeDto(Long id, String naslov) {
        this.id = id;
        this.naslov = naslov;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }
}
