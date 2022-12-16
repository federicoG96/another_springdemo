package com.antsrl.anotherspringdemo.controller;

import com.antsrl.anotherspringdemo.model.SoftwareHouse;
import com.antsrl.anotherspringdemo.repository.SoftwareHouseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/softwareHouse")
public class SoftwareHouseController {

    private final SoftwareHouseRepository softwareHouseRepository;

    public SoftwareHouseController(SoftwareHouseRepository softwareHouseRepository) {
        this.softwareHouseRepository = softwareHouseRepository;
    }

    @GetMapping(value = "/all")
    public List<SoftwareHouse> getAllSoftwareHouse() {
        return softwareHouseRepository.findAll();
    }

    @PostMapping(value = "/add")
    public SoftwareHouse addSoftwareHouse(@RequestParam String name) {
        SoftwareHouse softwareHouse = new SoftwareHouse();
        softwareHouse.setName(name);
        return softwareHouseRepository.save(softwareHouse);
    }

    @DeleteMapping(value = "/delete/{shId}")
    public void deleteSoftwareHouse(Long shId) {
        softwareHouseRepository.deleteById(shId);
    }

}
