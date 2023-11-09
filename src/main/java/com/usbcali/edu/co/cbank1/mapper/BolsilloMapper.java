package com.usbcali.edu.co.cbank1.mapper;

import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;

import java.util.List;

public class BolsilloMapper {

    public static Bolsillo dtoToDomain(BolsilloDTO bolsilloDTO) {
     return Bolsillo.builder()
             .id(bolsilloDTO.getId())
             .dinero(bolsilloDTO.getDinero())
             .nombreBolsillo(bolsilloDTO.getNombreBolsillo())
             .build();
    }

    public static BolsilloDTO domainToDto(Bolsillo bolsillo) {
        return BolsilloDTO.builder()
                .id(bolsillo.getId())
                .dinero(bolsillo.getDinero())
                .nombreBolsillo(bolsillo.getNombreBolsillo())
                .cuentaId(bolsillo.getCuenta().getId() == null ? null : bolsillo.getCuenta().getId())
                .build();
    }

    public List<Bolsillo> dtoToDomainList(List<BolsilloDTO> bolsilloDTOS) {
        return bolsilloDTOS.stream().map(BolsilloMapper::dtoToDomain).toList();
    }

    public static List<BolsilloDTO> domainToDtoList(List<Bolsillo> bolsillos) {
        return bolsillos.stream().map(BolsilloMapper::domainToDto).toList();
    }
}
