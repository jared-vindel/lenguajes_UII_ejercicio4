package com.example.u2_ejercicio4.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="facturacion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facturacion {
  
  @Id
  @Column(name="fechafacturacion")
  private LocalDate fechaFacturacion;

  @Column(name="kwsconsumidos")
  private double kwsConsumidos;

  @Column(name="totalfacturacion")
  private double totalFacturacion;

  @ManyToOne
  @JoinColumn(name="dni", referencedColumnName="dni")
  private Abonado abonado;
}
