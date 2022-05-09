package org.aguzman.webapp.jaxws.repositories;

import org.aguzman.webapp.jaxws.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso guardar(Curso curso);
}
