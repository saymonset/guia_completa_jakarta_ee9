package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        /*left join o left outer join es lo mismo y va a traer todos los clientes que
                tengan o no tengan direccion*/
        /*con left inner join, va a traer clientes que solo tengan direccionesy si colocamos
                el fetch, significa que va  apoblar el objeto direcciones*/
        Cliente cliente = em.createQuery("select c from Cliente c left outer join fetch c.direcciones " +
                 //aqui hacemos un left outer join a detalle para poblarlos con fetch que se usa en la misma consulta
                "left join fetch c.detalle where c.id=:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        System.out.println(cliente.getNombre() + ", detalle: " + cliente.getDetalle());
        em.close();
    }
}
