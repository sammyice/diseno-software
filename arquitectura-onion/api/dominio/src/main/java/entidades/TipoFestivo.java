package festivos.api.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipofestivo")
public class TipoFestivo {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipofestivo")
  @SequenceGenerator(name = "seq_tipofestivo", sequenceName = "seq_tipofestivo", allocationSize = 1)
  @Column(name = "id")
  private Long id;

   @Column(name = "tipo", length = 100, unique = true)
  private String tipo;

  public TipoFestivo() {
  }

  public TipoFestivo(Long id, String tipo) {
    this.id = id;
    this.tipo = tipo;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Long getId() {
    return id;
  }

  public String getTipo() {
    return tipo;
  }
}
