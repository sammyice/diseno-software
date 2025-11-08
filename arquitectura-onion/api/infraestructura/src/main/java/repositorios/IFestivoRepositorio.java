package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import festivos.api.dominio.entidades.Festivo;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {

  @Query("SELECT f FROM Festivo f WHERE f.pais.id = :id")
  public List<Festivo> listar(int id);

}
