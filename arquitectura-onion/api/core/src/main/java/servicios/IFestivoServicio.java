package festivos.api.core.servicios;

import java.time.LocalDate;
import java.util.List;

import festivos.api.dominio.dtos.FestivoDto;
import festivos.api.dominio.entidades.Festivo;

public interface IFestivoServicio {
  public List<Festivo> listar(int idPais);

  public Festivo guardar(Festivo festivo);

  public boolean eliminar(int id);

  public Festivo actualizar(Festivo festivo);

  public List<FestivoDto> listar(int idPais, int anio);

  public boolean verificar(int idPais, LocalDate fecha);

}
