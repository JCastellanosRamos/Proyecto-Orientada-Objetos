/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author josesito
 */
public class MENU_GERENTEController implements Initializable {
private boolean available ;
    /**
     * Initializes the controller class.
     */
@FXML
private Button ae;

@FXML
private Button be;

@FXML
private Button ee;

@FXML
private Button bue;

@FXML
private Button ap;

@FXML
private Button bp;

@FXML
private Button ep;

@FXML
private Button bup;

@FXML
private Button suc;

@FXML
private Button req;

@FXML
private Button req1;

@FXML
private Button cs;
// ...
@FXML
public void handle(ActionEvent event) throws IOException {
	//si se presiona el boton nuevo juego @Cindy
	if((Button)event.getSource()==ae){
		System.out.println("HOLA");
                 ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("ALTA_EMPLEADOS.fxml"));
            AnchorPane ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
	}//si se presiona el boton historial @Cindy
	else if((Button)event.getSource()==bue){
            System.out.println("HOLA");
		((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("BUSQUEDA_E.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
	}
        else if((Button)event.getSource()==be){
            ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("BAJA_E.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            
        }
        else if((Button)event.getSource()==ee){
            ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("EDITAR_E.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
        Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            
        }
        else if((Button)event.getSource()==ap){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("ALTA_P.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
            
        }  
        else if((Button)event.getSource()==bp){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("BAJA_P.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        } 
        else if((Button)event.getSource()==ep){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("EDITAR_P.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        }
        else if((Button)event.getSource()==bup){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("BUSQUEDA_P.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        }
        else if((Button)event.getSource()==suc){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("SUC.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        } 
        else if((Button)event.getSource()==req){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("REQ.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        }
        else if((Button)event.getSource()==req1){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("HR.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        }
        else if((Button)event.getSource()==cs){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(Prueba.class.getResource("LOGIN.fxml"));
            AnchorPane ventanaPrincipal;
            ventanaPrincipal = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            Window stagePrincipal = null;
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaPrincipal);
            ventana.setScene(scene);            
            ventana.show();
        }
	else{//si se presiona el boton salir @Cindy
		//Salir del juego @Cindy
		//System.exit(0);
	}
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
