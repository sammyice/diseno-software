package festivos.api.aplicacion.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import festivos.api.dominio.entidades.TipoFestivo;
import festivos.api.core.servicios.ITipoFestivoServicio;
import festivos.api.infraestructura.repositorios.ITipoFestivoRepositorio;

@Service
public class TipoFestivoServicio implements ITipoFestivoServicio {
  private ITipoFestivoRepositorio tipoFestivoRepositorio;

  public TipoFestivoServicio(ITipoFestivoRepositorio tipoFestivoRepositorio) {
    this.tipoFestivoRepositorio = tipoFestivoRepositorio;
  }

  @Override
  public List<TipoFestivo> listar() {
    return tipoFestivoRepositorio.findAll();
  }

  @Override
  public TipoFestivo obtener(Long id) {
    return tipoFestivoRepositorio.findById(id).orElse(null);
  }

  @Override
  public TipoFestivo guardar(TipoFestivo tipoFestivo) {
    tipoFestivo.setId(0L);
    return tipoFestivoRepositorio.save(tipoFestivo);
  }

  @Override
  public boolean eliminar(Long id) {
    try {
      tipoFestivoRepositorio.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public TipoFestivo actualizar(TipoFestivo tipoFestivo) {
    tipoFestivo.setId(tipoFestivo.getId());
    return tipoFestivoRepositorio.save(tipoFestivo);
  }
}
