package cl.ucn.solucion;

import cl.ucn.modelo.Producto;

import java.util.List;

public class EstrategiaDescuentoFidelidad implements  EstrategiaDescuento{
    @Override
    public double aplicarDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                                String fechaActual) {

        if (Integer.valueOf(fechaActual.substring(0,4)) - Integer.valueOf(anhoRegistro) >= 2)
            return 500;
        else
            return 0;
    }
}
