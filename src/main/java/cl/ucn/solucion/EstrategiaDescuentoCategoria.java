package cl.ucn.solucion;

import cl.ucn.modelo.Producto;

import java.util.List;

public class EstrategiaDescuentoCategoria implements EstrategiaDescuento{
    @Override
    public double aplicarDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                                String fechaActual) {

        //Categoria
        for (Producto producto : productos) {
            if (producto.getCategoria().equals("casa"))
                return 200;
        }
        return 0;
    }
}
