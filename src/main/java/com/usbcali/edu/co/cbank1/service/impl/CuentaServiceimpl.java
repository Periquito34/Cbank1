package com.usbcali.edu.co.cbank1.service.impl;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import com.usbcali.edu.co.cbank1.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceimpl implements CuentaService {

    public final CuentaRepository cuentaRepository;
    public final UsuarioRepository usuarioRepository;

    public CuentaServiceimpl(CuentaRepository cuentaRepository, UsuarioRepository usuarioRepository) {
        this.cuentaRepository = cuentaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public CuentaDTO guardarNuevaCuenta(CuentaDTO cuentaDTO) throws Exception {

        //Validar Datos Cuenta

        if(cuentaDTO == null){
            throw new Exception("La cuenta no puede ser nula");
        }

        if(cuentaDTO.getSaldo() < 0){
            throw new Exception("Dinero no puede ser menor a 0");
        }

        if(cuentaDTO.getPin() <0 && cuentaDTO.getPin() > 9999){
            throw new Exception("Pin no puede ser menor a 0 o mayor a 9999");
        }

        if(cuentaDTO.getUsuarioId() == null || cuentaDTO.getUsuarioId() == 0){
            throw new Exception("Usuario no puede ser nulo");
        }
        if(cuentaDTO.getTelefono().length() != 10){
            throw new Exception("Telefono debe tener 10 digitos");
        }

        //Validar que no exista una cuenta con el mismo telefono

        if(cuentaRepository.findCuentaByTelefono(cuentaDTO.getTelefono()).isPresent()){
            throw new Exception("Ya existe una cuenta con el telefono: " + cuentaDTO.getTelefono());
        }

        //Validar que exista un usuario con el id enviado

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cuentaDTO.getUsuarioId());

        if(usuarioOptional.isEmpty()){
            throw new Exception("No existe un usuario con el id: " + cuentaDTO.getUsuarioId());
        }

        //Guardar Cuenta

        Cuenta cuenta = CuentaMapper.dtoToDomain(cuentaDTO);
        cuenta.setUsuario(usuarioOptional.get());

        cuenta= cuentaRepository.save(cuenta);
        CuentaDTO cuentaDTO1 = CuentaMapper.domainToDto(cuenta);


        return cuentaDTO1;
    }

    @Override
    public List<CuentaDTO> buscartodaslascuentas(){
        return CuentaMapper.domainToDtoList(cuentaRepository.findAll());
    }
}
