package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;
import com.usbcali.edu.co.cbank1.mapper.BolsilloMapper;
import com.usbcali.edu.co.cbank1.repository.BolsilloRepository;
import com.usbcali.edu.co.cbank1.service.BolsilloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolsillo")
public class BolsilloController {

    private final BolsilloRepository bolsilloRepository;

    private final BolsilloService bolsilloService;

    public BolsilloController(BolsilloRepository bolsilloRepository, BolsilloService bolsilloService) {
        this.bolsilloRepository = bolsilloRepository;
        this.bolsilloService = bolsilloService;
    }

    @PostMapping("/guardarBolsillo")
    public ResponseEntity<BolsilloDTO> guardarBolsillo(@RequestBody BolsilloDTO bolsilloDTO) throws Exception{
        BolsilloDTO bolsilloDTO1 = bolsilloService.guardarNuevoBolsillo(bolsilloDTO);
        return new ResponseEntity<>(bolsilloDTO1, HttpStatus.OK);
    }
    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<BolsilloDTO>> buscarTodosLosBolsillos() {
        return new ResponseEntity<>(bolsilloService.buscarTodosLosBolsillos(), HttpStatus.OK);
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<BolsilloDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Bolsillo bolsillo = bolsilloRepository.getReferenceById(id);
        BolsilloDTO bolsilloDTO = BolsilloMapper.domainToDto(bolsillo);
        return new ResponseEntity<>(bolsilloDTO, HttpStatus.OK);
    }
}
