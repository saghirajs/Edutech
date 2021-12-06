/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ousse
 */

    
public class ToolbarController implements Initializable {
    @FXML
    private VBox vboxid;

    /**
     * Initializes the controller class.
     */
    int a;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadAddMember(ActionEvent event) {
        try {
            ((Stage) vboxid.getScene().getWindow()).close();
            Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("login");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadAddBook(ActionEvent event) {
    }

    @FXML
    private void loadMemberTable(ActionEvent event) {
        try {
            ((Stage) vboxid.getScene().getWindow()).close();
            Parent parent = FXMLLoader.load(getClass().getResource("Matiere.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("login");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadBookTable(ActionEvent event) {
        try {
            ((Stage) vboxid.getScene().getWindow()).close();
            Parent parent = FXMLLoader.load(getClass().getResource("listClass.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("login");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadIssuedBookList(ActionEvent event) {
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("ListToPDF.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("login");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadSettings(ActionEvent event) {
    }
    
}
