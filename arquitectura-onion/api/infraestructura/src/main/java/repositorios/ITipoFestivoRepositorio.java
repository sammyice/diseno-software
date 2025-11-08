package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import festivos.api.dominio.entidades.TipoFestivo;

@Repository
public interface ITipoFestivoRepositorio extends JpaRepository<TipoFestivo, Long> {
  @Query("SELECT tf FROM TipoFestivo tf")
  public List<TipoFestivo> listar();
}
