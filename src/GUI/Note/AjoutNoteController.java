/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;


import Entities.Education.Classe;
import Entities.Utilisateur.Utilisateur;
import Utils.DataBase;
import Utils.DataBasee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Float.parseFloat;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class AjoutNoteController implements Initializable {
    @FXML
    private StackPane rootPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private JFXTabPane mainTabPane1;
    @FXML
    private Tab renewTab1;
    @FXML
    private HBox book_info3;
    @FXML
    private StackPane bookInfoContainer2;
    @FXML
    private HBox aaa2;
    @FXML
    private Text title1;
    @FXML
    private HBox member_info2;
    @FXML
    private StackPane memberInfoContainer2;
    @FXML
    private HBox box_a2;
    @FXML
    private TableView<Utilisateur> tableEtudiant;
    @FXML
    private TableColumn<Utilisateur, String> tabnom;
    @FXML
    private TableColumn<Utilisateur, String> tabPrenom;
    @FXML
    private Tab renewTab21;
     @FXML
    private JFXTextField DSF;

    @FXML
    private JFXTextField CCF;

    @FXML
    private JFXTextField EXF;

    @FXML
    private Text MOYF;

    /**
     * Initializes the controller class.
     */
    
    Utilisateur u;
    ObservableList<Utilisateur> ListU=FXCollections.observableArrayList();
    
    private final Connection con;
    private PreparedStatement ste;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;
    public AjoutNoteController() {
        DataBase mc=DataBase.getInstance();
	con=mc.getConnection();
	    }
    Utilisateur rowData2;
    int idmtt=0;
    int idEt;
    
     public void inflateUII(Classe c,int idMat) {
         idmtt=idMat;
         renewTab21.setDisable(true);
         title1.setText("> Liste des Etudiants dans  "+c.getNom());
         try {
            
            String req1="select f.id,f.username,f.username_canonical,f.enabled,f.salt,f.password,f.confirmation_token,f.roles,f.cin,f.numtel,f.datenaissance,f.adresse,f.profile,f.nom,f.prenom,f.email,f.email_canonical from fos_user f , etudiant e  where f.id=e.id and e.idClasse="+c.getId()+" and e.id not in (select idEtu from note where matiere_id= "+idmtt+")";
            ResultSet rs1;
            Statement st1 =con.createStatement();
            rs1= st1.executeQuery(req1);
            while(rs1.next()){
                int id = rs1.getInt("id");
                 String username = rs1.getString("username");
                String username_canonical = rs1.getString("username_canonical");
                int enabled = rs1.getInt("enabled");
                String salt = rs1.getString("salt");
                String password = rs1.getString("password");
                String confirmation_token = rs1.getString("confirmation_token");
                String roles = rs1.getString("roles");
                int cin = rs1.getInt("cin");   
                int numtel = rs1.getInt("numtel");  
                Date datenaissance = rs1.getDate("datenaissance");  
                String adresse = rs1.getString("adresse");  
                String profile = rs1.getString("profile");
                String nom = rs1.getString("nom");
                String prenom = rs1.getString("prenom");
                String email = rs1.getString("email");
                String email_canonical = rs1.getString("email_canonical");
                Utilisateur u =new Utilisateur(id,username,username_canonical,email,email_canonical,enabled,salt,password,confirmation_token,roles,cin,numtel,datenaissance,adresse,profile,nom,prenom);
                System.out.println(u);
                
                ListU.add(u);
                
                
                
            }
            System.out.println(ListU);
            tabnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tabPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            tableEtudiant.getItems().setAll(ListU);
            tableEtudiant.setRowFactory(tt -> {
                TableRow<Utilisateur>row2 = new TableRow<>();
                row2.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (!row2.isEmpty())){
                    renewTab21.setDisable(false);
                    renewTab1.setDisable(true); 
                     rowData2 = row2.getItem();
                    mainTabPane1.getSelectionModel().select(renewTab21);
                }
                });
                return row2;
            });
            
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AjoutNoteController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    
    }
     @FXML
        private void addBook(ActionEvent event) throws SQLException{
            idEt=rowData2.getId();
            float dsf=parseFloat(DSF.getText());
            float ccf=parseFloat(CCF.getText());
            float exf=parseFloat(EXF.getText());
            float a=(float) 0.2;
            float b=(float) 0.6;
            float moyn= dsf * a + ccf * a + exf * b ;
            System.out.println("matiere id "+idmtt);
            System.out.println(dsf+" "+ccf+" "+exf+" "+" "+moyn);
            String requeteInsert="insert into note (matiere_id,idEtu,noteDs,noteEx,noteCc,moy)values("+idmtt+","+idEt+", "+dsf+","+ccf+","+exf+","+moyn+")";
             ste =con.prepareStatement(requeteInsert);
                ste.executeUpdate();
                System.out.println("Note ajoutée");
            
            
         
     }
        @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) title1.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    
}
