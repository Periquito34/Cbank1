package com.usbcali.edu.co.cbank1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDTO {

    private Integer id;

    private Integer cuentaOrigen;

    private Integer cuentaDestino;

    private float monto;

    private String fecha;

}
