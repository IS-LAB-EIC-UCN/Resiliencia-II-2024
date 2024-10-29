package cl.ucn.solucion;

import cl.ucn.modelo.Producto;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GerenciadorDescuento {

    private List<EstrategiaDescuento> estrategiaDescuento;
    private List<Producto> productos;
    private String fechaNacimiento;
    private String anhoRegistro;
    private String fechaActual;
    private List<Double> valores;

    public GerenciadorDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                                String fechaActual){
        this.productos = productos;
        this.fechaNacimiento = fechaNacimiento;
        this.anhoRegistro = anhoRegistro;
        this.fechaActual = fechaActual;
        this.estrategiaDescuento = new ArrayList<>();
        this.valores = new ArrayList<Double>();
    }

    public void ingresarEstrategia(EstrategiaDescuento ed){
        this.estrategiaDescuento.add(ed);
    }

    public void aplicarEstrategia(){

        valores.add((double) this.getPrecioInicial());
        int precioInicial = this.getPrecioInicial();
        for (EstrategiaDescuento e : this.estrategiaDescuento){
            valores.add(e.aplicarDescuento(this.productos, this.fechaNacimiento, this.anhoRegistro, this.fechaActual));
        }
    }

    public List<Double> getValores(){
        return this.valores;
    }

    private int getPrecioInicial(){

        int precioInicial =0;

        for (Producto producto : this.productos) {
            precioInicial += producto.getPrecioProducto();
        }
        return precioInicial;
    }


}
