/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;

//import Utils.AlertMaker;
import Entities.Utilisateur.Utilisateur;
import Utils.DataBase;
import Utils.DataBasee;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.lang3.StringUtils;


public class LoginController implements Initializable {

    //private final static Logger LOGGER = LogManager.getLogger(LoginController.class.getName());

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    
    
    private final Connection con;
	    private PreparedStatement ste;

	    public LoginController() {
	        DataBase mc=DataBase.getInstance();
	        con=mc.getConnection();
	    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    @FXML
    private void toSignUp(ActionEvent event){
        try {
            ((Stage) username.getScene().getWindow()).close();
            Parent parent = FXMLLoader.load(getClass().getResource("logUp.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("logUp");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {

         String uname = StringUtils.trimToEmpty(username.getText());
         String pword = StringUtils.trimToEmpty(password.getText());
         if(uname.isEmpty()){
             Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Form Error");
        alert.setContentText("Email is Empty");
        alert.showAndWait();
         }else if(pword.isEmpty()){
             Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Form Error");
        alert.setContentText("Password is Empty");
        alert.showAndWait();
         }else{
        System.out.println(uname+pword);
        try {
            String requete="select id,username,username_canonical,enabled,salt,password,confirmation_token,roles,cin,numtel,datenaissance,adresse,profile,nom,prenom,email,email_canonical from fos_user where username=\""+uname+"\"" ;
            ResultSet rs;
            
            Statement st =con.createStatement();
            rs= st.executeQuery(requete);
             if(rs.next()){
                 int id = rs.getInt("id");
                 String username = rs.getString("username");
                String username_canonical = rs.getString("username_canonical");
                int enabled = rs.getInt("enabled");
                String salt = rs.getString("salt");
                String password = rs.getString("password");
                String confirmation_token = rs.getString("confirmation_token");
                String roles = rs.getString("roles");
                int cin = rs.getInt("cin");   
                int numtel = rs.getInt("numtel");  
                Date datenaissance = rs.getDate("datenaissance");  
                String adresse = rs.getString("adresse");  
                String profile = rs.getString("profile");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String email_canonical = rs.getString("email_canonical");
                Utilisateur u =new Utilisateur(id,username,username_canonical,email,email_canonical,enabled,salt,password,confirmation_token,roles,cin,numtel,datenaissance,adresse,profile,nom,prenom);
                System.out.println(u);
                loadMain();
             }
             else{
                 System.out.println("Login Failed");
             }
             //System.out.println(id+classe+nomU+pnomU+email+cin+Ppwd+pwd+role);
             } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         }
        }

//        if (true) {
//            closeStage();
//            loadMain();
//            LOGGER.log(Level.INFO, "User successfully logged in {}", uname);
//        }
//        else {
//            username.getStyleClass().add("wrong-credentials");
//            password.getStyleClass().add("wrong-credentials");
//        }
    //}

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        System.exit(0);
    }

    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

    void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Library Assistant");
            stage.setScene(new Scene(parent));
            stage.show();
            
        }
        catch (IOException ex) {
          //  LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

}
