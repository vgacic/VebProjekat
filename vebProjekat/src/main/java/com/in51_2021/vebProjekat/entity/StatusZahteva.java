package com.in51_2021.vebProjekat.entity;

public enum StatusZahteva {
    NA_CEKANJU("Na cekanju"),
    ODOBREN("Odobren"),
    ODBIJEN("Odbijen");

    private final String text;

    ZahtevAktivacijaAutor(final String text){this.text=text;}


    public String toString(){return text;}
}
