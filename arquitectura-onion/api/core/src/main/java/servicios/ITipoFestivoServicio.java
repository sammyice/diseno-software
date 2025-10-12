package festivos.api.core.servicios;

import java.util.List;

import festivos.api.dominio.entidades.TipoFestivo;

public interface ITipoFestivoServicio {

  public List<TipoFestivo> listar();

  public TipoFestivo obtener(Long id);

  public TipoFestivo guardar(TipoFestivo tipoFestivo);

  public boolean eliminar(Long id);

  public TipoFestivo actualizar(TipoFestivo tipoFestivo);

}
