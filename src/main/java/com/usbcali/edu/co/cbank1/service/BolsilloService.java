package com.usbcali.edu.co.cbank1.service;

import com.usbcali.edu.co.cbank1.dto.BolsilloDTO;

import java.util.List;

public interface BolsilloService {

    BolsilloDTO guardarNuevoBolsillo(BolsilloDTO bolsilloDTO) throws Exception;

    List<BolsilloDTO> buscarTodosLosBolsillos();

}
