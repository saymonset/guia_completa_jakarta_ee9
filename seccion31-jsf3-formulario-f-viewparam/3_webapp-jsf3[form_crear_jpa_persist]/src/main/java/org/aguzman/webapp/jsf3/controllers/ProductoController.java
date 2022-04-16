package org.aguzman.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.aguzman.webapp.jsf3.entities.Producto;
import org.aguzman.webapp.jsf3.services.ProductoService;

import java.util.Arrays;
import java.util.List;

@Model
public class ProductoController {

    private Producto producto;

    @Inject
    private ProductoService service;

    @Produces
    @Model
    public String titulo() {
        return "Hola mundo JavaServer Faces 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll() {
//        return Arrays.asList(new Producto("peras"), new Producto("manzanas"), new Producto("mandarinas"));
        return service.listar();
    }

    @Produces
    @Model
    public Producto producto() {
        this.producto = new Producto();
        return producto;
    }

    public String guardar() {
        System.out.println(producto);
        service.guardar(producto);
        return "index.xhtml?faces-redirect=true";
    }
}
