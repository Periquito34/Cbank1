package com.usbcali.edu.co.cbank1.repository;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.usbcali.edu.co.cbank1.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findUsuarioByCedula(String cedula);

    Optional<Usuario> findUsuarioByCorreo(String correo);
}
