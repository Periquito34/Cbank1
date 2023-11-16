package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    public UsuarioDTO guardarNuevoUsuario(UsuarioDTO usuarioDTO) throws Exception;

    List<UsuarioDTO> buscarTodos();

    public UsuarioDTO obtenerUsuarioPorId(Integer id) throws Exception;



}
