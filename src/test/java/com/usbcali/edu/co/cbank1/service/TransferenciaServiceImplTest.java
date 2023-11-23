package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mocks.TransferenciaMockTest;
import com.usbcali.edu.co.cbank1.mocks.UsuarioMockTest;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import com.usbcali.edu.co.cbank1.service.impl.TransferenciaServiceimpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Equals;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
@SpringBootTest
public class TransferenciaServiceImplTest {
    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaServiceimpl transferenciaService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1,1);
    }

    @Test
    void buscarTodos() {
        given(transferenciaRepository.findAll())
                .willReturn(TransferenciaMockTest.TRANSFERENCIA_LIST);

        List<TransferenciaDTO> transferenciasEsperadas
                = transferenciaService.buscarTodasLasTransferencias();

        assertEquals(transferenciasEsperadas.size(), 2);
        assertEquals(transferenciasEsperadas.get(0).getId(), TransferenciaMockTest.ID_DOS);
    }

}
