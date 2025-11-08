package festivos.api.aplicacion.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import festivos.api.core.servicios.*;
import festivos.api.dominio.entidades.Festivo;
import festivos.api.dominio.dtos.FestivoDto;
import festivos.api.infraestructura.repositorios.*;
import festivos.api.aplicacion.servicios.FechasServicio;

@Service
public class FestivoServicio implements IFestivoServicio {
  private IFestivoRepositorio festivoRepositorio;

  public FestivoServicio(IFestivoRepositorio festivoRepositorio) {
    this.festivoRepositorio = festivoRepositorio;
  }

  private List<FestivoDto> obtenerFechasFestivasPorPais(int idPais, int anio) {
    List<FestivoDto> fechasFestivos = new ArrayList();
    var festivos = festivoRepositorio.listar(idPais);
    for (var festivo : festivos) {
      LocalDate fechaFestivo;
      switch (festivo.getTipo().getId()) {
        case 1:
          fechaFestivo = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
          fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
          break;

        case 2:
          fechaFestivo = FechasServicio.obtenerSiguienteLunes(LocalDate.of(anio, festivo.getMes(), festivo.getDia()));
          fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
          break;
        case 3:
          fechaFestivo = FechasServicio.agregarDias(FechasServicio.obtenerDiaDePascua(anio), festivo.getDiasPascuas());
          fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
          break;
        case 4:
          fechaFestivo = FechasServicio.obtenerSiguienteLunes(
              FechasServicio.agregarDias(FechasServicio.obtenerDiaDePascua(anio), festivo.getDiasPascuas()));
          fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
          break;
      }
    }
    return fechasFestivos;
  }

  @Override
  public List<Festivo> listar(int idPais) {
    return festivoRepositorio.listar(idPais);
  }

  @Override
  public Festivo guardar(Festivo festivo) {
    return festivoRepositorio.save(festivo);
  }

  @Override
  public boolean eliminar(int id) {
    try {
      festivoRepositorio.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public Festivo actualizar(Festivo festivo) {
    if (festivoRepositorio.findById(festivo.getId()).isEmpty()) {
      return null;
    }
    festivo.setId(festivo.getId());
    return festivoRepositorio.save(festivo);
  }

  @Override
  public List<FestivoDto> listar(int idPais, int anio) {
    return obtenerFechasFestivasPorPais(idPais, anio);
  }

  public boolean verificar(int idPais, LocalDate fecha) {
    var fechasFestivos = obtenerFechasFestivasPorPais(idPais, fecha.getYear());
    return fechasFestivos.stream().anyMatch(f -> f.getFecha().equals(fecha));
  }
}
