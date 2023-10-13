package com.usbcali.edu.co.cbank1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {

    private Integer id;

    private float saldo;

    private int pin;

    private Integer usuarioId;

    private String telefono;
}
