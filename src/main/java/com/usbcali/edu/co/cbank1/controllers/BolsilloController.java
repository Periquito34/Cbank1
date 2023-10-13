package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import com.usbcali.edu.co.cbank1.repository.BolsilloRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bolsillo")
public class BolsilloController {

    private final BolsilloRepository bolsilloRepository;

    public BolsilloController(BolsilloRepository bolsilloRepository) {
        this.bolsilloRepository = bolsilloRepository;
    }

    @GetMapping("/obtenerTodos")
    public List<Bolsillo> obtenerTodos() {
        List<Bolsillo> bolsillos = bolsilloRepository.findAll();
        return bolsillos;
    }
}
