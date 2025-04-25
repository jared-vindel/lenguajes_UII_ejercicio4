package com.example.u2_ejercicio4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.u2_ejercicio4.dto.AbonadoDto;
import com.example.u2_ejercicio4.dto.FacturacionDto;
import com.example.u2_ejercicio4.dto.FacturarDto;
import com.example.u2_ejercicio4.service.AbonadoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/abonados")
public class AbonadoController {

  @Autowired
  private AbonadoService abonadoService;

  @PostMapping("/crear")
  public AbonadoDto crearAbonado(@RequestBody AbonadoDto abonadoDto) {

    return this.abonadoService.crearAbonado(abonadoDto);
  }

  @GetMapping("/obtener/{dni}")
  public AbonadoDto obtenerAbonado(@PathVariable String dni) {
      return this.abonadoService.obtenerAbonado(dni);
  }
  
  @DeleteMapping("/eliminar/{dni}")
  public String eliminarAbonado(@PathVariable String dni){
    return this.abonadoService.eliminarAbonado(dni);
  }

  @PostMapping("/facturar")
  public FacturacionDto facturar(@RequestBody FacturarDto fac) {
      //TODO: process POST request
      
      return this.abonadoService.facturar(fac);
  }
  
}
