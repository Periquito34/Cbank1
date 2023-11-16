package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mocks.UsuarioMockTest;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import com.usbcali.edu.co.cbank1.service.impl.UsuarioServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceimpl usuarioService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1,1);
    }

    @Test
    void buscarTodos() {
        given(usuarioRepository.findAll())
                .willReturn(UsuarioMockTest.USUARIOS_LIST);

        List<UsuarioDTO> usuariosEsperados
                = usuarioService.buscarTodos();

        assertEquals(usuariosEsperados.size(), 2);
        assertEquals(usuariosEsperados.get(0).getCedula(), UsuarioMockTest.CEDULA_DOS);
    }


}
