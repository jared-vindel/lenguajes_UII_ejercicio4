package com.example.u2_ejercicio4.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.u2_ejercicio4.dto.AbonadoDto;
import com.example.u2_ejercicio4.dto.FacturacionDto;
import com.example.u2_ejercicio4.dto.FacturarDto;
import com.example.u2_ejercicio4.model.Abonado;
import com.example.u2_ejercicio4.model.Facturacion;
import com.example.u2_ejercicio4.model.TipoResidencia;
import com.example.u2_ejercicio4.repository.AbonadoRepository;
import com.example.u2_ejercicio4.repository.FacturacionRepository;
import com.example.u2_ejercicio4.repository.TipoResidenciaRepository;

@Service
public class AbonadoService {

  @Autowired
  private AbonadoRepository abonadoRepository;

  @Autowired
  private TipoResidenciaRepository tipoResidenciaRepository;

  @Autowired
  private FacturacionRepository facturacionRepository;

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

  public AbonadoDto obtenerAbonado(String dni){

    Abonado abonado = new Abonado();
    AbonadoDto abonadoDto = new AbonadoDto();

    abonado = this.abonadoRepository.findById(dni).get();

    //poblamos el abonadoDto
    abonadoDto.setDni(abonado.getDni());
    abonadoDto.setNombre(abonado.getNombre());
    abonadoDto.setApellido(abonado.getApellido());
    abonadoDto.setTelefono(abonado.getTelefono());

    return abonadoDto;

  }

  public String eliminarAbonado(String dni){
    if(this.abonadoRepository.existsById(dni)){
      TipoResidencia deleteAbonado = this.abonadoRepository.findById(dni).get().getResidencia();
      deleteAbonado.setAbonado(null);
      this.tipoResidenciaRepository.save(deleteAbonado);
      return "se eliminó correctamente";
    } else {
      return "El abonado con ese dni, no existe";
    }
  }

  public FacturacionDto facturar(FacturarDto fac){

    Facturacion facturacion = new Facturacion();
    FacturacionDto facturacionDto = new FacturacionDto();

    //valores para poblar facturacion
    LocalDate fechaFacturacion = LocalDate.now();
    double kwConsumido = fac.getKwConsumido();
    double precioKw = this.abonadoRepository.findById(fac.getDni()).get().getResidencia().getPrecioKw();
    double totalFacturacion = kwConsumido * precioKw;

    facturacion.setFechaFacturacion(fechaFacturacion);
    facturacion.setKwsConsumidos(kwConsumido);
    facturacion.setTotalFacturacion(totalFacturacion);
    facturacion.setAbonado(this.abonadoRepository.findById(fac.getDni()).get());
    this.facturacionRepository.save(facturacion);

    facturacionDto.setFechaFacturacion(fechaFacturacion);
    facturacionDto.setKwsConsumidos(kwConsumido);
    facturacionDto.setTotalFacturacion(totalFacturacion);

    return facturacionDto;
  }
}
