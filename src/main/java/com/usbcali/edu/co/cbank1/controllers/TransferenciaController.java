package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaController(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @GetMapping("/obtenerTodos")
    public List<Transferencia> obtenerTodos() {
        List<Transferencia>transferencias = transferenciaRepository.findAll();
        return transferencias;
    }
}
