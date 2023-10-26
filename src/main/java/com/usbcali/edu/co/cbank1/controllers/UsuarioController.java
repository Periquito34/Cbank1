package com.usbcali.edu.co.cbank1.controllers;


import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mapper.UsuarioMapper;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import com.usbcali.edu.co.cbank1.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/obtenerTodos")
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @PostMapping("/guardarUsuario")
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception{
        UsuarioDTO usuarioDTO1 = usuarioService.guardarNuevoUsuario(usuarioDTO);
        return new ResponseEntity<>(usuarioDTO1, HttpStatus.OK);
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        Usuario usuario = usuarioRepository.getReferenceById(id);
        UsuarioDTO usuarioDTO = UsuarioMapper.domainToDto(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }
}
