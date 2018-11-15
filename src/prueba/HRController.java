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
public class HRController implements Initializable {


    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txt;
    @FXML
    private Button btn;
    @FXML
    private Button btn3;
    
     @FXML
    private void handle(ActionEvent event) throws IOException{
        if((Button)event.getSource()==btn){
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
                try {
                    Conectar con = new Conectar();
                    Connection reg = con.conexion();
                    Statement ps;
                    PreparedStatement ps1;
                    ResultSet rs;
                    String nombre = null;
                    int cantidad = 0, status = 0,cantidad1 = 0,total,i = 0;
                            String id,sql;
                            id=txt.getText();
                            sql = "SELECT Id_requisicion FROM `Requisiciones` WHERE Id_requisicion = '"+id+"'";
                            ps = reg.createStatement();
                            rs = ps.executeQuery(sql);
                            while(rs.next()) {
                                i = rs.getInt(1);
                            }
                            if(i==0){
                                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("OOPS.fxml"));
                                AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
                                Stage ventana = new Stage();
                                Window stagePrincipal = null;
                                ventana.initOwner(stagePrincipal);
                                Scene scene = new Scene(ventanaPrincipal);
                                ventana.setScene(scene);            
                                ventana.show();
                            }
                            else{
                            sql = "SELECT p.Nombre, p.Cantidad, r.Status, r.Cantidad , p.Id_producto From Requisiciones r, Productos p WHERE r.Id_producto = p.Id_producto AND r.Id_requisicion = '"+id+"'";
                            ps = reg.createStatement();
                            rs = ps.executeQuery(sql);
                            while(rs.next()) {
                                nombre = rs.getString(1);
                                cantidad = rs.getInt(2);
                                status = rs.getInt(3);
                                cantidad1 = rs.getInt(4);
                                i = rs.getInt(5);
                            }
                            if(status==1){
                                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("RH.fxml"));
                                AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
                                Stage ventana = new Stage();
                                Window stagePrincipal = null;
                                ventana.initOwner(stagePrincipal);
                                Scene scene = new Scene(ventanaPrincipal);
                                ventana.setScene(scene);            
                                ventana.show();
                            }
                            else if(cantidad == 0 || cantidad1 > cantidad){
                                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("STOCK.fxml"));
                                AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
                                Stage ventana = new Stage();
                                Window stagePrincipal = null;
                                ventana.initOwner(stagePrincipal);
                                Scene scene = new Scene(ventanaPrincipal);
                                ventana.setScene(scene);            
                                ventana.show();
                            }
                            else if(status==0 && !"".equals(nombre)){
                                total= cantidad - cantidad1;
                                sql = "UPDATE `Productos` SET`Cantidad`= '"+total+"' WHERE Id_producto = '"+i+"'"; 
                                ps1 = reg.prepareStatement(sql);
                                int x = ps1.executeUpdate();
                                sql = "UPDATE `Requisiciones` SET`Status`= '1' WHERE Id_requisicion = '"+id+"'"; 
                                ps1 = reg.prepareStatement(sql);
                                int x1 = ps1.executeUpdate();
                                if(x!=0 && x1!=0){
                                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("M_EXITO.fxml"));
                                AnchorPane ventanaPrincipal;
                                ventanaPrincipal = (AnchorPane) loader.load();
                                Stage ventana = new Stage();
                                Window stagePrincipal = null;
                                ventana.initOwner(stagePrincipal);
                                Scene scene = new Scene(ventanaPrincipal);
                                ventana.setScene(scene);            
                                ventana.show();
                                }
                            }
                            }
                } catch (SQLException ex) {
                    Logger.getLogger(RESPONDER_RController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if((Button)event.getSource()==btn3){
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
