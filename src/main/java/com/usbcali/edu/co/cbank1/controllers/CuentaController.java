package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import com.usbcali.edu.co.cbank1.service.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaRepository cuentaRepository;
    private final CuentaService cuentaService;

    public CuentaController(CuentaRepository cuentaRepository, CuentaService cuentaService) {
        this.cuentaRepository = cuentaRepository;
        this.cuentaService = cuentaService;
    }



    @PostMapping("/guardarCuenta")
    public ResponseEntity<CuentaDTO> guardarCuenta(@RequestBody CuentaDTO cuentaDTO) throws Exception{
        CuentaDTO cuentaDTO1 = cuentaService.guardarNuevaCuenta(cuentaDTO);
        return new ResponseEntity<>(cuentaDTO1, HttpStatus.OK);
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<CuentaDTO>> buscartodaslascuentas() {
        return new ResponseEntity<>(cuentaService.buscartodaslascuentas(), HttpStatus.OK);
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<CuentaDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Cuenta cuenta = cuentaRepository.getReferenceById(id);
        CuentaDTO cuentaDTO = CuentaMapper.domainToDto(cuenta);
        return new ResponseEntity<>(cuentaDTO, HttpStatus.OK);
    }
}
