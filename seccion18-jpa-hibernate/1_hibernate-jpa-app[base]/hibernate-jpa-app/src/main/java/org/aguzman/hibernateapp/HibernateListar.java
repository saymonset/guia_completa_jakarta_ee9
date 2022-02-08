package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        /*el em.close, no lo podemos cerrar con recusrso como el try con recursos*/
        /*como lo haciamos con el connection porque entityMqanager no es autoclose*/
        /*AutoClosable, no la implementa esa interface, por eso no la podemos cerrar de esa forma*/
        em.close();
    }
}
