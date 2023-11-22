package com.usbcali.edu.co.cbank1.service.impl;


import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.mapper.TransferenciaMapper;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import com.usbcali.edu.co.cbank1.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceimpl implements CuentaService {

    public final CuentaRepository cuentaRepository;
    public final UsuarioRepository usuarioRepository;

    private final TransferenciaRepository transferenciaRepository;

    public CuentaServiceimpl(CuentaRepository cuentaRepository, UsuarioRepository usuarioRepository, TransferenciaRepository transferenciaRepository) {
        this.cuentaRepository = cuentaRepository;
        this.usuarioRepository = usuarioRepository;
        this.transferenciaRepository = transferenciaRepository;
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

    private List<Cuenta> cuentas; // Supongamos que cuentas es una lista de objetos Cuenta

    @Override
    public CuentaDTO obtenerCuentaPorId(Integer id) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);

        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();
            return CuentaMapper.domainToDto(cuenta);
        } else {
            throw new Exception("No se encontró ninguna cuenta con el ID especificado.");
        }
    }


    @Override
    public CuentaDTO actualizarCuenta(CuentaDTO cuentaDTO) throws Exception {
        // Validar que la cuentaDTO no sea nula y que tenga un ID válido
        if (cuentaDTO == null || cuentaDTO.getId() == null) {
            throw new Exception("La cuenta no puede ser nula y debe tener un ID válido.");
        }

        // Verificar si la cuenta existe en la base de datos
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(cuentaDTO.getId());

        if (cuentaOptional.isPresent()) {
            // Actualizar la información de la cuenta con los datos de cuentaDTO
            Cuenta cuenta = cuentaOptional.get();
            cuenta.setSaldo(cuentaDTO.getSaldo());  // Actualiza el saldo u otros campos según necesites

            // Guardar la cuenta actualizada en la base de datos
            cuenta = cuentaRepository.save(cuenta);
            return CuentaMapper.domainToDto(cuenta);
        } else {
            throw new Exception("No se encontró ninguna cuenta con el ID especificado.");
        }
    }

    @Override
    public Integer obtenerIdCuentaPorTelefono(String telefono) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findCuentaByTelefono(telefono);

        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();
            return cuenta.getId();
        } else {
            throw new Exception("No se encontró ninguna cuenta con el teléfono especificado.");
        }
    }

    @Override
    public boolean verificarCuentaPorIdYPin(Integer id, int pin) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);

        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();
            return cuenta.getPin() == pin;
        } else {
            throw new Exception("No se encontró ninguna cuenta con el ID especificado.");
        }

    }

    @Override
    public CuentaDTO agregarSaldo(Integer idCuenta, float monto) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(idCuenta);

        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();
            cuenta.setSaldo(cuenta.getSaldo() + monto);

            // Guardar la cuenta actualizada en la base de datos
            cuenta = cuentaRepository.save(cuenta);

            return CuentaMapper.domainToDto(cuenta);
        } else {
            throw new Exception("No se encontró ninguna cuenta con el ID especificado.");
        }

    }


}
