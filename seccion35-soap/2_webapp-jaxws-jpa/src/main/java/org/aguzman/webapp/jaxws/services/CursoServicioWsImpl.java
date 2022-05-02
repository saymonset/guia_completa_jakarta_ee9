package org.aguzman.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.aguzman.webapp.jaxws.models.Curso;
import org.aguzman.webapp.jaxws.repositories.CursoRepository;

import java.util.Arrays;
import java.util.List;

@Stateless
@WebService(endpointInterface = "org.aguzman.webapp.jaxws.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {

    @Inject
    private CursoRepository repository;

    @WebMethod
    @Override
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}
