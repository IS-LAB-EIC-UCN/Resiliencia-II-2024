package cl.ucn.solucion;

import cl.ucn.modelo.Producto;

import java.util.List;

public class EstrategiaDescuentoPorcentual implements EstrategiaDescuento{
    @Override
    public double aplicarDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro, String fechaActual) {

        int suma = 0;
        for (Producto producto : productos) {
            suma += producto.getPrecioProducto();
        }
        if (suma > 50000)
            return 0.1;
        else
            return 0;
    }
}
