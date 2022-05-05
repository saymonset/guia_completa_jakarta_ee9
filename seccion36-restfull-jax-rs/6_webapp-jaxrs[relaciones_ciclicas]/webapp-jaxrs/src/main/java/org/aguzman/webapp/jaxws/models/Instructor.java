package org.aguzman.webapp.jaxws.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructores")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*recursiva referencia error resolver. con @JsonIgnoreProperties({"instructor"}),
    no mostrara los instructor en el json curso. */
/*    Con lazy se maneja un proxy para que se pueda comunicar y otener los objetos de carga perezosa.
* Maneja ciertos atributos el proxy y queda como basura, cuado queda esa basura , marca un error.
* Esos atributos los ignoramos. handler, hibernateLazyInitializer*/

    /*Fix error bien extarno. un bug. Unas variables almacenadas en cache del proxy.
    * Estas variables handler y hibernateLazyInitializer */
    @JsonIgnoreProperties({"instructor", "handler", "hibernateLazyInitializer"})
    /*Pero como es una relacion bidireccional, se mapea con mappedBy al porpertie
    mapeado en la otra entity*/
    /*mappedBy es para establecer la relacion inversa con el atributo de la contraparte*/
    /*cascade es en caso que se borra un instructor, se borra los cursos*/
    /*en caso que se inserte un instrcutor con cursos, se insertan los cursos por cascade*/
    /*recursiva referencia error resolver*/
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    private String nombre;
    private String apellido;

    public Instructor() {
        this.cursos = new ArrayList<>();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
