package com.usbcali.edu.co.cbank1.mocks;

import com.usbcali.edu.co.cbank1.domain.Cuenta;

import com.usbcali.edu.co.cbank1.domain.Usuario;
import com.usbcali.edu.co.cbank1.dto.CuentaDTO;
import com.usbcali.edu.co.cbank1.mapper.CuentaMapper;
import com.usbcali.edu.co.cbank1.mocks.UsuarioMockTest;

import java.util.Arrays;
import java.util.List;

public class CuentaMockTest {

    public static Integer CUENTA_DOS = 2;

    public static Integer CUENTA_TRES = 3;

    public static float SALDO_DOS= 35223;

    public static float SALDO_TRES = 234234;

    public static int PIN_DOS = 3623;

    public static int PIN_TRES = 2344;

    public static Usuario USUARIO_ID_DOS = UsuarioMockTest.USUARIO_DOS;

    public static Usuario USUARIO_ID_TRES = UsuarioMockTest.USUARIO_TRES;

    public static String TELEFONO_DOS = "918240147";

    public static String TELEFONO_TRES = "18714710";

    public static Cuenta CUENTA_2 =
            Cuenta.builder()
                    .id(CUENTA_DOS)
                    .saldo(SALDO_DOS)
                    .pin(PIN_DOS)
                    .usuario(USUARIO_ID_DOS)
                    .telefono(TELEFONO_DOS)
                    .build();



    public static Cuenta CUENTA_3 =
            Cuenta.builder()
                    .id(CUENTA_TRES)
                    .saldo(SALDO_TRES)
                    .pin(PIN_TRES)
                    .usuario(USUARIO_ID_TRES)
                    .telefono(TELEFONO_TRES)
                    .build();


    public static List<Cuenta> CUENTA_LIST =
            Arrays.asList(CUENTA_2, CUENTA_3);

    public static List<CuentaDTO> CUENTA_DTO_LIST =
            CuentaMapper.domainToDtoList(CUENTA_LIST);

}
