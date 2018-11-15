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
public class Empleado {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty paterno;
    private final SimpleStringProperty materno;
    private final SimpleStringProperty sexo;
    private final SimpleStringProperty edad;
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty password;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty sucursal;
    
    /**
     *
     * @param id
     * @param nombre
     * @param paterno
     * @param materno
     * @param sexo
     * @param edad
     * @param usuario
     * @param password
     * @param tipo
     * @param sucursal
     */
    public Empleado(Integer id, String nombre, String paterno, String materno, String sexo, String edad, String usuario, String password, String tipo, String sucursal){
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.paterno = new SimpleStringProperty(paterno);
        this.materno = new SimpleStringProperty(materno);
        this.sexo = new SimpleStringProperty(sexo);
        this.edad = new SimpleStringProperty(edad);
        this.usuario = new SimpleStringProperty(usuario);
        this.password = new SimpleStringProperty(password);
        this.tipo = new SimpleStringProperty(tipo);
        this.sucursal = new SimpleStringProperty(sucursal);
    }

    public Integer getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getPaterno() {
        return paterno.get();
    }

    public String getMaterno() {
        return materno.get();
    }

    public String getSexo() {
        return sexo.get();
    }

    public String getEdad() {
        return edad.get();
    }

    public String getUsuario() {
        return usuario.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getTipo() {
        return tipo.get();
    }

    public String getSucursal() {
        return sucursal.get();
    }

}