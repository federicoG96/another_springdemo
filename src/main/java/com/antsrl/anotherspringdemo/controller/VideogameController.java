package com.antsrl.anotherspringdemo.controller;

import com.antsrl.anotherspringdemo.model.Videogame;
import com.antsrl.anotherspringdemo.repository.VideogameRepository;
import com.antsrl.anotherspringdemo.service.VideogameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/videogame")
public class VideogameController {

    private final VideogameService videogameService;

    private final VideogameRepository videogameRepository;

    public VideogameController(VideogameService videogameService, VideogameRepository videogameRepository) {
        this.videogameService = videogameService;
        this.videogameRepository = videogameRepository;
    }

    @GetMapping(value = "/all")
    public List<Videogame> getALlVideogame() {
        List<Videogame> videogameList = videogameRepository.findAll();
        return videogameList;
    }

    @GetMapping(value = "/find/{id}")
    public Videogame getALlVideogame(@PathVariable Long id) {
        Videogame videogame = videogameRepository.findById(id).get();
        return videogame;
    }

    @PostMapping(value = "/add")
    public Videogame addVideogame(@RequestBody Videogame videogame) {
        return videogameService.addVideogame(videogame);
    }

}
