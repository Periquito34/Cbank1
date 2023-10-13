package com.usbcali.edu.co.cbank1.mapper;

import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;

import java.util.List;

public class CuentaMapper {

    public static Cuenta dtoToDomain(CuentaDTO cuentaDTO) {
        return Cuenta.builder()
                .id(cuentaDTO.getId())
                .saldo(cuentaDTO.getSaldo())
                .pin(cuentaDTO.getPin())
                .telefono(cuentaDTO.getTelefono())
                .build();
    }

    public static CuentaDTO domainToDto(Cuenta cuenta) {
        return CuentaDTO.builder()
                .id(cuenta.getId())
                .saldo(cuenta.getSaldo())
                .pin(cuenta.getPin())
                .telefono(cuenta.getTelefono())
                .build();
    }

    public List<Cuenta> dtoToDomainList(List<CuentaDTO> cuentaDTOS) {
        return cuentaDTOS.stream().map(CuentaMapper::dtoToDomain).toList();
    }

    public List<CuentaDTO> domainToDtoList(List<Cuenta> cuentas) {
        return cuentas.stream().map(CuentaMapper::domainToDto).toList();
    }
}
