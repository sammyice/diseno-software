package festivos.api.core.servicios;

import java.util.List;

import festivos.api.dominio.entidades.Festivo;

public interface IFestivoServicio {
  public List<Festivo> listarFestivosPorPais(Long idPais);

  public String verificarFechaFestivo(Long idPais, String anio, String mes, String dia);
}
