package com.usbcali.edu.co.cbank1.service.impl;

import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;
import com.usbcali.edu.co.cbank1.service.BolsilloService;
import org.springframework.stereotype.Service;

@Service
public class BolsilloServiceimpl implements BolsilloService {


    @Override
    public BolsilloDTO guardarBolsillo(BolsilloDTO bolsilloDTO) throws Exception {

        if(bolsilloDTO == null ){
            throw new Exception("Bolsillo no puede ser nulo");
        }

        if(bolsilloDTO.getDinero() < 0){
            throw new Exception("Dinero no puede ser menor a 0");
        }

        if(bolsilloDTO.getNombreBolsillo()== null || bolsilloDTO.getNombreBolsillo().trim().equals("")){
            throw new Exception("Nombre Bolsillo no puede ser nulo o vacio");
        }

        if(bolsilloDTO.getCuentaId() == null || bolsilloDTO.getCuentaId() < 0){
            throw new Exception("Cuenta no puede ser nulo o menor a 0");
        }
        return null;
    }
}
