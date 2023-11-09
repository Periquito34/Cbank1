package com.usbcali.edu.co.cbank1.repository;

import com.usbcali.edu.co.cbank1.domain.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    Optional<Transferencia> findTransferenciaById(Integer id);
}
