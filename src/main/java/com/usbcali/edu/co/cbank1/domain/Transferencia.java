package com.usbcali.edu.co.cbank1.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "transferencia")

public class Transferencia {

    @Id
    @Column(nullable = false, name = "id_transferencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_origen", referencedColumnName = "id_cuenta", nullable = false)
    private Cuenta cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_destino", referencedColumnName = "id_cuenta", nullable = false)
    private Cuenta cuentaDestino;


    @Column(nullable = false, length = 30, name="monto")
    private float monto;

    @Column(nullable = false, length = 30, name="fecha_transferencia")
    private String fecha;

}
