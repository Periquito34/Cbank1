package com.usbcali.edu.co.cbank1.service.impl;


import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mapper.UsuarioMapper;
import com.usbcali.edu.co.cbank1.repository.UsuarioRepository;
import com.usbcali.edu.co.cbank1.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceimpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceimpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO guardarNuevoUsuario(UsuarioDTO usuarioDTO) throws Exception {

        //Validar Datos Usuario

        if(usuarioDTO == null){
            throw new Exception("El usuario no puede ser nulo");
        }

        if(usuarioDTO.getNombre() == null || usuarioDTO.getNombre().trim().equals("")){
            throw new Exception("El nombre del usuario no puede ser nulo o vacio");
        }

        if(usuarioDTO.getApellido() == null || usuarioDTO.getApellido().trim().equals("")){
            throw new Exception("El apellido del usuario no puede ser nulo o vacio");
        }

        if(usuarioDTO.getCedula() == null || usuarioDTO.getCedula().trim().equals("")){
            throw new Exception("La cedula del usuario no puede ser nulo o vacio");
        }

        if(usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().trim().equals("")){
            throw new Exception("El correo del usuario no puede ser nulo o vacio");
        }

        //Validar que n exista otro usuario con la misma cedula

        Optional<Usuario> usuarioPorCedula = usuarioRepository.findUsuarioByCedula(usuarioDTO.getCedula());

        if(usuarioPorCedula.isPresent()){
            throw new Exception("Ya existe un usuario con la cedula: " + usuarioDTO.getCedula());
        }

        //Validar que n exista otro usuario con el mismo correo

        Optional<Usuario> usuarioPorCorreo = usuarioRepository.findUsuarioByCorreo(usuarioDTO.getCorreo());

        if(usuarioPorCorreo.isPresent()){
            throw new Exception("Ya existe un usuario con el correo: " + usuarioDTO.getCorreo());
        }

        //Registrar Usuario en la base de datos

        Usuario usuario = UsuarioMapper.dtoToDomain(usuarioDTO);

        usuario = usuarioRepository.save(usuario);

        //Retonar Usuario mapeado en DTO

        usuarioDTO = UsuarioMapper.domainToDto(usuario);
        return usuarioDTO;
    }
}
