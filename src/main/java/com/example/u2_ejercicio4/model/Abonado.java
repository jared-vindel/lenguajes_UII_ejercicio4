package com.example.u2_ejercicio4.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="abonado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Abonado {
  @Id
  @Column(name="dni")
  private String dni;

  private String nombre;

  private String apellido;

  private String telefono;

  @OneToOne
  @JoinColumn(name="idtiporesidencia", referencedColumnName="idtiporesidencia")
  private TipoResidencia residencia;

  @OneToMany(cascade=CascadeType.ALL)
  private List<Facturacion> facturas;

}
