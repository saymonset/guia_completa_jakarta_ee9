package org.aguzman.webapp.jaxws.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/*Esto es solo para respuestas xm en el restFull para que tome la raiz del xml en este entity, para el json
no es necesario*/
@XmlRootElement
@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    //@XmlTransient
//    @JsonbTransient
    /*Con la libreria de maven resteasy-jackson2-provider, podemos
    usar @JsonIgnore para ignorar el entity  que no sea mapeado en el json*/
//    @JsonIgnore
    //When is one.. for default is eager
    //put in lazy with this instruction
    @ManyToOne(fetch = FetchType.LAZY)
    //En la columna de la tabla curso, por defecto es instructor_id
    //Si queremos que cambiar el nombre, usamos joinColumn, repasar l
    /*seccion jpa*/

    private Instructor instructor;

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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
