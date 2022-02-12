package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        /*Podemos optimizar el rendimieto de la consulta , manteniendo easy
                en direcciones y usando esta consulta con left outer join fetch en direcciones*/
        /*importante el fetch para poblar*/

        /*Con disstinct, el cliente no se repite al tener tres direcciones o dos direccioes, solo aparecera
                el cliente con el arreglo de direcciones y no repetidamente por cada direccion*/
        List<Cliente> clientes = em.createQuery("select distinct c from Cliente c left outer join fetch c.direcciones left outer join fetch c.detalle", Cliente.class).getResultList();
        /*los terminados en many, son bolsas (bags) y si haces los finalizados en many a fetch tipo lazy y hay mas de 1,
                dara error con bolsas en la corrida*/

        clientes.forEach(c -> System.out.println(c.getNombre() + ", direcciones: " + c.getDirecciones()));
        em.close();
    }
}
