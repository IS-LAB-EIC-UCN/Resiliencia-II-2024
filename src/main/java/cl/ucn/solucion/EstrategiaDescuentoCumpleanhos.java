package cl.ucn.solucion;

import cl.ucn.modelo.Producto;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class EstrategiaDescuentoCumpleanhos implements  EstrategiaDescuento{
    @Override
    public double aplicarDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                                String fechaActual) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(fechaNacimiento, formatter);
        LocalDate date2 = LocalDate.parse(fechaActual, formatter);
        boolean esMismoDiayMes = (date1.getMonthOfYear() == date2.getMonthOfYear()) &&
                (date1.getDayOfMonth() == date2.getDayOfMonth());
        if (esMismoDiayMes)
            return 100;
        else
            return 0;
    }
}
