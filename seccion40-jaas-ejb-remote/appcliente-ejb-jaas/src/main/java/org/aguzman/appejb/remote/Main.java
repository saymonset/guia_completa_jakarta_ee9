package org.aguzman.appejb.remote;

import org.aguzman.webapp.ejb.models.Producto;
import org.aguzman.webapp.ejb.service.ServiceEjbRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        ServiceEjbRemote service = null;
        ServiceEjbRemote service2 = null;

        //final Properties env = new Properties();
        //env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        //env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        //env.put("jboss.naming.client.ejb.context", true);
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote-jaas/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjbRemote?stateful");
            service2 = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote-jaas/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjbRemote?stateful");

            /*La seguridad para el cliente es igual, no se hace nada*/
            /*Como autenticamos un cliente ejb de forma remota, en resource creamos un archivo properties jndi.properties
            *
            * Se tiene que llamarexactamente con este nombre.
            * Esta comunicacion de credenciales va a depender del
            * servidor de aplicaciones. Esto es para JBOSS-WILDFLY,
            * pero si estan usando otro, es distinto nombre
            *
            * */
            String saludo = service.saludar("Andres");
            String saludo2 = service2.saludar("John");
            System.out.println(saludo);
            System.out.println(saludo2);
            service.listar().forEach(System.out::println);

            Producto p = service.crear(new Producto("sandia"));
            System.out.println("nuevo producto: " + p);


        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
