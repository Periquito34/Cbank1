package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import com.usbcali.edu.co.cbank1.requests.AgregarSaldoRequest;
import com.usbcali.edu.co.cbank1.requests.VerificacionCuentaRequest;
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

    @GetMapping("/obtenerIdPorTelefono/{telefono}")
    public ResponseEntity<Integer> obtenerIdCuentaPorTelefono(@PathVariable String telefono) {
        try {
            Integer idCuenta = cuentaService.obtenerIdCuentaPorTelefono(telefono);
            return ResponseEntity.ok(idCuenta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/verificarCuentaPorIdYPin")
    public ResponseEntity<Boolean> verificarCuentaPorIdYPin(@RequestBody VerificacionCuentaRequest request) {
        try {
            boolean resultado = cuentaService.verificarCuentaPorIdYPin(request.getId(), request.getPin());
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/agregarSaldo/{idCuenta}")
    public ResponseEntity<CuentaDTO> agregarSaldo(@PathVariable Integer idCuenta, @RequestBody AgregarSaldoRequest request) {
        try {
            CuentaDTO cuentaActualizada = cuentaService.agregarSaldo(idCuenta, request.getMonto());
            return ResponseEntity.ok(cuentaActualizada);
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/usuario/{idCuenta}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorIdCuenta(@PathVariable Integer idCuenta) {
        try {
            UsuarioDTO usuarioDTO = cuentaService.obtenerUsuarioPorIdCuenta(idCuenta);
            return ResponseEntity.ok(usuarioDTO);
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
