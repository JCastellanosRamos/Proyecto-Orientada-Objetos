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
public class HACER_RController implements Initializable {

    ObservableList<String> sucursalList = FXCollections
               .observableArrayList("Norte","Sur","Centro");

    /**
     * Initializes the controller class.
     */
    
   @FXML
   private Button b1; 
  
    @FXML
   private Button b2; 
 
   @FXML
   private ComboBox c3;
   
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
            int t = 0,s = 0;
            String id,cantidad,sucursal,empleado;
            id = txt1.getText();
            cantidad = txt2.getText();
            empleado = txt3.getText();
            sucursal = (String) c3.getValue();
            if(sucursal.equals("Norte")){s=2;}
            if(sucursal.equals("Sur")){s=3;}
            if(sucursal.equals("Centro")){s=4;}
            
            if(cantidad.equals("") || id.equals("") || empleado.equals("") || sucursal.equals("")){
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
            int i = Integer.parseInt(id);
            int q = Integer.parseInt(cantidad);
            int e = Integer.parseInt(empleado);
		 try {
            sql ="INSERT INTO `Requisiciones`(`Cantidad`, `Status`, `Id_producto`, `Id_sucursal`, `Id_empleado`) VALUES (?,?,?,?,?)";
                ps=reg.prepareStatement(sql);
                ps.setInt(1,q);
                ps.setInt(2,0);
                ps.setInt(3,i);
                ps.setInt(4,s);
                ps.setInt(5,e);
                int opc = ps.executeUpdate();
                if (opc>0){
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    c3.setValue("Norte");
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
            Logger.getLogger(HACER_RController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
	}
        
	else if((Button)event.getSource()==b2){
		 ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("MENU_TS.fxml"));
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
        c3.setValue("Norte");
       c3.setItems(sucursalList);
    }    
    
}
