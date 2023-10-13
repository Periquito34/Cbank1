package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
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
}
