package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.UlogaKorisnika;

public class CookieDto {
    private String cookie;
    private Long id;
    private UlogaKorisnika uloga;

    public CookieDto(String cookie, Long id, UlogaKorisnika uloga) {
        this.cookie = cookie;
        this.id = id;
        this.uloga = uloga;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UlogaKorisnika getUloga() {
        return uloga;
    }

    public void setUloga(UlogaKorisnika uloga) {
        this.uloga = uloga;
    }
}
