package festivos.api.core.servicios;

import java.util.List;

import festivos.api.dominio.entidades.Pais;

public interface IPaisServicio {
  public List<Pais> listar();

  public Pais obtener(Long id);

  public Pais guardar(Pais pais);

  public boolean eliminar(Long id);

  public Pais actualizar(Pais pais);

  public List<Pais> buscar(String nombre);
}
