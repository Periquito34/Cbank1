package com.usbcali.edu.co.cbank1.mocks;

import com.usbcali.edu.co.cbank1.domain.Cuenta;
import com.usbcali.edu.co.cbank1.domain.Transferencia;

import com.usbcali.edu.co.cbank1.dto.TransferenciaDTO;

import com.usbcali.edu.co.cbank1.mapper.TransferenciaMapper;
import com.usbcali.edu.co.cbank1.mocks.CuentaMockTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
public class TransferenciaMockTest {

    public static Integer ID_DOS = 2;

    public static Integer ID_TRES=3;

    public static Cuenta CUENTAORIGEN_DOS = CuentaMockTest.CUENTA_2;
    public static Cuenta CUENTAORIGEN_TRES = CuentaMockTest.CUENTA_3;

    public static Cuenta CUENTADESTINO_DOS = CuentaMockTest.CUENTA_3;

    public static Cuenta CUENTADESTINO_TRES = CuentaMockTest.CUENTA_2;

    public static float MONTO_DOS = 456123;

    public static float MONTO_TRES = 123654;

    public static String FECHA_DOS = "22/11/23";

    public static String FECHA_TRES = "23/11/23";

    public static Transferencia TRANSFERENCIA_DOS =
            Transferencia.builder()
                    .id(ID_DOS)
                    .cuentaOrigen(CUENTAORIGEN_DOS)
                    .cuentaDestino(CUENTADESTINO_DOS)
                    .monto(MONTO_DOS)
                    .fecha(FECHA_DOS)
                    .build();



    public static Transferencia TRANSFERENCIA_TRES =
            Transferencia.builder()
                    .id(ID_TRES)
                    .cuentaOrigen(CUENTAORIGEN_TRES)
                    .cuentaDestino(CUENTADESTINO_TRES)
                    .monto(MONTO_TRES)
                    .fecha(FECHA_TRES)
                    .build();


    public static List<Transferencia> TRANSFERENCIA_LIST =
            Arrays.asList(TRANSFERENCIA_DOS, TRANSFERENCIA_TRES);

    public static List<TransferenciaDTO> TRANSFERENCIA_DTO_LIST =
            TransferenciaMapper.domainToDtoList(TRANSFERENCIA_LIST);


}
