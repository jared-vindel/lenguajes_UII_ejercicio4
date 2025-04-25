package com.example.u2_ejercicio4.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tiposresidencia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoResidencia {
  @Id
  @Column(name="idtiporesidencia")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int idTipoResidencia;

  private String descripcion;

  @Column(name="preciokw")
  private double precioKw;

  @OneToOne(mappedBy="residencia",cascade=CascadeType.ALL)
  private Abonado abonado;
}
