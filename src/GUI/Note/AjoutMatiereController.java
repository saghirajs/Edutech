///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI.Note;
//
//
//import Entities.Education.Module;
//import Entities.Utilisateur.Utilisateur;
//import Utils.DataBase;
//import Utils.DataBasee;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXTextField;
//import static java.lang.Integer.parseInt;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
///**
// * FXML Controller class
// *
// * @author ousse
// */
//public class AjoutMatiereController implements Initializable {
//    @FXML
//    private StackPane rootPane;
//    @FXML
//    private AnchorPane mainContainer;
//    @FXML
//    private JFXTextField matierefield;
//    @FXML
//    private JFXTextField coefField;
//    @FXML
//    private ChoiceBox<String> choiceModule;
//    @FXML
//    private ChoiceBox<String> choiceProf;
//    @FXML
//    private JFXButton saveButton;
//    @FXML
//    private JFXButton cancelButton;
//    
//    ObservableList<Module> ListMod=FXCollections.observableArrayList();
//    ObservableList<Utilisateur> ListUser=FXCollections.observableArrayList();
//   Module module;
//    Utilisateur u;
//    int idp;
//    int idMt;
//    int idMd;
//    private final Connection con;
//    private PreparedStatement ste;
//    public AjoutMatiereController() {
//        DataBase mc=DataBase.getInstance();
//	con=mc.getConnection();
//	    }
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try {
//             String req="select * from module";
//             ResultSet rs;
//             Statement st =con.createStatement();
//             rs= st.executeQuery(req);
//             while(rs.next()){
//                 int idMod = rs.getInt(1);
//                 String nomModule=rs.getString(2);
//                 int coefMod=rs.getInt(3);
//                 String specialite=rs.getString(4);
//                 
//                 module=new Module(idMod,nomModule,coefMod,specialite);
//                 
//                 System.out.println(module);
//                 ListMod.add(module);
//             }
//             choiceModule.getItems().add("Module");
//             for(Module i : ListMod){
//                 choiceModule.getItems().add(i.getNom());
//             }
//             choiceModule.getSelectionModel().selectFirst();
//             String req1="select * from user where string= 'ROLE_PROF'";
//             ResultSet rs1;
//             Statement st1 =con.createStatement();
//             rs1= st1.executeQuery(req1);
//             while(rs1.next()){
//                 int idUser = rs1.getInt(1);
//                 int idCl =rs1.getInt(2);
//                 String firstnameU=rs1.getString(3);
//                 String lastnameU=rs1.getString(4);
//                 String emailU=rs1.getString(5);
//                 int cinU =rs1.getInt(6);
//                 String pPwd=rs1.getString(7);
//                 String pwdU=rs1.getString(8);
//                 String roleU=rs1.getString(9);
//                 
//                 
//                 
//                 u=new Utilisateur(idUser,firstnameU,lastnameU,emailU,cinU,pPwd,pwdU,roleU,idCl);
//                 
//                 System.out.println(u);
//                 ListUser.add(u);
//             }
//             choiceProf.getItems().add("Prof");
//              for(Utilisateur j : ListUser){
//                 choiceProf.getItems().add(j.getFirstName()+" "+j.getLastName());
//             }
//              choiceProf.getSelectionModel().selectFirst();
//         } catch (SQLException ex) {
//             Logger.getLogger(Update_matiereController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//    }    
//
//    @FXML
//    private void addBook(ActionEvent event) throws SQLException {
//        String nomMt=matierefield.getText();
//        int cf=parseInt(coefField.getText());
//        String prf=choiceProf.getValue();
//        String mots[] = prf.split(" ");
//        String nom=mots[0];
//        String pre=mots[1];
//        String req1="select id  from user where firstname= \""+nom+"\" and lastname=\""+pre+"\"";
//             ResultSet rs2;
//             Statement st2 =con.createStatement();
//             rs2= st2.executeQuery(req1);
//             if(rs2.next()){
//                 idp=rs2.getInt(1);
//                
//             }
//             String md=choiceModule.getValue();
//        String req2="select id  from module where nommodule= \""+md+"\" ";
//             ResultSet rs3;
//             Statement st3 =con.createStatement();
//             rs3= st3.executeQuery(req2);
//             if(rs3.next()){
//                  idMd=rs3.getInt(1);
//             }
//             String mtf=matierefield.getText();
//             String requeteInsert="insert into matiere (prof_id,nom,cof,idModule)values("+idp+",\""+mtf+"\","+cf+","+idMd+")";
//             ste =con.prepareStatement(requeteInsert);
//                ste.executeUpdate();
//                System.out.println("Matiere ajoutée");
//        
//    }
//
//    @FXML
//    private void cancel(ActionEvent event) {
//         Stage stage = (Stage) coefField.getScene().getWindow();
//        stage.close();
//    }
//    
//}
