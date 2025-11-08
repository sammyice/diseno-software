package festivos.api.presentacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import festivos.api.core.servicios.ITipoFestivoServicio;
import festivos.api.dominio.entidades.TipoFestivo;

@RestController
@RequestMapping("/api/tipo-festivos")
public class TipoFestivoControlador {
  private ITipoFestivoServicio tipoFestivoServicio;

  public TipoFestivoControlador(ITipoFestivoServicio tipoFestivoServicio) {
    this.tipoFestivoServicio = tipoFestivoServicio;
  }

  @RequestMapping(value = "/listar", method = RequestMethod.GET)
  public List<TipoFestivo> listar() {
    return tipoFestivoServicio.listar();
  }

  @RequestMapping(value = "/guardar", method = RequestMethod.POST)
  public TipoFestivo guardar(@RequestBody TipoFestivo tipoFestivo) {
    System.out.println(tipoFestivo);
    return tipoFestivoServicio.guardar(tipoFestivo);
  }

  @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
  public TipoFestivo actualizar(@RequestBody TipoFestivo tipoFestivo) {
    return tipoFestivoServicio.actualizar(tipoFestivo);
  }

  @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
  public boolean eliminar(@PathVariable Long id) {
    return tipoFestivoServicio.eliminar(id);
  }
}
