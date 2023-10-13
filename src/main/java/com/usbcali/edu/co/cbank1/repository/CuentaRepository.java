package com.usbcali.edu.co.cbank1.repository;

import com.usbcali.edu.co.cbank1.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
