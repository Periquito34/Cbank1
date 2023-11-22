package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.mapper.TransferenciaMapper;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import com.usbcali.edu.co.cbank1.service.CuentaService;
import com.usbcali.edu.co.cbank1.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private final TransferenciaRepository transferenciaRepository;

    private final TransferenciaService transferenciaService;

    private final CuentaService cuentaService;

    public TransferenciaController(TransferenciaRepository transferenciaRepository, TransferenciaService transferenciaService, CuentaService cuentaService) {
        this.transferenciaRepository = transferenciaRepository;
        this.transferenciaService = transferenciaService;
        this.cuentaService = cuentaService;
    }

    @PostMapping("/guardarTransferencia")
    public ResponseEntity<TransferenciaDTO> guardarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) throws Exception {
        // Obtener cuentas de origen y destino
        CuentaDTO cuentaOrigen = cuentaService.obtenerCuentaPorId(transferenciaDTO.getCuentaOrigen());
        CuentaDTO cuentaDestino = cuentaService.obtenerCuentaPorId(transferenciaDTO.getCuentaDestino());

        // Validar si la cuenta de origen tiene suficiente saldo
        if (cuentaOrigen.getSaldo() < transferenciaDTO.getMonto()) {
            throw new Exception("La cuenta de origen no tiene suficiente saldo para realizar la transferencia.");
        }

        // Restar el monto de la cuenta de origen
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - transferenciaDTO.getMonto());

        // Sumar el monto a la cuenta de destino
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + transferenciaDTO.getMonto());

        // Guardar la transferencia
        TransferenciaDTO transferenciaDTO1 = transferenciaService.guardarTransferencia(transferenciaDTO);

        // Actualizar las cuentas en la base de datos
        cuentaService.actualizarCuenta(cuentaOrigen);
        cuentaService.actualizarCuenta(cuentaDestino);

        return new ResponseEntity<>(transferenciaDTO1, HttpStatus.OK);
    }
    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<TransferenciaDTO>> buscarTodasLasTransferencias() {
        return new ResponseEntity<>(transferenciaService.buscarTodasLasTransferencias(), HttpStatus.OK);
    }


    @GetMapping("/porId/{id}")
    public ResponseEntity<TransferenciaDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Transferencia transferencia = transferenciaRepository.getReferenceById(id);
        TransferenciaDTO transferenciaDTO = TransferenciaMapper.domainToDto(transferencia);
        return new ResponseEntity<>(transferenciaDTO, HttpStatus.OK);
    }

    @GetMapping("/historialTransferencias/{cuentaId}")
    public ResponseEntity<List<TransferenciaDTO>> obtenerHistorialDeTransferencias(@PathVariable Integer cuentaId) {
        List<TransferenciaDTO> historial = transferenciaService.obtenerHistorialDeTransferencias(cuentaId);
        return ResponseEntity.ok(historial);
    }

}
