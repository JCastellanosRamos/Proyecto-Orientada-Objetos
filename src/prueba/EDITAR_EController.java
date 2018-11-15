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
public class EDITAR_EController implements Initializable {

    ObservableList<String> catList = FXCollections
               .observableArrayList("Nombre","Apellido Paterno","Apellido Materno","Sexo","Edad","Usuario","Tipo de empleado","Sucursal");
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
    private TextField txt4;
    @FXML
    private TextField txt5;
    @FXML
    private TextField txt6;
    @FXML
    private TextField txt7;
    @FXML
    private TextField txt8;
    @FXML
    private TextField txt9;
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
         /*if((Button)event.getSource()==btn1){
             
         }*/
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
            if(cat.equals("Nombre")){cat="e.Nombre";}
            if(cat.equals("Apellido Paterno")){cat="e.Ap_paterno";}
            if(cat.equals("Apellido Materno")){cat="e.Ap_materno";}
            if(cat.equals("Sexo")){cat="e.Sexo";}
            if(cat.equals("Edad")){cat="e.Edad";}
             if(cat.equals("Usuario")){cat="e.Usuario";}
            if(cat.equals("Tipo de empleado")){cat="t.Tipo";}
            if(cat.equals("Sucursal")){cat="s.Nombre";}
            cat1 = txt10.getText();
            //System.out.println(cat1);
            //System.out.println(cat);
            
            String sql = "SELECT e.Id_empleado,e.Nombre, e.Ap_paterno, e.Ap_materno, e.Sexo, e.Edad,e.Usuario,e.Contrasenia,t.Tipo, s.Nombre FROM Empleados e, Tipo_empleado t, Sucursales s WHERE e.Id_tipo_empleado = t.Id_tipo_empleado AND e.Id_sucursal = s.Id_sucursal AND "+cat+"="+"'"+cat1+"'";
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
                txt4.setText(rs.getString(5));
                txt5.setText(rs.getString(6));
                txt6.setText(rs.getString(7));
                txt7.setText(rs.getString(8));
                txt8.setText(rs.getString(9));
                txt9.setText(rs.getString(10));
                  }       
        } catch (SQLException ex) {
            Logger.getLogger(BUSQUEDA_EController.class.getName()).log(Level.SEVERE, null, ex);
        }
         c1.setValue("Categorias");
         txt10.setText("");
        }
        }
         else if((Button)event.getSource()==btn1){
             String id,n,p,m,s,e,u,c,t,su;
            int i = 0,b = 0,d;
            id = l1.getText();
            n = txt1.getText();
            p = txt2.getText();
            m = txt3.getText();
            s = txt4.getText();
            e = txt5.getText();
            u = txt6.getText();
            c = txt7.getText();
            t = txt8.getText();
             if(id.equals("") || n.equals("") || p.equals("") || m.equals("") || s.equals("") || e.equals("") || u.equals("") || c.equals("") || t.equals("")){
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
                  d = Integer.parseInt(id);
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            PreparedStatement ps;
            ResultSet rs;
            if(t.equals("Gerente")){i=1;}
            if(t.equals("Gerente Sucursal")){i=2;}
            if(t.equals("Trabajador Almacen")){i=3;}
            if(t.equals("Trabajador Sucursal")){i=4;}
            su = txt9.getText();
            if(su.equals("Almacen")){b=1;}
            if(su.equals("Norte")){b=2;}
            if(su.equals("Sur")){b=3;}
            if(su.equals("Centro")){b=4;}
            String sql ="UPDATE `Empleados` SET `Nombre`= "+"'"+n+"',`Ap_paterno`= "+"'"+p+"',`Ap_materno`= "+"'"+m+"',`Sexo`= "+"'"+s+"',`Edad`= "+"'"+e+"',`Usuario`= "+"'"+u+"',`Contrasenia`= "+"'"+c+"',`Id_tipo_empleado`= "+"'"+i+"',`Id_sucursal`= "+"'"+b+"' WHERE Id_empleado = "+"'"+d+"'";
             try {
                 //System.out.println(sql);
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
            txt4.setText("");
            txt5.setText("");
            txt6.setText("");
            txt7.setText("");
            txt8.setText("");
            txt9.setText("");
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
               c1.setValue("Categorias");
       c1.setItems(catList);
    }    
    
}
