package com.usbcali.edu.co.cbank1.service;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;

import java.util.List;

public interface TransferenciaService {

    TransferenciaDTO guardarTransferencia(TransferenciaDTO transferenciaDTO) throws Exception;

    List<TransferenciaDTO> buscarTodasLasTransferencias();

    List<TransferenciaDTO> obtenerHistorialDeTransferencias(Integer cuentaId);

}
