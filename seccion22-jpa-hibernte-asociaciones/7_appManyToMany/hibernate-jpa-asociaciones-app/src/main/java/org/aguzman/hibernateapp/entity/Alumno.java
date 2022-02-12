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

    /*La clase alumno, va a ser la principal mientras que curso va
     a ser la secundaria o dependiente de alumno*/
    /*Como es la principal debemos manejar el cascade*/
    /*Si ingresamos un alumno con sus cursos, va a ingresar todo en cscada*/
    /*No colocamos cascade en all, porque si colocamos all, va  a incluir el remove*/

    /*No colocamos cascade.all , porque tendria  a remove, y si eliminamos un alucmno, va aeliminar
    sus cursos tambien y va  agenerar un error po constraint a l tratar de eliminar cursos
    que lo tienen otros alumnos*/
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Curso> cursos;

    public Alumno() {
        this.cursos = new ArrayList<>();
    }

    public Alumno(String nombre, String apellido) {
        //Inicializa el contructor default y este a su ves inicializa curso
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
