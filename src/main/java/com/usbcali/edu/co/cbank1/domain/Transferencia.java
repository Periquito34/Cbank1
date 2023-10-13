package com.usbcali.edu.co.cbank1.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false, length = 30, name="fecha_transferencia")
    private String fecha_transferencia;

    @Column(nullable = false, length = 30, name="id_cuenta_origen")
    private int id_cuentaorigen;

    @Column(nullable = false, length = 30, name="id_cuenta_destino")
    private int id_cuentadestino;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta", nullable = false)
    private Cuenta cuenta;

    @Column(nullable = false, length = 30, name="monto")
    private float monto;

    @Column(nullable = false, length = 30, name="num_destinatario")
    private String num_destinatario;

}
