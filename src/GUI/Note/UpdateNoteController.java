/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;


import Entities.Education.Note;
import Utils.DataBase;
import Utils.DataBasee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Float.parseFloat;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class UpdateNoteController implements Initializable {
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private Text etudText;

    @FXML
    private JFXTextField ccText;

    @FXML
    private JFXTextField dsText;

    @FXML
    private JFXTextField exText;

    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;
private final Connection con;
    private PreparedStatement ste;
    public UpdateNoteController() {
        DataBase mc=DataBase.getInstance();
	con=mc.getConnection();
	    }
    /**
     * Initializes the controller class.
     */
    int idnt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void inflateUIII(Note n) {
         idnt=n.getId();
         etudText.setText(n.getNomEtud());
         ccText.setText(n.getNoteCc().toString());
         dsText.setText(n.getNoteDs().toString());
         exText.setText(n.getNoteEx().toString());
         
       
        
    }

    @FXML
    private void addBook(ActionEvent event) throws SQLException {
        float cc = parseFloat(ccText.getText());
        float ds = parseFloat(dsText.getText());
        float ex = parseFloat(exText.getText());
        float a=(float) 0.2;
        float b=(float) 0.6;
        float moyen = (cc * a) + (ds * a) + (ex * b);
        String requeteUpdate =
                    "UPDATE note SET noteDs="+ds+",noteEx="+ex+",noteCc="+cc+",moy="+moyen+"  where id="+idnt+"";
        

            ste =con.prepareStatement(requeteUpdate);
            ste.executeUpdate();
            System.out.println("matiere modifier");
        
    }

    @FXML
    private void cancel(ActionEvent event) {
         Stage stage = (Stage) etudText.getScene().getWindow();
        stage.close();
    }
    
}
