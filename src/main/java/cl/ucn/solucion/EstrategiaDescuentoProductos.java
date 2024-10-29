package cl.ucn.solucion;

import cl.ucn.modelo.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstrategiaDescuentoProductos implements EstrategiaDescuento{
    @Override
    public double aplicarDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                                String fechaActual) {

        if (productos.size() > 2)
            return 100;
        else
            return 0;
    }
}
