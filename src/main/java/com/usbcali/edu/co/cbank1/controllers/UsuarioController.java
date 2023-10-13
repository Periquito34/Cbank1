package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Transferencia;
import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mapper.TransferenciaMapper;
import com.usbcali.edu.co.cbank1.mapper.UsuarioMapper;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/porId/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Usuario usuario = usuarioRepository.getReferenceById(id);
        UsuarioDTO usuarioDTO = UsuarioMapper.domainToDto(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }
}
