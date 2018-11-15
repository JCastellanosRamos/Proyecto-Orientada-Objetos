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
public class CHECAR_PController implements Initializable {

ObservableList<String> catList = FXCollections
               .observableArrayList("Id_proveedor","Departamento");

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
    private TableView<Producto> tableID;
    @FXML
    private TableColumn<Producto, Integer> id;
    @FXML
    private TableColumn<Producto, String> nombre;
    @FXML
    private TableColumn<Producto, Integer> cantidad;
    @FXML
    private TableColumn<Producto, String> proveedor;
    @FXML
    private TableColumn<Producto, String> departamento;
    @FXML
    private ComboBox c1;
    //
    private ObservableList<Producto>data;
    
    @FXML
    private void handle(ActionEvent event) throws IOException{
        
        if((Button)event.getSource()==btn1){
         Conectar con = new Conectar();
            Connection reg = con.conexion();
            Statement ps;
            ResultSet rs;
        String sql = "SELECT p.Id_producto, p.Nombre, p.Cantidad, n.Nombre, d.Departamento FROM Productos p, Proveedores n, Departamentos d WHERE p.Id_proveedor = n.Id_proveedor AND p.Id_Departamento = d.Id_Departamento;";
        try {
            
            data = FXCollections.observableArrayList();
            ps = reg.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                data.add(new Producto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
                  }       
        } catch (SQLException ex) {
            Logger.getLogger(BUSQUEDA_EController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        cantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        proveedor.setCellValueFactory(new PropertyValueFactory<>("Proveedor"));
        departamento.setCellValueFactory(new PropertyValueFactory<>("Departamento"));
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
            if(cat.equals("Id_proveedor")){cat="n.Id_proveedor";}
            if(cat.equals("Departamento")){cat="d.Departamento";}
            cat1 = txt.getText();
            //System.out.println(cat1);
            //System.out.println(cat);
            
            String sql ="SELECT p.Id_producto, p.Nombre, p.Cantidad, n.Nombre, d.Departamento FROM Productos p, Proveedores n, Departamentos d WHERE p.Id_proveedor = n.Id_proveedor AND p.Id_Departamento = d.Id_Departamento AND "+cat+"="+"'"+cat1+"'";
            //System.out.println(sql);
            try {
            
            data = FXCollections.observableArrayList();
            ps = reg.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                data.add(new Producto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
                  }       
        } catch (SQLException ex) {
            Logger.getLogger(BUSQUEDA_EController.class.getName()).log(Level.SEVERE, null, ex);
        }
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        cantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        proveedor.setCellValueFactory(new PropertyValueFactory<>("Proveedor"));
        departamento.setCellValueFactory(new PropertyValueFactory<>("Departamento"));
        tableID.setItems(null);
        tableID.setItems(data); 
         c1.setValue("Categorias");
         txt.setText("");
        }
        }
        else{
            		 ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("MENU_PROVEEDOR.fxml"));
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
