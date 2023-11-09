package com.usbcali.edu.co.cbank1.mapper;

import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;

import java.util.Date;
import java.util.List;

public class TransferenciaMapper {
    
    public static Transferencia dtoToDomain(TransferenciaDTO transferenciaDTO) {
        
        return Transferencia.builder()
                .id(transferenciaDTO.getId())
                .monto(transferenciaDTO.getMonto())
                .fecha(transferenciaDTO.getFecha())
                .build();
    }

    public static TransferenciaDTO domainToDto(Transferencia transferencia) {
        return TransferenciaDTO.builder()
                .id(transferencia.getId())
                .cuentaOrigen(transferencia.getCuentaOrigen().getId() == null ? null : transferencia.getCuentaOrigen().getId())
                .cuentaDestino(transferencia.getCuentaDestino().getId() == null ? null : transferencia.getCuentaDestino().getId())
                .monto(transferencia.getMonto())
                .fecha(transferencia.getFecha())
                .build();
    }
    
    public List<Transferencia> dtoToDomainList(List<TransferenciaDTO> transferenciaDTOS) {
        return transferenciaDTOS.stream().map(TransferenciaMapper::dtoToDomain).toList();
    }
    
    public static List<TransferenciaDTO> domainToDtoList(List<Transferencia> transferencias) {
        return transferencias.stream().map(TransferenciaMapper::domainToDto).toList();
    }
}
