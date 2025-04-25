package com.example.u2_ejercicio4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.u2_ejercicio4.dto.AbonadoDto;
import com.example.u2_ejercicio4.model.Abonado;
import com.example.u2_ejercicio4.repository.AbonadoRepository;
import com.example.u2_ejercicio4.repository.TipoResidenciaRepository;

@Service
public class AbonadoService {

  @Autowired
  private AbonadoRepository abonadoRepository;

  @Autowired
  private TipoResidenciaRepository tipoResidenciaRepository;

  public AbonadoDto crearAbonado(AbonadoDto abonadoDto){

    Abonado abonado = new Abonado();

    abonado.setDni(abonadoDto.getDni());
    abonado.setNombre(abonadoDto.getNombre());
    abonado.setApellido(abonadoDto.getApellido());
    abonado.setTelefono(abonadoDto.getTelefono());

    if(this.tipoResidenciaRepository.existsById(abonadoDto.getIdTipoResidencia())){
      abonado.setResidencia(this.tipoResidenciaRepository.findById(abonadoDto.getIdTipoResidencia()).get());
      System.out.println("se imprimió");
    }

    //guardar abonado
    this.abonadoRepository.save(abonado);

    return abonadoDto;
  }


}
