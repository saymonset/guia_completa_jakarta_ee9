package org.aguzman.webapp.jaxws.services;

import jakarta.jws.WebService;
import org.aguzman.webapp.jaxws.models.Curso;

import java.util.List;

/*@WebService: Todos los metodos de esta interface, se van a exponer en sevicio web.
* @WebService: Parte de la especificacion JAX-WS
* */
@WebService
public interface ServicioWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear(Curso curso);
}
