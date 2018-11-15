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
public class SUBIR_PController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList<String> dList = FXCollections
               .observableArrayList("Casa","Oficina","Escuela");

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
   private TextField txt1;
   
   @FXML
   private TextField txt2;
   
   @FXML
   private TextField txt3;
 
   
@FXML
public void handle(ActionEvent event) throws IOException {
	//si se presiona el boton nuevo juego @Cindy
	if((Button)event.getSource()==b1){ 
            String nombre,cantidad,departamento,id;
            nombre = txt1.getText();
            cantidad = txt2.getText();
            id = txt3.getText();
            departamento = (String) c1.getValue();
            if(id.equals("") || nombre.equals("") || departamento.equals("") || cantidad.equals("")){
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
            PreparedStatement ps;
            ResultSet rs;
              String sql;
            int t = 0,s = 0,c,i;
            if(departamento.equals("Casa")){t=1;}
            if(departamento.equals("Oficina")){t=2;}
            if(departamento.equals("Escuela")){t=3;}
             c = Integer.parseInt(cantidad);
            i = Integer.parseInt(id);
		 try {
            sql ="INSERT INTO `Productos`(`Nombre`, `Cantidad`, `Id_proveedor`, `Id_departamento`) VALUES (?,?,?,?)";
                ps=reg.prepareStatement(sql);
                ps.setString(1,nombre);
                ps.setInt(2,c);
                ps.setInt(3,i);
                ps.setInt(4,t);
                int opc = ps.executeUpdate();
                if (opc>0){
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    c1.setValue("Casa");
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
            Logger.getLogger(SUBIR_PController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
	}
        
	else if((Button)event.getSource()==b2){
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
       c1.setValue("Casa");
       c1.setItems(dList);
    }    
    
}
