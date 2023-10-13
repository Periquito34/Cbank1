package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/obtenerTodos")
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
}
