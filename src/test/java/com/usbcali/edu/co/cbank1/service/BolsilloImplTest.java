package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.mocks.BolsilloMockTest;
import com.usbcali.edu.co.cbank1.mocks.TransferenciaMockTest;
import com.usbcali.edu.co.cbank1.repository.BolsilloRepository;
import com.usbcali.edu.co.cbank1.repository.TransferenciaRepository;
import com.usbcali.edu.co.cbank1.service.impl.BolsilloServiceimpl;
import com.usbcali.edu.co.cbank1.service.impl.TransferenciaServiceimpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
@SpringBootTest
public class BolsilloImplTest {

    @Mock
    private BolsilloRepository bolsilloRepository;

    @InjectMocks
    private BolsilloServiceimpl bolsilloService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1,1);
    }

    @Test
    void buscarTodos() {
        given(bolsilloRepository.findAll())
                .willReturn(BolsilloMockTest.BOLSILLO_LIST);

        List<BolsilloDTO> bolsillosEsperados
                = bolsilloService.buscarTodosLosBolsillos();

        assertEquals(bolsillosEsperados.size(), 2);
        assertEquals(bolsillosEsperados.get(0).getNombreBolsillo(), BolsilloMockTest.NOMBRE_BOLSILLO_DOS);
    }
}
