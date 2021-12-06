/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Note;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ousse
 */
public class testSaghir extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../../GUI/Education/espaceEtudiant.fxml"));
            Scene scene = new Scene(root);
            primaryStage.getIcons().add(new Image("..\\..\\css\\logo.jpg"));
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
