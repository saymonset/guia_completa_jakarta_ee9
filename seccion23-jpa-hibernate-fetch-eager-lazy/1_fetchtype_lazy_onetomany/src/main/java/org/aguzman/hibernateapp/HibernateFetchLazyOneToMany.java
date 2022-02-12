package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Cliente cliente = em.find(Cliente.class, 1L);
        /*EAGER, significa entusiasta*/
        /*La consulta ue con lazy, no trae direcciones por default, almenos
        que hagas un cliente.getDireccion, automaticamente hace un fetch con direccion y se hace el inner join con la tabla direccion*/
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
