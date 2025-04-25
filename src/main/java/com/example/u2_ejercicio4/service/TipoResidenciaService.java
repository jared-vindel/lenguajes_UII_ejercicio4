package com.example.u2_ejercicio4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.u2_ejercicio4.dto.TipoResidenciaDto;
import com.example.u2_ejercicio4.model.TipoResidencia;
import com.example.u2_ejercicio4.repository.TipoResidenciaRepository;

@Service
public class TipoResidenciaService {

  @Autowired
  private TipoResidenciaRepository tipoResidenciaRepository;

  public TipoResidenciaDto crearResidencia(TipoResidenciaDto residenciaDto){

    TipoResidencia residencia = new TipoResidencia();

    residencia.setDescripcion(residenciaDto.getDescripcion());
    residencia.setPrecioKw(residenciaDto.getPrecioKw());
   
    residenciaDto.setIdTipoResidencia(this.tipoResidenciaRepository.save(residencia).getIdTipoResidencia());

    return residenciaDto;
  }
}
