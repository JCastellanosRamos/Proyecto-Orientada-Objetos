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
public class Sucursal {
     private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleIntegerProperty usuario;
    
    /**
     *
     * @param id
     * @param nombre
     * @param usuario
     */
    public Sucursal(Integer id, String nombre, Integer usuario){
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.usuario = new SimpleIntegerProperty(usuario);
    }

    public Integer getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }
    public Integer getUsuario() {
        return usuario.get();
    }
    
}
