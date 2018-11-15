/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author josesito
 */
public class Producto {
     private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleIntegerProperty cantidad;
    private final SimpleStringProperty proveedor;
    private final SimpleStringProperty departamento;
    
    /**
     *
     * @param id
     * @param nombre
     * @param cantidad
     * @param proveedor
     * @param departamento
     */
    public Producto(Integer id, String nombre, Integer cantidad, String proveedor, String departamento){
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.proveedor = new SimpleStringProperty(proveedor);
        this.departamento = new SimpleStringProperty(departamento);
    }

    public Integer getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }
    public Integer getCantidad() {
        return cantidad.get();
    }
    
    public String getProveedor() {
        return proveedor.get();
    }
    
    public String getDepartamento() {
        return departamento.get();
    }
    
}
