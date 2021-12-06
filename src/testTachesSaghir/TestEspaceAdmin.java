/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testTachesSaghir;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.Note.TestLogUp;

/**
 *
 * @author saghir
 */
public class TestEspaceAdmin extends Application{
    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Education/admineMatiere.fxml"));
            Scene scene = new Scene(root);
            //primaryStage.getIcons().add(new Image("..\\css\\logo.jpg"));
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(TestLogUp.class.getName()).log(Level.SEVERE, null, ex);
        }

        //dashboard , specialite , matiere,note , relevee des notes
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}
