package org.aguzman.webapp.jaxws.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.aguzman.webapp.jaxws.models.Curso;
import org.aguzman.webapp.jaxws.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
/*Aqui damos seguridad */
@DeclareRoles({"USER", "ADMIN"})
public class CursoServiceImpl implements CursoService {

    @Inject
    private CursoRepository repository;

    @Override
    /*Seguridad a los metodos*/
    @RolesAllowed({"ADMIN", "USER"})
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @RolesAllowed({"ADMIN"})
//    Guardar solo para admin
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }

    @RolesAllowed({"ADMIN", "USER"})
    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
