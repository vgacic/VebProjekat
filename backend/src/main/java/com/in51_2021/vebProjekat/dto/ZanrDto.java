package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Zanr;

public class ZanrDto {


    private Long id;
    private String naziv;

    public ZanrDto() {}

    public ZanrDto(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public  ZanrDto(Zanr zanr)
    {
        this.id=zanr.getId();
        this.naziv=zanr.getNaziv();
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

    @Override
    public String toString() {
        return "ZanrDto{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
