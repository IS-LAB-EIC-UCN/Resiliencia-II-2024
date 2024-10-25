package cl.ucn.modelo;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GerenciadorDescuento {

    public List<Integer> calcularPrecioFinal(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                                      String fechaActual) {
        // Descuento por fidelidad >= 2 años -- 500
        // Descuento por cumpleaños -- 100
        // Descuento por categoria casa (hay un producto en esta categoria) -- 200
        // Descuento por cantidad de productos > 2 productos -- 100

        int precioInicial = 0;
        int descuentoFidelidad = 0;
        int descuentoCumpleanhos = 0;
        int descuentoCategoria = 0;
        int descuentoCantProductos = 0;

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

        for (Producto producto : productos) {
            precioInicial += producto.getPrecioProducto();
        }

        //Fidelidad
        if (Integer.valueOf(fechaActual.substring(0,4)) - Integer.valueOf(anhoRegistro) >= 2)
            descuentoFidelidad = 500;

        //Cumpleaños
        LocalDate date1 = LocalDate.parse(fechaNacimiento, formatter);
        LocalDate date2 = LocalDate.parse(fechaActual, formatter);
        boolean esMismoDiayMes = (date1.getMonthOfYear() == date2.getMonthOfYear()) &&
                (date1.getDayOfMonth() == date2.getDayOfMonth());
        if (esMismoDiayMes)
            descuentoCumpleanhos = 100;

        //Categoria
        for (Producto producto : productos) {
                if (producto.getCategoria().equals("casa"))
                    descuentoCategoria = 200;
                break;
        }

        //Cantidad Productos
        if (productos.size() > 2)
            descuentoCantProductos = 100;

        int precioFinal = precioInicial - descuentoFidelidad - descuentoCumpleanhos - descuentoCategoria -
                descuentoCantProductos;

        return new ArrayList<Integer>(Arrays.asList(precioInicial,descuentoFidelidad, descuentoCumpleanhos,
                descuentoCategoria, descuentoCantProductos, precioFinal ));
    }
}
