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
public class Requisicion {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleIntegerProperty cantidad;
    private final SimpleIntegerProperty status;
    private final SimpleStringProperty sucursal;
    private final SimpleIntegerProperty empleado;
    
    /**
     *
     * @param id
     * @param nombre
     * @param cantidad
     * @param status
     * @param sucursal
     * @param empleado
     */
    public Requisicion(Integer id, String nombre, Integer cantidad, Integer status, String sucursal,Integer empleado){
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.status = new SimpleIntegerProperty(status);
        this.sucursal = new SimpleStringProperty(sucursal);
        this.empleado = new SimpleIntegerProperty(empleado);
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
    
    public Integer getStatus() {
        return status.get();
    }
    
    public String getSucursal() {
        return sucursal.get();
    }
    public Integer getEmpleado() {
        return empleado.get();
    } 
}
