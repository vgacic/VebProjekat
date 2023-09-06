package com.in51_2021.vebProjekat.repository;

import com.in51_2021.vebProjekat.entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnjigaRepository extends JpaRepository<Knjiga,Long> {
    List<Knjiga> findAllByNaslov(String naslov);



    //findbyautorid
}
