package org.aguzman.hibernateapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(name="forma_pago")
    private String formaPago;

    @Embedded
    private Auditoria audit = new Auditoria();

    /*Un cliente, muchas direcciones*/
    /*Cuando una clase es principal (Cliente) Vincula una o muchas mas
        entidades secundarias como direcciones, por eso tenemos que colocar el
    tipo de cascada. Si es cascada all, significa que cada ves que se guarda o se crea un cliente
    automaticamente tambien va a crear a su dependientes y lo va a persistir*/
    /*Si eliminamos del cliente alguna direccion, esta direccion va a quedar
            con la foreignkey o clave foranea en null, no va a estar
            asignada, va a quedar huerfana, entonces todo estos registros
    que quedan huerfans de direcciones, se pueden eliminar,
    por eso asignamos  orphanRemoval = true para eliminar las direcciones huerfanas al eliminarlaa
    del cliente*/

   /* Automaticamente va a crear una tabla intermedia que se va a llamar
            clientes_direcciones, que guardac el id del cliente con
    el id de direccion, ambas foreignkey*/

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //La tabla intermedia cliente_direcciones no la crea por esto:
    //Si agregamos el nombre al foreignKey a traves de @JoinColumn(name = "id_cliente"),
    //No va a crear la tabla cliente_direcciones, como lo propone hibernate,
    //si no que va a crear direcciones y coloca la clve foranea id_cliente
    //
    @JoinColumn(name = "id_cliente")
    private List<Direccion> direcciones;

    public Cliente() {
        direcciones = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido) {
        /*con this, Llamamos al constructor vacio
        e inicializa direcciones*/
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        /*con this, Llamamos al constructor vacio
        e inicializa direcciones*/
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
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

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        LocalDateTime creado = this.audit != null? audit.getCreadoEn():null;
        LocalDateTime editado = this.audit != null? audit.getEditadoEn(): null;
        return "{" + "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago+ '\'' +
                ", creadoEn='" + creado + '\'' +
                ", editadoEn='" + editado + '\'' +
                ", direcciones='" + direcciones +  '\'' +
                '}';
    }
}
