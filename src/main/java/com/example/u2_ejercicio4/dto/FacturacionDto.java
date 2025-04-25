package com.example.u2_ejercicio4.dto;

import java.time.LocalDate;

import com.example.u2_ejercicio4.model.Abonado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacturacionDto {

  private LocalDate fechaFacturacion;

  private double kwsConsumidos;

  private double totalFacturacion;

  private Abonado abonado;
}
