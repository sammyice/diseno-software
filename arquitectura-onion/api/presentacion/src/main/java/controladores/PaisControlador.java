package festivos.api.presentacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import festivos.api.core.servicios.IPaisServicio;
import festivos.api.dominio.entidades.Pais;

@RestController
@RequestMapping("/api/paises")
public class PaisControlador {
  private IPaisServicio paisServicio;

  public PaisControlador(IPaisServicio paisServicio) {
    this.paisServicio = paisServicio;
  }

  @RequestMapping(value = "/listar", method = RequestMethod.GET)
  public List<Pais> listar() {
    return paisServicio.listar();
  }

  @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
  public Pais obtener(@PathVariable Long id) {
    return paisServicio.obtener(id);
  }

  @RequestMapping(value = "/guardar", method = RequestMethod.POST)
  public Pais guardar(@RequestBody Pais pais) {
    return paisServicio.guardar(pais);
  }

  @RequestMapping(value = "/actualizar", method = RequestMethod.PATCH)
  public Pais actualizar(@RequestBody Pais pais) {
    return paisServicio.actualizar(pais);
  }

  @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
  public boolean eliminar(@PathVariable Long id) {
    return paisServicio.eliminar(id);
  }

  @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
  public List<Pais> buscar(@PathVariable String nombre) {
    return paisServicio.buscar(nombre);
  }
}
