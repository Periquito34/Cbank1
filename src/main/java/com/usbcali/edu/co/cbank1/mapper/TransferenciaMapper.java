package com.usbcali.edu.co.cbank1.mapper;

import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;

import java.util.List;

public class TransferenciaMapper {
    
    public static Transferencia dtoToDomain(TransferenciaDTO transferenciaDTO) {
        
        return Transferencia.builder()
                .id(transferenciaDTO.getId())
                .fecha_transferencia(transferenciaDTO.getFecha())
                .id_cuentaorigen(transferenciaDTO.getCuentaOrigen())
                .id_cuentadestino(transferenciaDTO.getCuentaDestino())
                .monto(transferenciaDTO.getMonto())
                .num_destinatario(transferenciaDTO.getNum_destinatario())
                .build();
    }
    
    
    public static TransferenciaDTO domainToDto(Transferencia transferencia) {
        return TransferenciaDTO.builder()
                .id(transferencia.getId())
                .fecha(transferencia.getFecha_transferencia())
                .cuentaOrigen(transferencia.getId_cuentaorigen())
                .cuentaDestino(transferencia.getId_cuentadestino())
                .monto(transferencia.getMonto())
                .num_destinatario(transferencia.getNum_destinatario())
                .build();
    }
    
    public List<Transferencia> dtoToDomainList(List<TransferenciaDTO> transferenciaDTOS) {
        return transferenciaDTOS.stream().map(TransferenciaMapper::dtoToDomain).toList();
    }
    
    public List<TransferenciaDTO> domainToDtoList(List<Transferencia> transferencias) {
        return transferencias.stream().map(TransferenciaMapper::domainToDto).toList();
    }
}
