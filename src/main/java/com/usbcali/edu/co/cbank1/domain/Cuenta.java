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
@Table(name= "cuenta")

public class Cuenta {

    @Id
    @Column(nullable = false, name = "id_cuenta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30, name="saldo")
    private Float saldo;

    @Column(nullable = false, length = 30, name="pin")
    private int pin;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false,length = 10,name="num_destinatario")
    private String telefono;
}
