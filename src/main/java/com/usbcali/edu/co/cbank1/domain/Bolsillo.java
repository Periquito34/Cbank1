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
@Table(name= "bolsillo")

public class Bolsillo {

    @Id
    @Column(nullable = false, name = "id_bolsillo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "dinero_actual")
    private float dinero;

    @Column(nullable = false, name = "nombre_bolsillo")
    private String nombreBolsillo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta", nullable = false)
    private Cuenta cuenta;

}
