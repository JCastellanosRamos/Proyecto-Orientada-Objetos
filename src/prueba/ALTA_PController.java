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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author josesito
 */
public class ALTA_PController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField txt1;
    @FXML
    TextField txt2;
    @FXML
    TextField txt3;
    @FXML
    Button b1;
    @FXML
    Button b2;
    
    @FXML
    public void handle(ActionEvent event) throws IOException{
        if((Button)event.getSource()==b1){ 
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String nombre,usuario,contra;
            String sql;
            int t = 0,s = 0;
            nombre = txt1.getText();
            usuario = txt2.getText();
            contra = txt3.getText();
            
            if(nombre.equals("") || usuario.equals("") || contra.equals("")){
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
		 try {
            sql ="INSERT INTO `Proveedores`(`Nombre`,`Usuario`, `Password`) VALUES (?,?,?)";
                ps=reg.prepareStatement(sql);
                ps.setString(1,nombre);
                ps.setString(2,usuario);
                ps.setString(3,contra);
                int opc = ps.executeUpdate();
                if (opc>0){
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("AGREGADO_EXITO.fxml"));
                    AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
                    Stage ventana = new Stage();
                    Window stagePrincipal = null;
                    ventana.initOwner(stagePrincipal);
                    Scene scene = new Scene(ventanaPrincipal);
                    ventana.setScene(scene);            
                    ventana.show();
                }
        } catch (SQLException ex) {
            Logger.getLogger(ALTA_EMPLEADOSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
	}
        	else if((Button)event.getSource()==b2){
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
    }    
    
}
