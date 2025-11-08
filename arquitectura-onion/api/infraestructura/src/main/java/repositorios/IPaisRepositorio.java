package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import festivos.api.dominio.entidades.Pais;

@Repository
public interface IPaisRepositorio extends JpaRepository<Pais, Long> {
  @Query("SELECT p FROM Pais p WHERE LOWER(p.nombre) LIKE LOWER('%' || :nombre || '%')")
  public List<Pais> buscar(@Param("nombre") String nombre);
}
