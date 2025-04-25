package com.example.u2_ejercicio4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.u2_ejercicio4.model.TipoResidencia;

@Repository
public interface TipoResidenciaRepository extends JpaRepository<TipoResidencia, Integer> {

}
