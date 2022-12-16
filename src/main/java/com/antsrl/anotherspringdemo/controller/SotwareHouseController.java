package com.antsrl.anotherspringdemo.controller;

import com.antsrl.anotherspringdemo.model.SoftwareHouse;
import com.antsrl.anotherspringdemo.model.Videogame;
import com.antsrl.anotherspringdemo.repository.SoftwareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shouse")
public class SotwareHouseController {

    @Autowired
    private SoftwareHouseRepository softwareHouseRepository;

    @GetMapping(value = "/all")
    public List<SoftwareHouse> getALlSoftwareHouse2() {
        System.out.println("");
        return softwareHouseRepository.findAll();

    }

    @PostMapping("/add")
    public SoftwareHouse addSoftwareHouse(@RequestBody SoftwareHouse softwareHouse){
        return softwareHouseRepository.save(softwareHouse);
    }
}
