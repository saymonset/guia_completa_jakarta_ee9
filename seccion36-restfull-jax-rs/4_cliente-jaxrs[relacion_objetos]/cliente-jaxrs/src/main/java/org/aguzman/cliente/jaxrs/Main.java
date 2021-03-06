package org.aguzman.cliente.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aguzman.cliente.jaxrs.models.Curso;
import org.aguzman.cliente.jaxrs.models.Instructor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

       /* Aqui consumimos un servicio rest
        usando la especificacion jax-rs y la implementacion resteasy
        jakarta.ws.rs.client.Client:  Este codigo es transparente para cualquier implementacion*/
        Client client = ClientBuilder.newClient();
        /*Uri base vamos a tener*/
        WebTarget rootUri = client.target("http://localhost:8080/webapp-jaxrs/api").path("/cursos");

        System.out.println("==================== por id");
        /*La url mas el id que debemos buscar en el path*/
        Response response = rootUri.path("/2")
                .request(MediaType.APPLICATION_JSON).get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println(curso);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());

        System.out.println("==================== listando");
        listar(rootUri);

        System.out.println("==================== creando");
        Curso cursoNuevo = new Curso();
        cursoNuevo.setNombre("Spring Cloud");
        cursoNuevo.setDescripcion("spring cloud eureka");
        cursoNuevo.setDuracion(25D);
        Instructor instructor = new Instructor();
        instructor.setId(2L);
        instructor.setNombre("Pepe");
        instructor.setApellido("Doe");
        cursoNuevo.setInstructor(instructor);
/*
        Entity no es un objeto de jpa, es un objeto que vamos a guardar en el request y esta asociado a un tipo
                de dato. Viene de jakarta.ws.rs.client*/
  /*Este es el tipo de contenido que vamos a enviar en el request <Curso>*/
/*cursoNuevo es lo que enviamo en el cuerpo*/
/*Los entity de ws.rs pueden mandar token en accept*/
        Entity<Curso> entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        curso = rootUri.request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);

        System.out.println(curso);
        listar(rootUri);
        System.out.println("==================== editando");

        Curso cursoEditado = curso;
        cursoEditado.setNombre("microservicios con spring cloud eureka");
        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/"+curso.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader, Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("==================== eliminado");
        rootUri.path("/"+curso.getId()).request().delete();
        listar(rootUri);

    }

    private static void listar(WebTarget rootUri) {
        System.out.println("==================== lista actualizada");

        Response response;
        response = rootUri.request(MediaType.APPLICATION_JSON)
                .get();
       /* Las llaves porque estamos un tipo generico de tipo list*/
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);
    }
}
