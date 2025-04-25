package com.example.u2_ejercicio4.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.u2_ejercicio4.model.Facturacion;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, LocalDate>{

}
