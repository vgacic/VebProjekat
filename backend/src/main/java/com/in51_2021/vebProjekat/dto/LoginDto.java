package com.in51_2021.vebProjekat.dto;

public class LoginDto {
    private String email;
    private String lozinka;

    public LoginDto(){}

    public LoginDto(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
