package com.antsrl.anotherspringdemo.service;

import com.antsrl.anotherspringdemo.model.SoftwareHouse;
import com.antsrl.anotherspringdemo.model.Videogame;
import com.antsrl.anotherspringdemo.repository.SoftwareHouseRepository;
import com.antsrl.anotherspringdemo.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideogameService {

    private final VideogameRepository videogameRepository;

    private final SoftwareHouseRepository softwareHouseRepository;

    @Autowired
    public VideogameService(VideogameRepository videogameRepository, SoftwareHouseRepository softwareHouseRepository) {
        this.videogameRepository = videogameRepository;
        this.softwareHouseRepository = softwareHouseRepository;
    }

    public Videogame addVideogame(Videogame videogame) {
        Optional<SoftwareHouse> softwareHouse = softwareHouseRepository.findById(videogame.getSoftwareHouse().getId());
        if (softwareHouse.isEmpty()) {
            // METTIAMO QUA CODICE PER INSERIRE LA NUOVA SOFTWARE HOUSE
            softwareHouse = Optional.of(softwareHouseRepository.save(videogame.getSoftwareHouse()));
        }
        videogame.setSoftwareHouse(softwareHouse.get());
        return videogameRepository.save(videogame);
    }
}
