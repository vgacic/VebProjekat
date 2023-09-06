package com.in51_2021.vebProjekat.service;

import com.in51_2021.vebProjekat.entity.StavkaPolice;
import com.in51_2021.vebProjekat.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaPoliceService {

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    public StavkaPolice findById(Long idStavke) { return stavkaPoliceRepository.findById(idStavke).orElse(null);
    }

    public void save(StavkaPolice stavkaPolice) { stavkaPoliceRepository.save(stavkaPolice);
    }
}
