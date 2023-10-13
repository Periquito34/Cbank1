package com.usbcali.edu.co.cbank1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BolsilloDTO {

    private Integer id;

    private float dinero;

    private String nombreBolsillo;

    private Integer cuentaId;

}
