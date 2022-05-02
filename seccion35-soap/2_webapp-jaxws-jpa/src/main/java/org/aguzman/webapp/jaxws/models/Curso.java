package org.aguzman.webapp.jaxws.models;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

  /*  Hay wue tener mucho cuidado con las relaciones de ambos sentidos.
    Porque pueden ser ciclicas en los webservices xml o json servicios rest
     Cuando trabajos con servicios web ya sea con soap, scon JAXWS o con
    servicios rest web JAXRS, hay que evitar las relaciones en ambos sentidos
    en los objetos que estemos devolviendo en los servicios web. porque?
    Porque se genera el xml o json de forma automatica y cuando se genera mediante
    los metodos get , entonces se van a venir llamando recursivamente, ciclica,
    infinita, se genera un xml o json ciclico que no termina hasta que finalmente
    lanza un error*/


    //@XmlTransient
    private String instructor;

    private Double duracion;

    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
