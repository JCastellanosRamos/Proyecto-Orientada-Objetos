/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author josesito
 */
public class EDITAR_PController implements Initializable {
  ObservableList<String> catList = FXCollections
               .observableArrayList("Nombre","Usuario");
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt10;
    @FXML
    private Label l1;
    @FXML
    private ComboBox c1;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private void handle(ActionEvent event) throws IOException{
         if((Button)event.getSource()==btn2){
            String prueba = txt10.getText();
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
            String id="";
            int i;
            
            cat = (String) c1.getValue();
            if(cat.equals("Nombre")){cat="Nombre";}
            if(cat.equals("Usuario")){cat="Usuario";}
            cat1 = txt10.getText();
            //System.out.println(cat1);
            //System.out.println(cat);
            
            String sql = "SELECT * FROM Proveedores WHERE "+cat+"="+"'"+cat1+"'";
            //System.out.println(sql);
            try {
            ps = reg.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                i = rs.getInt(1);
                id = String.valueOf(i);
                id= Integer.toString(i);
                l1.setText(id);
                txt1.setText(rs.getString(2));
                txt2.setText(rs.getString(3));
                txt3.setText(rs.getString(4));
                  }       
        } catch (SQLException ex) {
            Logger.getLogger(BUSQUEDA_EController.class.getName()).log(Level.SEVERE, null, ex);
        }
         c1.setValue("Categorias");
         txt10.setText("");
        }
        }
         else if((Button)event.getSource()==btn1){
            String id,n,u,c;
            n = txt1.getText();
            u = txt2.getText();
            c = txt3.getText();
            if(n.equals("") || u.equals("") || c.equals("")){
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
            int i = 0,b = 0,d;
            id = l1.getText();
            d = Integer.parseInt(id);
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql ="UPDATE `Proveedores` SET `Nombre`= "+"'"+n+"' ,`Usuario`= "+"'"+u+"',`Password`= "+"'"+c+"'"+" WHERE Id_proveedor = "+"'"+d+"'";
             try {
                 System.out.println(sql);
                 ps = reg.prepareStatement(sql);
                 int x = ps.executeUpdate();
                 if(x!=0){
                     FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("M_EXITO.fxml"));
                       AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            l1.setText("");
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(EDITAR_EController.class.getName()).log(Level.SEVERE, null, ex);
             }
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
       c1.setValue("Categorias");
       c1.setItems(catList);
    }    
    
}
