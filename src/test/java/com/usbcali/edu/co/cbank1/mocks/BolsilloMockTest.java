package com.usbcali.edu.co.cbank1.mocks;

import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import com.usbcali.edu.co.cbank1.domain.Cuenta;

import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;

import com.usbcali.edu.co.cbank1.mapper.BolsilloMapper;


import java.util.Arrays;
import java.util.List;

public class BolsilloMockTest {

    public static Integer BOLSILLO_DOS = 2;
    public static Integer BOLSILLO_TRES = 2;

    public static float DINERO_DOS = 125343F;

    public static float DINERO_TRES = 2352532F;

    public static String NOMBRE_BOLSILLO_DOS = "AHORROS";

    public static String NOMBRE_BOLSILLO_TRES = "GASTOS";

    public static Cuenta CUENTA_DOS = CuentaMockTest.CUENTA_2 ;

    public static Cuenta CUENTA_TRES = CuentaMockTest.CUENTA_3;


    public static Bolsillo BOLSILLO_2 =
            Bolsillo.builder()
                    .id(BOLSILLO_DOS)
                    .dinero(DINERO_DOS)
                    .nombreBolsillo(NOMBRE_BOLSILLO_DOS)
                    .cuenta(CUENTA_DOS)
                    .build();



    public static Bolsillo BOLSILLO_3 =
            Bolsillo.builder()
                    .id(BOLSILLO_TRES)
                    .dinero(DINERO_TRES)
                    .nombreBolsillo(NOMBRE_BOLSILLO_TRES)
                    .cuenta(CUENTA_TRES)
                    .build();


    public static List<Bolsillo> BOLSILLO_LIST =
            Arrays.asList(BOLSILLO_2, BOLSILLO_3);

    public static List<BolsilloDTO> BOLSILLO_DTO_LIST =
            BolsilloMapper.domainToDtoList(BOLSILLO_LIST);



}
