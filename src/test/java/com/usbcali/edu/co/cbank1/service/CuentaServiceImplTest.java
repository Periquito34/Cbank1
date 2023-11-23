package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.dto.CuentaDTO;

import com.usbcali.edu.co.cbank1.mocks.CuentaMockTest;

import com.usbcali.edu.co.cbank1.repository.CuentaRepository;

import com.usbcali.edu.co.cbank1.service.impl.CuentaServiceimpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CuentaServiceImplTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaServiceimpl cuentaService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1,1);
    }

    @Test
    void buscarTodos2() {
        given(cuentaRepository.findAll())
                .willReturn(CuentaMockTest.CUENTA_LIST);

        List<CuentaDTO> CuentasEsperadas
                = cuentaService.buscartodaslascuentas();

        assertEquals(CuentasEsperadas.size(), 2);
        assertEquals(CuentasEsperadas.get(0).getTelefono(), CuentaMockTest.TELEFONO_DOS);
    }
}
