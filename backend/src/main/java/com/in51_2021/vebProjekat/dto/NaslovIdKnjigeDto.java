package com.in51_2021.vebProjekat.dto;

public class NaslovIdKnjigeDto {
    private Long idKnjige;
    private String naslov;
    private Float ocena;
    private Long idStavke;

    public NaslovIdKnjigeDto(Long idKnjige, String naslov,Long idStavke) {
        this.idKnjige = idKnjige;
        this.naslov = naslov;
        this.idStavke=idStavke;

    }

    public Long getIdStavke() {
        return idStavke;
    }

    public void setIdStavke(Long idStavke) {
        this.idStavke = idStavke;
    }

    public Long getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(Long idKnjige) {
        this.idKnjige = idKnjige;
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
