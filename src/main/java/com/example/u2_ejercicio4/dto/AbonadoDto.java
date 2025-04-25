package com.example.u2_ejercicio4.dto;

import java.util.List;

import com.example.u2_ejercicio4.model.Facturacion;
import com.example.u2_ejercicio4.model.TipoResidencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AbonadoDto {

  private String dni;

  private String nombre;

  private String apellido;

  private String telefono;
  
  private TipoResidencia residencia;
  
  private List<Facturacion> facturas;
}
