package com.usbcali.edu.co.cbank1.service.impl;

import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.mapper.TransferenciaMapper;
import com.usbcali.edu.co.cbank1.repository.CuentaRepository;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import com.usbcali.edu.co.cbank1.service.TransferenciaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaServiceimpl implements TransferenciaService {

    public final TransferenciaRepository transferenciaRepository;

    public final CuentaRepository cuentaRepository;

    public TransferenciaServiceimpl(TransferenciaRepository transferenciaRepository, CuentaRepository cuentaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public TransferenciaDTO guardarTransferencia(TransferenciaDTO transferenciaDTO) throws Exception {
        //Validar Datos Transferencia

        if(transferenciaDTO == null ){
            throw new Exception("Transferencia no puede ser nulo");
        }

        if(transferenciaDTO.getMonto() < 0){
            throw new Exception("Valor no puede ser menor a 0");
        }

        if(transferenciaDTO.getFecha() == null){
            throw new Exception("Fecha no puede ser nulo");
        }

        if(transferenciaDTO.getCuentaOrigen() == null || transferenciaDTO.getCuentaOrigen() < 0){
            throw new Exception("Cuenta Origen no puede ser nulo o menor a 0");
        }

        if(transferenciaDTO.getCuentaDestino() == null || transferenciaDTO.getCuentaDestino() < 0){
            throw new Exception("Cuenta Destino no puede ser nulo o menor a 0");
        }

        //Validar que existan las cuentas de origen y destino

        Optional<Cuenta> cuentaOptionalOrigen = cuentaRepository.findById(transferenciaDTO.getCuentaOrigen());
        Optional<Cuenta> cuentaOptionalDestino = cuentaRepository.findById(transferenciaDTO.getCuentaDestino());

        if(cuentaOptionalOrigen.isEmpty()){
            throw new Exception("No existe una cuenta con el id: " + transferenciaDTO.getCuentaOrigen());
        }

        if(cuentaOptionalDestino.isEmpty()){
            throw new Exception("No existe una cuenta con el id: " + transferenciaDTO.getCuentaDestino());
        }


        //Guardar Transferencia

        Transferencia transferencia = TransferenciaMapper.dtoToDomain(transferenciaDTO);
        transferencia.setCuentaOrigen(cuentaOptionalOrigen.get());
        transferencia.setCuentaDestino(cuentaOptionalDestino.get());

        transferencia= transferenciaRepository.save(transferencia);

        return TransferenciaMapper.domainToDto(transferencia);
    }

    @Override
    public List<TransferenciaDTO> buscarTodasLasTransferencias() {
        return TransferenciaMapper.domainToDtoList(transferenciaRepository.findAll());
    }
}
