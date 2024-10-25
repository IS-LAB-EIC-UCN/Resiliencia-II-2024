package cl.ucn.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Servicio {

    private final EntityManager em;

    public Servicio(EntityManager entityManager) {
        this.em = entityManager;
    }

    public List<Cliente> getClientes(){

        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

    public List<Producto> getProductosByRut(Long rut) {
        // Crear consulta para obtener los productos del cliente con el RUT dado
        TypedQuery<Producto> query = em.createQuery(
                "SELECT p FROM Producto p WHERE p.cliente.rut = :rut", Producto.class);
        query.setParameter("rut", rut);
        return query.getResultList();
    }

}
