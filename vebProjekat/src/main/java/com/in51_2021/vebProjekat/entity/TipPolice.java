package com.in51_2021.vebProjekat.entity;

public enum TipPolice {

    REGULAR("Regular"),
    WANT_TO_READ("Want_to_read"),
    CURRENTLY_READING("Currently_reading"),
    READ("Read");


    private final String text;

    TipPolice(final String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
