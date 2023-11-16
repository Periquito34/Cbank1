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

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/obtenerTodos")
    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioDTO> usuarios = usuarioService.buscarTodos();
        return usuarios;
    }

    @PostMapping("/guardarUsuario")
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception{
        UsuarioDTO usuarioDTO1 = usuarioService.guardarNuevoUsuario(usuarioDTO);
        return new ResponseEntity<>(usuarioDTO1, HttpStatus.OK);
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(usuarioService.obtenerUsuarioPorId(id), HttpStatus.OK);
    }
}
