package org.aguzman.apiservlet.webapp.headers.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.aguzman.apiservlet.webapp.headers.configs.CarroCompra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CarroCompra
public class Carro implements Serializable {
    private List<ItemCarro> items;

    git commit -am"seccion17->121 Ciclo de vida beans /* Estamos injectando un objeto logger en una clse de session, @carroCompra es de"
            objeto session e implementa serializable. El logger no es
            serializable, no se puede guardar en la session, no es compatible directamente
           entonces agregamos un moduificador de java llamado Transient, de esa forma  injectamos
    el logger pero no formara parte de la session pero si lopodemos usar para imprmir datos en el log*/
    /*Se uso Transiente para Logger log, porque la clase es serializable y es scopsession o si es conversationScope*/"
    @Inject
    private transient Logger log;

    @PostConstruct
    public void inicializar(){
        this.items = new ArrayList<>();
        log.info("inicializando el carro de compras!");
    }

    @PreDestroy
    public void destruir(){
        log.info("destruyendo el carro de compras!");
    }

    public void addItemCarro(ItemCarro itemCarro) {
        if (items.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        } else {
            this.items.add(itemCarro);
        }
    }
    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal() {
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }

    public void removeProductos(List<String> productoIds) {
        if (productoIds != null) {
            productoIds.forEach(this::removeProducto);
            // que es lo mismo a:
            // productoIds.forEach(productoId -> removeProducto(productoId));
        }
    }

    public void removeProducto(String productoId) {
        Optional<ItemCarro> producto = findProducto(productoId);
        producto.ifPresent(itemCarro -> items.remove(itemCarro));
    }

    public void updateCantidad(String productoId, int cantidad) {
        Optional<ItemCarro> producto = findProducto(productoId);
        producto.ifPresent(itemCarro -> itemCarro.setCantidad(cantidad));
    }

    private Optional<ItemCarro> findProducto(String productoId) {
        return  items.stream()
                .filter(itemCarro -> productoId.equals(Long.toString(itemCarro.getProducto().getId())))
                .findAny();
    }
}
