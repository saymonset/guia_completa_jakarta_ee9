package org.aguzman.webapp.jsf3.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.aguzman.webapp.jsf3.entities.Categoria;
import org.aguzman.webapp.jsf3.entities.Producto;
import org.aguzman.webapp.jsf3.repositories.CrudRepository;
import org.aguzman.webapp.jsf3.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
/*aqui declaramos roles en un arreglo de string, separados por coma y engre llaves*/
@DeclareRoles({"USER", "ADMIN"})
public class ProductoServiceImpl implements ProductoService {

    @Inject
    private ProductoRepository repository;

    @Inject
    private CrudRepository<Categoria> categoriaRepository;

    @Override
    /*aqui protegemos los metodos, por ejemplo, el listar le colocamos el role de publico*/
    @PermitAll
    public List<Producto> listar() {
        return repository.listar();
    }

    /*En el minuto 9.25, explica el archivo de wildfly add-user.bat*/
    /*Las diferentes opciones de a y b*/
    /*
    * a) Managment User (mgmt-users.properties) Es para administrar la consola de widfly
    * b)Application User (application-users.properties) que son los usuarios de laaplicacion
    * que aplica a @PermitAll, @DeclareRoles({"USER", "ADMIN"}) etc...
    * */
    /*Protegido por JAAS*/
    /*Por id puede ser para usuarios y admisnitradore su role*/
    @RolesAllowed({"USER", "ADMIN"})
    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    /*Guardar solo el role para admin*/
    @RolesAllowed({"ADMIN"})
    @Override
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
    /* puede ser para usuarios y admisnitradore su role*/
    @RolesAllowed({"USER", "ADMIN"})
    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }
}
