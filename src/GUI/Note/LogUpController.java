/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;

import Utils.DataBasee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class LogUpController implements Initializable {
    @FXML
    private AnchorPane l;
    @FXML
    private JFXTextField lName;
    @FXML
    private JFXPasswordField cinF;
    @FXML
    private JFXButton register;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXTextField fName;
    @FXML
    private JFXTextField pwd1;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private JFXTextField mailF;
    @FXML
    private ChoiceBox<String> checkRole;
    @FXML
    private Button login_b;

    private final Connection con;
	    private PreparedStatement ste;

	    public LogUpController() {
	        DataBasee mc=DataBasee.getInstance();
	        con=mc.getConnection();
	    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkRole.getItems().add("Role");
        checkRole.getItems().add("Admin");
        checkRole.getItems().add("Professeur");
        checkRole.getSelectionModel().selectFirst();
        
        
        
        
        
        
        register.setOnAction(e->{
            try {
                String role;
                String fname=fName.getText();
                String lname=lName.getText();
                int cin = Integer.parseInt(cinF.getText());
                String mail=mailF.getText();
                String pwd=pwd1.getText();
                boolean y = StringUtils.isNumeric(cinF.getText());
                System.out.println("fname"+fname);
                
                if(checkRole.getValue()=="Admin" || checkRole.getValue()=="Professeur" && fname!=""&&lname !="" && mail!="" && pwd!=""&& pwd2.getText()!="" && y==true && pwd==pwd2.getText() ){
                     role="ROLE_ADMIN";
                     String req="insert into user (firstname,lastname,email,cin,plainPassword,password,string) values(\""+fname+"\",\""+lname+"\",\""+mail+"\","+cin+",\""+pwd+"\",\""+pwd+"\",\""+role+"\")";
                Statement st =con.createStatement();
                st.executeUpdate(req);
                System.out.println(role+fname+lname+cin);
                }else{
                    JOptionPane.showMessageDialog(null, "remplissez le formulaire correctement SVP");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(LogUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
		});
        
        cancel.setOnAction(e->{
            System.exit(0);
            });
        }
    @FXML
    private void toSignIn(javafx.event.ActionEvent event){
        try {
            ((Stage) login_b.getScene().getWindow()).close();
            Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("login");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
        
    } 

    
    

    

  

    

