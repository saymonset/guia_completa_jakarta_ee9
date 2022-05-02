package org.aguzman.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.aguzman.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;
/** @WebService: Parte de la especificacion JAX-WS*/
/*Con esta instruccion le digo que solo los metodos de esa interface son
los que se van a publicar o exponer en el WS,
Una clase puede implementar mas de una interfaces, pero con endpointInterface aseguramos
que solo esos metodos sean los que se publiquen*/
@WebService(endpointInterface = "org.aguzman.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs{
    private int contador;


    /*Para que estos metodos sean publicados en los servicios soap webservices
    deben estar anotados con @WebMethod*/
    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("imprimiendo dentro del servicio web con instancia: " + this);
        contador++;
        System.out.println("valor del contador en metodo saludar es " + contador);
        return "Hola que tal " + persona;
    }

    @WebMethod
    @Override
    public List<Curso> listar() {
        return Arrays.asList(new Curso("java"), new Curso("spring"), new Curso("jakarta ee"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito ... " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
