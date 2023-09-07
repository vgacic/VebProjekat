package com.in51_2021.vebProjekat.repository;

import com.in51_2021.vebProjekat.entity.Knjiga;
import com.in51_2021.vebProjekat.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface KnjigaRepository extends JpaRepository<Knjiga,Long> {
    List<Knjiga> findAllByNaslov(String naslov);

    Set<Knjiga> findAllByZanr(Zanr zanr);


    //findbyautorid
}
