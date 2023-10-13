package com.usbcali.edu.co.cbank1.mapper;

import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;

import java.util.List;

public class UsuarioMapper {

    public static Usuario dtoToDomain(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .id(usuarioDTO.getId())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .cedula(usuarioDTO.getCedula())
                .correo(usuarioDTO.getCorreo())
                .build();
    }

    public static UsuarioDTO domainToDto(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .cedula(usuario.getCedula())
                .correo(usuario.getCorreo())
                .build();
    }

    public List <Usuario> dtoToDomainList(List<UsuarioDTO> usuarioDTOS){
        return usuarioDTOS.stream().map(UsuarioMapper::dtoToDomain).toList();
    }

    public List <UsuarioDTO> domainToDtoList(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioMapper::domainToDto).toList();
    }


}
