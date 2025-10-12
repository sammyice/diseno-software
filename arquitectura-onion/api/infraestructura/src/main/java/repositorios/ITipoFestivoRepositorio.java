package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import festivos.api.dominio.entidades.TipoFestivo;

@Repository
public interface ITipoFestivoRepositorio extends JpaRepository<TipoFestivo, Long> {
  @Query("SELECT tf FROM tipofestivo tf")
  public List<TipoFestivo> listar();

  @Query("SELECT tf FROM tipofestivo tf WHERE tf.id = :id")
  public TipoFestivo obtener(Long id);

  @Query("DELETE FROM tipofestivo tf WHERE tf.id = :id")
  public void eliminar(Long id);

  @Query("UPDATE tipofestivo tf SET  tf.tipo = :tipo WHERE  tf.id = :id")
  public void actualizar(Long id, String tipo);

  @Query("INSERT INTO tipofestivo (tipo) VALUES (:tipo)")
  public void guardar(String tipo);
}
