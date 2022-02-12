package org.aguzman.hibernateapp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*personaizamos l nombre de la tabla intermedia*/
    /*Declaramos la primera clave foranea que es la duena de ;a relacion
    @JoinColumn(name="alumno_id"*/
    /*Declaramos la foreignkey de la relacion inversa inverseJoinColumns = @JoinColumn(name = "curso_id"*/
    @JoinTable(name = "tbl_alumnos_cursos", joinColumns = @JoinColumn(name="alumno_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id"),
    /*Este es el constraint y su par debe ser unico*/
    uniqueConstraints = @UniqueConstraint(columnNames = {"alumno_id", "curso_id"}))
    private List<Curso> cursos;

    public Alumno() {
        this.cursos = new ArrayList<>();
    }

    public Alumno(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
