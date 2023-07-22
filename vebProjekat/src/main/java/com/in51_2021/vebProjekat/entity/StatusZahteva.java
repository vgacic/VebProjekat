package com.in51_2021.vebProjekat.entity;

public enum StatusZahteva {
    NA_CEKANJU("Na cekanju"),
    ODOBREN("Odobren"),
    ODBIJEN("Odbijen");

    private final String text;

    StatusZahteva(final String text){this.text=text;} //final - cannot be changed once it is assigned a value


    public String toString(){return text;}
}
