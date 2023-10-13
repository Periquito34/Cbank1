package com.usbcali.edu.co.cbank1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDTO {

    private Integer id;

    private String fecha;

    private int cuentaOrigen;

    private int cuentaDestino;

    private Integer cuentaId;

    private float monto;

    private String num_destinatario;
}
