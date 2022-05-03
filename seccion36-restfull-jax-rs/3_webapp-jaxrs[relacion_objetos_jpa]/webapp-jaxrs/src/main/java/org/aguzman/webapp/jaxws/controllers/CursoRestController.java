package org.aguzman.webapp.jaxws.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aguzman.webapp.jaxws.models.Curso;
import org.aguzman.webapp.jaxws.services.CursoService;

import java.util.List;
import java.util.Optional;

/*No necesitamos named porque este controler no va a ser
 usado por un jsp o jsf
en su vista.Por ninguna parte hacemos referencia al nombre del controlador*/
/*De partida que sea un componente que maneje de contexto cdi como un request*/
@RequestScoped
/*Con @path indicamos que es un controlador rest*/
/*Esta es una url de primer nivel*/
@Path("/cursos")
/*Este Produce es diferente a Produce CDI, y es el que da resultado json o xml*/
/*Si es xml, debe anotar el entity con @XmlRootElement*/
/*@XmlRootElement, Esto es solo para respuestas xm en el restFull para que tome la raiz del xml en este entity, para el json
no es necesario*/

@Produces(MediaType.APPLICATION_JSON)
public class CursoRestController {

    @Inject
    private CursoService service;


    /*Esto devuelve una lista de curso en jsno y esta correcto*/
    @GET
    public List<Curso> listar() {

        return service.listar();
    }

/*
  Otra forma de hacer lo de arriba
  @GET
    public Response listar() {

        return Response.ok(service.listar()).build();
    }*/


    @GET
    /*El id es generico, se conoce ccomo wildcard , una expresion regular. ES variable y se coloca como {id}*/
    @Path("/{id}")
    /*Con esta instruccion los injectamos porque viene este valor en la url
    @PathParam("id")*/
    /*Inyectamos el valor @Path("/{id}") con @PathParam("id"), se coloca el mismo nombre.. ejemplo id*/
    public Response porId(@PathParam("id") Long id) {
        /*Como devuelve un optional, lo analizamos antes
                que es lo aconsejable y si esta presente los devolvemos*/
        Optional<Curso> cursoOptional = service.porId(id);
        if (cursoOptional.isPresent()) {
            return Response.ok(cursoOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso) {
        try {
            Curso nuevoCurso = service.guardar(curso);
            return Response.ok(nuevoCurso).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, Curso curso) {
        Optional<Curso> cursoOptional = service.porId(id);
        if (cursoOptional.isPresent()) {

            Curso nuevoCurso = cursoOptional.get();
            nuevoCurso.setNombre(curso.getNombre());
            nuevoCurso.setDescripcion(curso.getDescripcion());
            nuevoCurso.setDuracion(curso.getDuracion());
            nuevoCurso.setInstructor(curso.getInstructor());

            try {
                service.guardar(nuevoCurso);
                return Response.ok(nuevoCurso).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        Optional<Curso> cursoOptional = service.porId(id);
        if(cursoOptional.isPresent()){
            try {
                service.eliminar(cursoOptional.get().getId());
                return Response.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
