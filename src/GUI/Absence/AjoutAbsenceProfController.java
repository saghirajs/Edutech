/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Absence;


import Entities.Utilisateur.Enseignant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author MehdiS
 */
public class AjoutAbsenceProfController implements Initializable {
    @FXML
    private Button GestionAbsence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GestionAbsence(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionAbsence.fxml"));
            try {
                Parent root = loader.load();
                AddAbsence1Controller apc = loader.getController();
                Enseignant e = new Enseignant(1,"fathia","fathi","dafzdfa","afafa","126211",1451615,"2561566","1532",1253);
                apc.getInstance(e);
                GestionAbsence.getScene().setRoot(root);
            }catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
