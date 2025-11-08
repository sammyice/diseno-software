package festivos.api.presentacion.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import festivos.api.core.servicios.IFestivoServicio;
import festivos.api.dominio.dtos.FestivoDto;
import festivos.api.dominio.entidades.Festivo;

@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {
  private IFestivoServicio festivoServicio;

  public FestivoControlador(IFestivoServicio festivoServicio) {
    this.festivoServicio = festivoServicio;
  }

  @RequestMapping(value = "/listar/{idPais}", method = RequestMethod.GET)
  public List<Festivo> listar(@PathVariable int idPais) {
    return festivoServicio.listar(idPais);
  }

  @RequestMapping(value = "/listar/{idPais}/{anio}", method = RequestMethod.GET)
  public List<FestivoDto> listar(@PathVariable int idPais, @PathVariable int anio) {
    return festivoServicio.listar(idPais, anio);
  }

  @RequestMapping(value = "/guardar", method = RequestMethod.POST)
  public Festivo guardar(@RequestBody Festivo festivo) {
    System.out.println(festivo);
    return festivoServicio.guardar(festivo);
  }

  @RequestMapping(value = "/verificar/{idPais}/{anio}/{mes}/{dia}", method = RequestMethod.GET)
  public ResponseEntity<?> verificar(@PathVariable int idPais, @PathVariable int anio, @PathVariable int mes,
      @PathVariable int dia) {
    try {
      LocalDate fecha = LocalDate.of(anio, mes, dia);
      boolean esFestivo = festivoServicio.verificar(idPais, fecha);
      return ResponseEntity.ok(esFestivo);
    } catch (DateTimeException e) {
      return ResponseEntity.badRequest().body("Fecha inválida");
    }
  }

  @RequestMapping(value = "/actualizar", method = RequestMethod.PATCH)
  public Festivo actualizar(@RequestBody Festivo festivo) {
    return festivoServicio.actualizar(festivo);
  }

  @RequestMapping(value = "/eliminar/{idPais}", method = RequestMethod.DELETE)
  public boolean eliminar(@PathVariable int idPais) {
    return festivoServicio.eliminar(idPais);
  }
}
