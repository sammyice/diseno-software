package festivos.api.aplicacion.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import festivos.api.core.servicios.*;
import festivos.api.dominio.entidades.Festivo;
import festivos.api.infraestructura.repositorios.*;

@Service
public class FestivoServicio implements IFestivoServicio {
  private IFestivoRepositorio festivoRepositorio;

  public FestivoServicio(IFestivoRepositorio festivoRepositorio) {
    this.festivoRepositorio = festivoRepositorio;
  }

  @Override
  public List<Festivo> listarFestivosPorPais(Long idPais) {
    return festivoRepositorio.listarFestivosPorPais(idPais);
  }

  @Override
  public String verificarFechaFestivo(Long idPais, String anio, String mes, String dia) {
    // TODO Implementar verificacion de fecha
    throw new UnsupportedOperationException("Unimplemented method 'verificarFechaFestivo'");
  }

}
