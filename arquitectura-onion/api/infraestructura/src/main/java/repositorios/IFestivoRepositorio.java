package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import festivos.api.dominio.entidades.Festivo;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Long> {
  @Query("SELECT f FROM Festivo f WHERE f.pais.id = :idPais")
  public List<Festivo> listarFestivosPorPais(Long idPais);
}
