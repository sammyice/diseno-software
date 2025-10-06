package festivos.api.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pais")
  @SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "nombre", length = 100, unique = true)
  private String nombre;

  public Pais() {
  }

  public Pais(Long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  } 

  public void setId(Long id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }
}
