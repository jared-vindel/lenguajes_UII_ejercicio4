package com.example.u2_ejercicio4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.u2_ejercicio4.dto.AbonadoDto;
import com.example.u2_ejercicio4.service.AbonadoService;


@RestController
@RequestMapping("/abonados")
public class AbonadoController {

  @Autowired
  private AbonadoService abonadoService;

  @PostMapping("/crear")
  public AbonadoDto crearAbonado(@RequestBody AbonadoDto abonadoDto) {

    return this.abonadoService.crearAbonado(abonadoDto);
  }
  
}
