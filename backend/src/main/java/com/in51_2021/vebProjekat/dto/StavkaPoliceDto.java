package com.in51_2021.vebProjekat.dto;

import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.entity.Recenzija;
import com.in51_2021.vebProjekat.entity.StavkaPolice;

public class StavkaPoliceDto {
    private Long id;

    private Knjiga knjiga;

    private Recenzija recenzija;

    public StavkaPoliceDto() {}

    public StavkaPoliceDto(Long id,Knjiga knjiga,Recenzija recenzija)
    {
        this.id = id;
        this.knjiga = knjiga;
        this.recenzija = recenzija;
    }

    public StavkaPoliceDto(StavkaPolice stavkaPolice)
    {
        this.id = stavkaPolice.getId();
        this.knjiga = stavkaPolice.getKnjiga();
        this.recenzija = stavkaPolice.getRecenzija();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }

    @Override
    public String toString() {
        return "StavkaPoliceDto{" +
                "id=" + id +
                ", knjiga=" + knjiga +
                ", recenzija=" + recenzija +
                '}';
    }
}
