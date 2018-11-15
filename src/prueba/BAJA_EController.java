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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author josesito
 */
public class BAJA_EController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList<String> catList = FXCollections
            .observableArrayList("Id_empleado", "Usuario");

    @FXML
    private ComboBox c1;
    @FXML
    private TextField txt;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;

    public void handle(ActionEvent event) throws IOException{
         String prueba = txt.getText();
         String prueba2 = (String) c1.getValue();
            if(prueba.equals("") && prueba2.equals("Id_empleado") || prueba2.equals("Usuario")){
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
        if ((Button) event.getSource() == btn1) {
            try {
                Conectar con = new Conectar();
                Connection reg = con.conexion();
                PreparedStatement ps;
                ResultSet rs;
                String sql;
                String cat, esp;
                int n;
                cat = (String) c1.getValue();
                esp = txt.getText();
                    System.out.println("Vamos");
                    sql = "DELETE FROM `Empleados` WHERE "+ cat +"="+" '"+esp+"'";
                    ps = reg.prepareStatement(sql);
                    int x = ps.executeUpdate();
                    if (x==0){
                     FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("OOPS.fxml"));
                       AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            c1.setValue("Usuario");
            txt.setText("");
                    }
                    else{
                    c1.setValue("Usuario");
                    txt.setText("");
                    }
                //}
            } catch (SQLException ex) {
                Logger.getLogger(BAJA_EController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        }
        if ((Button) event.getSource() == btn2) {
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
        c1.setValue("Usuario");
        c1.setItems(catList);
    }

}
