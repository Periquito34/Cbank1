package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.mapper.BolsilloMapper;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaRepository cuentaRepository;

    public CuentaController(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @GetMapping("/obtenerTodos")
    public List<Cuenta> obtenerTodos() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas;
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<CuentaDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Cuenta cuenta = cuentaRepository.getReferenceById(id);
        CuentaDTO cuentaDTO = CuentaMapper.domainToDto(cuenta);
        return new ResponseEntity<>(cuentaDTO,HttpStatus.OK);
    }
}
