package org.aguzman.hibernateapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Long total;

    @ManyToOne
    /*JoinColumn es para asignar una foreign key que ya existe*/
    @JoinColumn(name="id_cliente")
    //Si no colocamos  un nombre en @JoinColumn(name="id_cliente"), toma el nombre
    //del atributo, en este caso cliente y le suma el _id, y queda cliente_id
    private Cliente cliente;

    public Factura() {
    }

    public Factura(String descripcion, Long total) {
        this.descripcion = descripcion;
        this.total = total;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
