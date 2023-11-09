package com.usbcali.edu.co.cbank1.service.impl;

import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;
import com.usbcali.edu.co.cbank1.mapper.BolsilloMapper;
import com.usbcali.edu.co.cbank1.repository.BolsilloRepository;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import com.usbcali.edu.co.cbank1.service.BolsilloService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BolsilloServiceimpl implements BolsilloService {

    public final BolsilloRepository bolsilloRepository;

    public final CuentaRepository cuentaRepository;

    public BolsilloServiceimpl(BolsilloRepository bolsilloRepository, CuentaRepository cuentaRepository) {
        this.bolsilloRepository = bolsilloRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public BolsilloDTO guardarNuevoBolsillo(BolsilloDTO bolsilloDTO) throws Exception {

        //Validar Datos Bolsillo

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

        //Validar que no exista un bolsillo con el mismo nombre

        if(bolsilloRepository.findBolsilloByNombreBolsillo(bolsilloDTO.getNombreBolsillo()).isPresent()){
            throw new Exception("Ya existe un bolsillo con el nombre: " + bolsilloDTO.getNombreBolsillo());
        }

        //Validar que exista una cuenta con el id enviado

        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(bolsilloDTO.getCuentaId());

        if(cuentaOptional.isEmpty()){
            throw new Exception("No existe una cuenta con el id: " + bolsilloDTO.getCuentaId());
        }

        //Guardar Bolsillo

        Bolsillo bolsillo = BolsilloMapper.dtoToDomain(bolsilloDTO);
        bolsillo.setCuenta(cuentaOptional.get());

        bolsillo= bolsilloRepository.save(bolsillo);
        BolsilloDTO bolsilloDTO1= BolsilloMapper.domainToDto(bolsillo);

        return bolsilloDTO1;
    }

    @Override
    public List<BolsilloDTO> buscarTodosLosBolsillos() {
        return BolsilloMapper.domainToDtoList(bolsilloRepository.findAll());
    }
}
