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
public class Proveedor {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty password;
    
    /**
     *
     * @param id
     * @param nombre
     * @param usuario
     * @param password
     */
    public Proveedor(Integer id, String nombre, String usuario, String password){
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.usuario = new SimpleStringProperty(usuario);
        this.password = new SimpleStringProperty(password);
    }

    public Integer getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }
    public String getUsuario() {
        return usuario.get();
    }

    public String getPassword() {
        return password.get();
    }
}
