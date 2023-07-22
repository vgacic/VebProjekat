package com.in51_2021.vebProjekat.entity;

public enum UlogaKorisnika {

    CITALAC("Citalac"),
    AUTOR("Autor"),
    ADMINISTRATOR("Administrator");


    private final String text;

    UlogaKorisnika(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }

}