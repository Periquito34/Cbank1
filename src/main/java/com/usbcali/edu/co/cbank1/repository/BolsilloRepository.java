package com.usbcali.edu.co.cbank1.repository;

import com.usbcali.edu.co.cbank1.domain.Bolsillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BolsilloRepository extends JpaRepository<Bolsillo, Integer> {
    Optional<Bolsillo> findBolsilloByNombreBolsillo(String nombreBolsillo);

}
