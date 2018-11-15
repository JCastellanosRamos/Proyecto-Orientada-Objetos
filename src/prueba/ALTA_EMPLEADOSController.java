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
public class ALTA_EMPLEADOSController implements Initializable {
    
    ObservableList<String> sexoList = FXCollections
               .observableArrayList("Masculino","Femenino");
    ObservableList<String> tipoList = FXCollections
               .observableArrayList("Gerente","Trabajador Almacen","Trabajador Sucursal");
    ObservableList<String> sucursalList = FXCollections
               .observableArrayList("Almacen","Norte","Sur","Centro");

    /**
     * Initializes the controller class.
     */
    
   @FXML
   private Button b1; 
  
    @FXML
   private Button b2; 
  
   @FXML
   private ComboBox c1;
   @FXML
   private ComboBox c2;
   @FXML
   private ComboBox c3;
   
   @FXML
   private TextField txt1;
   
   @FXML
   private TextField txt2;
   
   @FXML
   private TextField txt3;
   
   @FXML
   private TextField txt4;
   
   @FXML
   private TextField txt5;
   
   @FXML
   private TextField txt6;
 
   
@FXML
public void handle(ActionEvent event) throws IOException {
	//si se presiona el boton nuevo juego @Cindy
	if((Button)event.getSource()==b1){ 
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String nombre,ap,am,edad,sexo,usuario,contra,tipo,suc;
            String sql;
            int t = 0,s = 0;
            nombre = txt1.getText();
            ap = txt2.getText();
            am = txt3.getText();
            edad = txt4.getText();
            sexo = (String) c1.getValue();
            usuario = txt5.getText();
            contra = txt6.getText();
            tipo =(String) c2.getValue();
            if(tipo.equals("Gerente")){t=1;}
            if(tipo.equals("Gerente Sucursal")){t=2;}
            if(tipo.equals("Trabajador Almacen")){t=3;}
            if(tipo.equals("Trabajador Sucursal")){t=4;}
            suc = (String) c3.getValue();
            if(suc.equals("Almacen")){s=1;}
            if(suc.equals("Norte")){s=2;}
            if(suc.equals("Sur")){s=3;}
            if(suc.equals("Centro")){s=4;}
            
            if(contra.equals("") || nombre.equals("") || ap.equals("") || am.equals("") || edad.equals("") || usuario.equals("") || contra.equals("")){
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
            sql ="INSERT INTO `Empleados`(`Nombre`, `Ap_paterno`, `Ap_materno`, `Sexo`, `Edad`, `Usuario`, `Contrasenia`, `Id_tipo_empleado`, `Id_sucursal`) VALUES (?,?,?,?,?,?,?,?,?)";
                ps=reg.prepareStatement(sql);
                ps.setString(1,nombre);
                ps.setString(2,ap);
                ps.setString(3,am);
                ps.setString(4,sexo);
                ps.setString(5,edad);
                ps.setString(6,usuario);
                ps.setString(7,contra);
                ps.setInt(8,t);
                ps.setInt(9,s);
                int opc = ps.executeUpdate();
                if (opc>0){
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    txt5.setText("");
                    txt6.setText("");
                    c1.setValue("Masculino");
                    c2.setValue("Trabajador Almacen");
                    c3.setValue("Almacen");
                    t=0;
                    s=0;
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
       c1.setValue("Masculino");
       c2.setValue("Trabajador Almacen");
       c3.setValue("Almacen");
       c1.setItems(sexoList);
       c2.setItems(tipoList);
       c3.setItems(sucursalList);
    }    
    
}
