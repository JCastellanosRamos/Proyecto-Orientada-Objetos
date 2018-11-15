/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author josesito
 */
public class BUSQUEDA_EController implements Initializable {
    
    ObservableList<String> catList = FXCollections
               .observableArrayList("Nombre","Apellido Paterno","Apellido Materno","Sexo","Edad","Usuario","Tipo de empleado","Sucursal");

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private TextField txt;
    @FXML
    private TableView<Empleado> tableID;
    @FXML
    private TableColumn<Empleado, Integer> id;
    @FXML
    private TableColumn<Empleado, String> nombre;
    @FXML
    private TableColumn<Empleado, String> paterno;
    @FXML
    private TableColumn<Empleado, String> materno;
    @FXML
    private TableColumn<Empleado, String> sexo;
    @FXML
    private TableColumn<Empleado, String> edad;
    @FXML
    private TableColumn<Empleado, String> usuario;
    @FXML
    private TableColumn<Empleado, String> password;
    @FXML
    private TableColumn<Empleado, String> tipo;
    @FXML
    private TableColumn<Empleado, String> sucursal;
    @FXML
    private ComboBox c1;
    //
    private ObservableList<Empleado>data;
    
    @FXML
    private void handle(ActionEvent event) throws IOException{
        
        if((Button)event.getSource()==btn1){
         Conectar con = new Conectar();
            Connection reg = con.conexion();
            Statement ps;
            ResultSet rs;
        String sql = "SELECT e.Id_empleado,e.Nombre, e.Ap_paterno, e.Ap_materno, e.Sexo, e.Edad,e.Usuario,e.Contrasenia,t.Tipo, s.Nombre FROM Empleados e, Tipo_empleado t, Sucursales s WHERE e.Id_tipo_empleado = t.Id_tipo_empleado AND e.Id_sucursal = s.Id_sucursal;";
        try {
            
            data = FXCollections.observableArrayList();
            ps = reg.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                data.add(new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
                  }       
        } catch (SQLException ex) {
            Logger.getLogger(BUSQUEDA_EController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        paterno.setCellValueFactory(new PropertyValueFactory<>("Paterno"));
        materno.setCellValueFactory(new PropertyValueFactory<>("Materno"));
        sexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        edad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        sucursal.setCellValueFactory(new PropertyValueFactory<>("Sucursal"));
        tableID.setItems(null);
        tableID.setItems(data);
        
        }
        else if((Button)event.getSource()==btn2){
            String prueba = txt.getText();
            if(prueba.equals("")){
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("CAMPO_VACIO.fxml"));
            AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            }
            else{
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            Statement ps;
            ResultSet rs;
            String cat,cat1;
            
            cat = (String) c1.getValue();
            if(cat.equals("Nombre")){cat="e.Nombre";}
            if(cat.equals("Apellido Paterno")){cat="e.Ap_paterno";}
            if(cat.equals("Apellido Materno")){cat="e.Ap_materno";}
            if(cat.equals("Sexo")){cat="e.Sexo";}
            if(cat.equals("Edad")){cat="e.Edad";}
             if(cat.equals("Usuario")){cat="e.Usuario";}
            if(cat.equals("Tipo de empleado")){cat="t.Tipo";}
            if(cat.equals("Sucursal")){cat="s.Nombre";}
            cat1 = txt.getText();
            //System.out.println(cat1);
            //System.out.println(cat);
            
            String sql = "SELECT e.Id_empleado,e.Nombre, e.Ap_paterno, e.Ap_materno, e.Sexo, e.Edad,e.Usuario,e.Contrasenia,t.Tipo, s.Nombre FROM Empleados e, Tipo_empleado t, Sucursales s WHERE e.Id_tipo_empleado = t.Id_tipo_empleado AND e.Id_sucursal = s.Id_sucursal AND "+cat+"="+"'"+cat1+"'";
            //System.out.println(sql);
            try {
            
            data = FXCollections.observableArrayList();
            ps = reg.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                data.add(new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
                  }       
        } catch (SQLException ex) {
            Logger.getLogger(BUSQUEDA_EController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        paterno.setCellValueFactory(new PropertyValueFactory<>("Paterno"));
        materno.setCellValueFactory(new PropertyValueFactory<>("Materno"));
        sexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        edad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        sucursal.setCellValueFactory(new PropertyValueFactory<>("Sucursal"));
        tableID.setItems(null);
        tableID.setItems(data); 
         c1.setValue("Categorias");
         txt.setText("");
        }
        }
        else{
            		 ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("MENU_GERENTE.fxml"));
            AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       c1.setValue("Categorias");
       c1.setItems(catList);
    }    
}