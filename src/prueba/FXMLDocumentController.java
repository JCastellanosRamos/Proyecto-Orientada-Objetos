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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author josesito
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textfield;
     
    @FXML
    private PasswordField passwordfield;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        try {
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String usuario, password;
            String sql;
            //sql ="SELECT s.Nombre FROM Sucursales s LEFT JOIN Empleados e USING ( Id_sucursal )  WHERE s.Id_sucursal =1";
            sql = "SELECT t.Tipo FROM Tipo_empleado t LEFT JOIN Empleados e USING ( Id_tipo_empleado )  WHERE e.Usuario = ? AND e.Contrasenia =?";
            usuario = textfield.getText();
            password = passwordfield.getText();
            ps = reg.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()){
                String tipo = rs.getString("Tipo");
                System.out.println(tipo);
                if (tipo.equals("Gerente")){
                    System.out.println("Estas en menu gerente");
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
                if (tipo.equals("Gerente Sucursal")){
                    System.out.println("Estas en menu gerente sucursal");
                }
                if (tipo.equals("Trabajador Almacen")){
                    System.out.println("Estas en menu Trabajador Almacen");
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("MENU_TA.fxml"));
                    AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
                    Stage ventana = new Stage();
                    Window stagePrincipal = null;
                    ventana.initOwner(stagePrincipal);
                    Scene scene = new Scene(ventanaPrincipal);
                    ventana.setScene(scene);            
                    ventana.show();
                }
                if (tipo.equals("Trabajador Sucursal")){
                    System.out.println("Estas en menu Trabajador Sucursal");
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
                else{
                }
            }
            else{
                System.out.println("Error");
                
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("ERROR_LOGIN.fxml"));
            AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            textfield.setText("");
            passwordfield.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
@FXML
private void handleButtonAction1(ActionEvent event) throws IOException{
     ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("LOGIN_P.fxml"));
            AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
