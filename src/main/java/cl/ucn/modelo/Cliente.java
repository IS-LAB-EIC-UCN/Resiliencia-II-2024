package cl.ucn.modelo;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    private long rut;
    private String nombre;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name="anho_registro")
    private int anhoRegistro;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public Long getRut() {
        return rut;
    }

    public void setRut(long rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnhoRegistro() {
        return anhoRegistro;
    }

    public void setAnhoRegistro(int anhoRegistro) {
        this.anhoRegistro = anhoRegistro;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
