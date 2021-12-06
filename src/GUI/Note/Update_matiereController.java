///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI.Note;
//
//import Entities.Education.Matiere;
//import Entities.Education.Module;
//import Entities.Utilisateur.Utilisateur;
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
//public class Update_matiereController implements Initializable {
//     @FXML
//    private StackPane rootPane;
//
//    @FXML
//    private AnchorPane mainContainer;
//
//    @FXML
//    private JFXTextField matierefield;
//
//    @FXML
//    private JFXTextField coefField;
//
//    @FXML
//    private ChoiceBox<String> choiceModule;
//
//    @FXML
//    private ChoiceBox<String> choiceProf;
//
//    @FXML
//    private JFXButton saveButton;
//
//    @FXML
//    private JFXButton cancelButton;
//
//  
//    ObservableList<Module> ListMod=FXCollections.observableArrayList();
//    ObservableList<Utilisateur> ListUser=FXCollections.observableArrayList();
//   int idmm;
//   
//    private final Connection con;
//    private PreparedStatement ste;
//    public Update_matiereController() {
//        DataBasee mc=DataBasee.getInstance();
//	con=mc.getConnection();
//	    }
//    /**
//     * Initializes the controller class.
//     */
//    Module module;
//    Utilisateur u;
//    int idMd;
//    int idp;
//    int idMt;
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//         
//         
//         try {
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
//             }
//            
//         
//         
//            
//        
//    public void inflateUI(Matiere m) {
//         idmm=m.getId();
//        matierefield.setText(m.getNom());
////        //profField.setText(m.getNomProf());
//        coefField.setText(String.valueOf(m.getCoef()));
////        //moduleField.setText(m.getNomModule());
//    
//        
//    }
//
//    @FXML
//    private void addBook(ActionEvent event) throws SQLException {
//        String m1=matierefield.getText();
//        int c1=parseInt(coefField.getText());
//        String prf=choiceProf.getValue();
//        String mots[] = prf.split(" ");
//        String nom=mots[0];
//        String pre=mots[1];
//        System.out.println(prf);
//        System.out.println(nom);
//        System.out.println(pre);
//        String req1="select id  from user where firstname= \""+nom+"\" and lastname=\""+pre+"\"";
//             ResultSet rs2;
//             Statement st2 =con.createStatement();
//             rs2= st2.executeQuery(req1);
//             if(rs2.next()){
//                 idp=rs2.getInt(1);
//                
//             }
//             String md=choiceModule.getValue();
//        String req2="select id  from module where nom_module= \""+md+"\" ";
//             ResultSet rs3;
//             Statement st3 =con.createStatement();
//             rs3= st3.executeQuery(req2);
//             if(rs3.next()){
//                  idMd=rs3.getInt(1);
//             }
//             
//             
//             
//             int cf=parseInt(coefField.getText());
//             String mtf=matierefield.getText();
//             System.out.println("profid"+idp+"matiere"+mtf+"coef"+cf+"idmodule"+idMd+"idmatiere"+idmm);
//        String requeteUpdate =
//                    "UPDATE matiere SET prof_id ="+idp+",nom=\""+mtf+"\",cof="+cf+",idModule="+idMd+"  where id="+idmm+"";
//        
//
//            ste =con.prepareStatement(requeteUpdate);
//            ste.executeUpdate();
//            System.out.println("matiere modifier");
//    }
//
//    @FXML
//    private void cancel(ActionEvent event) {
//        Stage stage = (Stage) coefField.getScene().getWindow();
//        stage.close();
//    }
//    
//    
//    
//    
//}
