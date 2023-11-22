package com.usbcali.edu.co.cbank1.requests;

public class AgregarSaldoRequest {
    private float monto;

    // Constructores, getters y setters (puedes generarlos automáticamente en tu IDE)

    public AgregarSaldoRequest() {
    }

    public AgregarSaldoRequest(float monto) {
        this.monto = monto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
