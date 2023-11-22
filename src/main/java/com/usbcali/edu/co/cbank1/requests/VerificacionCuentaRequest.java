package com.usbcali.edu.co.cbank1.requests;

public class VerificacionCuentaRequest {

        private Integer id;
        private int pin;

        public VerificacionCuentaRequest() {
        }

        public VerificacionCuentaRequest(Integer id, int pin) {
            this.id = id;
            this.pin = pin;
        }

        public Integer getId() {
            return id;
        }

        public int getPin() {
            return pin;
        }
}
