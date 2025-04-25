package com.example.u2_ejercicio4.dto;

import com.example.u2_ejercicio4.model.Abonado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoResidenciaDto {

  private int idTipoResidencia;

  private String descripcion;

  private double precioKw;
  
  private Abonado abonado;

}
