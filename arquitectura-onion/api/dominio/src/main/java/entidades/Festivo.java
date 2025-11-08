package festivos.api.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivo {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_festivo")
  @SequenceGenerator(name = "seq_festivo", sequenceName = "seq_festivo", allocationSize = 1)
  @Column(name = "id")
  private int id;

  @Column(name = "nombre", length = 100, unique = true)
  private String nombre;

  @Column(name = "dia")
  private int dia;

  @Column(name = "mes")
  private int mes;

  @Column(name = "diaspascuas")
  private int diasPascuas;

  @ManyToOne
  @JoinColumn(name = "idtipo", referencedColumnName = "id")
  private TipoFestivo tipo;

  @ManyToOne
  @JoinColumn(name = "idpais", referencedColumnName = "id")
  private Pais pais;

  public Festivo() {
  }

  public Festivo(int id, String nombre, int dia, int mes, int diasPascuas, TipoFestivo tipo, Pais pais) {
    this.id = id;
    this.nombre = nombre;
    this.dia = dia;
    this.mes = mes;
    this.diasPascuas = diasPascuas;
    this.tipo = tipo;
    this.pais = pais;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setDiasPascuas(int diasPascuas) {
    this.diasPascuas = diasPascuas;
  }

  public void setTipo(TipoFestivo tipo) {
    this.tipo = tipo;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getDiasPascuas() {
    return diasPascuas;
  }

  public TipoFestivo getTipo() {
    return tipo;
  }

  public Pais getPais() {
    return pais;
  }
}
