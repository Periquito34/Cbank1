package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {

    CuentaDTO guardarNuevaCuenta(CuentaDTO cuentaDTO) throws Exception;

    List<CuentaDTO> buscartodaslascuentas();

    public CuentaDTO obtenerCuentaPorId(Integer id) throws Exception;

    public CuentaDTO actualizarCuenta(CuentaDTO cuentaDTO) throws Exception;

    Integer obtenerIdCuentaPorTelefono(String telefono) throws Exception;





}
