package com.usbcali.edu.co.cbank1.mocks;

import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.UsuarioDTO;
import com.usbcali.edu.co.cbank1.mapper.UsuarioMapper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class UsuarioMockTest {

    public static Integer ID_DOS = 2;

    public static Integer ID_TRES=3;

    public static String  NOMBRE_DOS = "Juan";

    public static String  NOMBRE_TRES = "David";

    public static String APELLIDO_DOS = "Díaz";

    public static String APELLIDO_TRES = "Cerón";

    public static String CEDULA_DOS = "456123";

    public static String CEDULA_TRES = "123654";

    public static String CORREO_DOS = "diaz@gmail.com";

    public static String CORREO_TRES = "ceron@gmail.com";

    public static Usuario USUARIO_DOS =
            Usuario.builder()
                    .id(ID_DOS)
                    .nombre(NOMBRE_DOS)
                    .apellido(APELLIDO_DOS)
                    .cedula(CEDULA_DOS)
                    .correo(CORREO_DOS)
                    .build();

    public static Usuario USUARIO_TRES =
            Usuario.builder()
                    .id(ID_TRES)
                    .nombre(NOMBRE_TRES)
                    .apellido(APELLIDO_TRES)
                    .cedula(CEDULA_TRES)
                    .correo(CORREO_TRES)
                    .build();


    public static List<Usuario> USUARIOS_LIST =
            Arrays.asList(USUARIO_DOS, USUARIO_TRES);

    public static List<UsuarioDTO> USUARIO_DTO_LIST =
            UsuarioMapper.domainToDtoList(USUARIOS_LIST);


}
