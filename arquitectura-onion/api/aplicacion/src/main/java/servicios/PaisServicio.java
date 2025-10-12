package festivos.api.aplicacion.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import festivos.api.dominio.entidades.Pais;
import festivos.api.core.servicios.IPaisServicio;
import festivos.api.infraestructura.repositorios.IPaisRepositorio;

@Service
public class PaisServicio implements IPaisServicio {
  private IPaisRepositorio paisRepositorio;

  public PaisServicio(IPaisRepositorio paisRepositorio) {
    this.paisRepositorio = paisRepositorio;
  }

  @Override
  public List<Pais> listar() {
    return paisRepositorio.findAll();
  }

  @Override
  public Pais obtener(Long id) {
    return paisRepositorio.findById(id).orElse(null);
  }

  @Override
  public Pais guardar(Pais pais) {
    pais.setId(0L);
    return paisRepositorio.save(pais);
  }

  @Override
  public boolean eliminar(Long id) {
    try {
      paisRepositorio.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public Pais actualizar(Pais pais) {
    if (paisRepositorio.findById(pais.getId()).isEmpty()) {
      return null;
    }
    return paisRepositorio.save(pais);
  }

  @Override
  public List<Pais> buscar(String nombre) {
    return paisRepositorio.buscar(nombre);
  }
}
