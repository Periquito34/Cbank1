package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.mapper.TransferenciaMapper;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/porId/{id}")
    public ResponseEntity<TransferenciaDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Transferencia transferencia = transferenciaRepository.getReferenceById(id);
        TransferenciaDTO transferenciaDTO = TransferenciaMapper.domainToDto(transferencia);
        return new ResponseEntity<>(transferenciaDTO, HttpStatus.OK);
    }
}
