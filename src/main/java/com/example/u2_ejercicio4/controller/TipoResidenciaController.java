package com.example.u2_ejercicio4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.u2_ejercicio4.dto.TipoResidenciaDto;
import com.example.u2_ejercicio4.service.TipoResidenciaService;


@RestController
@RequestMapping("/residencias")
public class TipoResidenciaController {

  @Autowired
  private TipoResidenciaService tipoResidenciaService;

  @PostMapping("/crear")
  public TipoResidenciaDto crearResidencia(@RequestBody TipoResidenciaDto residenciaDto) {
      //TODO: process POST request
      
      return this.tipoResidenciaService.crearResidencia(residenciaDto);
  }
  
}
