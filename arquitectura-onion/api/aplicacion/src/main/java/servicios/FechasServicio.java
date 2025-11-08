package festivos.api.aplicacion.servicios;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FechasServicio {
  public static LocalDate obtenerInicioDeSemanaSanta(int anio) {
    int a = anio % 19;
    int b = anio % 4;
    int c = anio % 7;
    int d = (19 * a + 24) % 30;
    int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

    int dia = 15 + dias;
    int mes = 3;

    if (dia > 31) {
      dia -= 31;
      mes = 4;
    }

    return LocalDate.of(anio, mes, dia);
  }

  public static LocalDate obtenerDiaDePascua(int anio) {
    return agregarDias(obtenerInicioDeSemanaSanta(anio), 7);
  }

  public static LocalDate agregarDias(LocalDate fecha, int numeroDeDias) {
    return fecha.plusDays(numeroDeDias);
  }

  public static LocalDate obtenerSiguienteLunes(LocalDate fecha) {
    DayOfWeek dia = fecha.getDayOfWeek();
    int diasFaltantesParaLunes = (DayOfWeek.MONDAY.getValue() - dia.getValue() + 7) % 7;

    if (diasFaltantesParaLunes == 0) {
      return fecha;
    }

    return fecha.plusDays(diasFaltantesParaLunes);
  }
}
