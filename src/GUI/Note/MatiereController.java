///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI.Note;
//
//
//import Entities.Education.Matiere;
//import Utils.DataBasee;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXDrawer;
//import com.jfoenix.controls.JFXHamburger;
//import com.jfoenix.controls.JFXTabPane;
//import com.jfoenix.controls.JFXTextField;
//import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import javafx.util.Callback;
//
///**
// * FXML Controller class
// *
// * @author ousse
// */
//public class MatiereController implements Initializable {
//    @FXML
//    private StackPane rootPane;
//    @FXML
//    private JFXDrawer drawer;
//    @FXML
//    private AnchorPane rootAnchorPane;
//    @FXML
//    private JFXTabPane mainTabPane;
//    @FXML
//    private Tab bookIssueTab;
//    @FXML
//    private HBox book_info;
//    @FXML
//    private StackPane bookInfoContainer;
//    @FXML
//    private HBox aaa;
//    @FXML
//    private ChoiceBox<?> choiceMatiere;
//    @FXML
//    private HBox member_info;
//    @FXML
//    private StackPane memberInfoContainer;
//    @FXML
//    private HBox box_a;
//    @FXML
//    private BarChart<?, ?> chartnote;
//    @FXML
//    private NumberAxis numAxis;
//    @FXML
//    private CategoryAxis catAxis;
//    @FXML
//    private Tab renewTab;
//    @FXML
//    private JFXTextField bookID;
//    @FXML
//    private JFXButton renewButton;
//    @FXML
//    private JFXButton submissionButton;
//    @FXML
//    private HBox submissionDataContainer;
//    @FXML
//    private Text memberNameHolder;
//    @FXML
//    private Text memberEmailHolder;
//    @FXML
//    private Text memberContactHolder;
//    @FXML
//    private Text bookNameHolder;
//    @FXML
//    private Text bookAuthorHolder;
//    @FXML
//    private Text bookPublisherHolder;
//    @FXML
//    private Text issueDateHolder;
//    @FXML
//    private Text numberDaysHolder;
//    @FXML
//    private Text fineInfoHolder;
//    @FXML
//    private TableView<Matiere> tableMatiere;
//    @FXML
//    private TableColumn<Matiere, String> tabNom;
//
//    @FXML
//    private TableColumn<Matiere, Integer> tabCoef;
//
//    @FXML
//    private TableColumn<Matiere, String> tabModule;
//
//    @FXML
//    private TableColumn<Matiere, String> tabProf;
//    @FXML
//    private JFXHamburger hamburger;
//    Matiere m ;
//    
//    private final Connection con;
//    private PreparedStatement ste;
//    public MatiereController() {
//        DataBasee mc=DataBasee.getInstance();
//	con=mc.getConnection();
//	    }
//
//    /**
//     * Initializes the controller class.
//     */
//    ObservableList<Matiere> ListE=FXCollections.observableArrayList();
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//       
//        try {
//            initDrawer();
//            String req="select mat.id, nom, mat.cof ,nom_module, concat(firstname,'  ',lastname) from matiere mat , user u , module mo where u.id = mat.prof_id and mat.idModule = mo.id ";
//            ResultSet rs;
//            Statement st =con.createStatement();
//            rs= st.executeQuery(req);
//            
//            while(rs.next()){
//                int idMat = rs.getInt(1);
//                String nomMat=rs.getString(2);
//                int coef=rs.getInt(3);
//                String nomMod=rs.getString(4);
//                String nomProf=rs.getString(5);
//                 m=new Matiere(idMat,nomMat,coef,nomMod,nomProf);
//                
//                 // System.out.println(m);
//
//                ListE.add(m);
//                System.out.println(ListE);
//                
//        
//                
//            }
//            tabNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//                tabCoef.setCellValueFactory(new PropertyValueFactory<>("coef"));
//                tabModule.setCellValueFactory(new PropertyValueFactory<>("nomModule"));
//                tabProf.setCellValueFactory(new PropertyValueFactory<>("nomProf"));
//                
//                tableMatiere.getItems().setAll(ListE);
//                
//                //tableMatiere.getItems().add(m);
//        } catch (SQLException ex) {
//            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//                
//            
//        
//        
//
//    @FXML
//    private void ajouterMatiere(ActionEvent event) throws IOException, SQLException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutMatiere.fxml"));
//            Parent parent = loader.load();
//
//            Stage stage = new Stage(StageStyle.DECORATED);
//            stage.setTitle("Ajouter matiere");
//            stage.setScene(new Scene(parent));
//            stage.show();
//            
//
//            stage.setOnHiding((e) -> {
//                try {
//                    handleRefresh(new ActionEvent());
//                    loadData();
//                } catch (SQLException ex) {
//                    Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
//            loadData();
//            
//        
//    }
//
//    @FXML
//    private void loadRenewOp(ActionEvent event) {
//    }
//
//    @FXML
//    private void loadSubmissionOp(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuSettings(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuClose(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuAddBook(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuAddMember(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuViewBook(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuViewMemberList(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleIssuedList(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuFullScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void handleMenuOverdueNotification(ActionEvent event) {
//    }
//     private void initDrawer() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("toolbar.fxml"));
//            VBox toolbar = loader.load();
//            drawer.setSidePane(toolbar);
//            ToolbarController controller = loader.getController();
//           // controller.setBookReturnCallback(this);
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
//        task.setRate(-1);
//        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//            drawer.toggle();
//        });
//        drawer.setOnDrawerOpening((event) -> {
//            task.setRate(task.getRate() * -1);
//            task.play();
//            drawer.toFront();
//        });
//        drawer.setOnDrawerClosed((event) -> {
//            drawer.toBack();
//            task.setRate(task.getRate() * -1);
//            task.play();
//        });
//    }
//     
//     private void loadData() throws SQLException {
//        ListE.clear();
//        String req="select DISTINCT mat.id, mat.nom, mat.cof ,nom_module, concat(firstname,'  ',lastname) from matiere mat , user u , module mo where u.id = mat.prof_id and mat.idModule = mo.id ";
//            ResultSet rs;
//            Statement st =con.createStatement();
//            rs= st.executeQuery(req);
//            
//            while(rs.next()){
//                int idMat = rs.getInt(1);
//                String nomMat=rs.getString(2);
//                int coef=rs.getInt(3);
//                String nomMod=rs.getString(4);
//                String nomProf=rs.getString(5);
//                 m=new Matiere(idMat,nomMat,coef,nomMod,nomProf);
//                 ListE.add(m);
//                 
//            }
//            tabNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//                tabCoef.setCellValueFactory(new PropertyValueFactory<>("coef"));
//                tabModule.setCellValueFactory(new PropertyValueFactory<>("nomModule"));
//                tabProf.setCellValueFactory(new PropertyValueFactory<>("nomProf"));
//                
//                tableMatiere.getItems().setAll(ListE);
//                
//                //tableMatiere.getItems().add(m);
//     }
//     @FXML
//    private void handleBookDeleteOption(ActionEvent event) {
//        //Fetch the selected row
//        Matiere selectedForDeletion = tableMatiere.getSelectionModel().getSelectedItem();
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Supprimer matiere");
//        alert.setContentText("etez vous sur de supprimer " + selectedForDeletion.getNom() + " ?");
//        Optional<ButtonType> answer = alert.showAndWait();
//        if (answer.get() == ButtonType.OK) {
//            Statement st;
//		try {
//	        String requeteDelete =
//	                "DELETE FROM matiere where id = "+selectedForDeletion.getId();
//	                st =con.createStatement();
//	                st.executeUpdate(requeteDelete);
//                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                        alert1.setTitle("Supprimer matiere");
//                        alert1.setContentText("La matiere  " + selectedForDeletion.getNom() + " a été supprimer avec succes");
//                        Optional<ButtonType> answer1 = alert1.showAndWait();
//                        loadData();
//	        }
//	        catch (SQLException ex){
//	            System.out.println(ex.getMessage());
//	        }  
//        }
//    }
//    @FXML
//    private void handleBookEditOption(ActionEvent event) throws SQLException {
//        Matiere selectedForEdit = tableMatiere.getSelectionModel().getSelectedItem();
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Update_matiere.fxml"));
//            Parent parent = loader.load();
//
//            Update_matiereController controller = (Update_matiereController) loader.getController();
//            controller.inflateUI(selectedForEdit);
//
//            Stage stage = new Stage(StageStyle.DECORATED);
//            stage.setTitle("Editer matiere");
//            stage.setScene(new Scene(parent));
//            stage.show();
//            
//
//            stage.setOnHiding((e) -> {
//                try {
//                    handleRefresh(new ActionEvent());
//                    loadData();
//                   
//                    
//                } catch (SQLException ex) {
//                    Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
//             
//            
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    
//    }
//    @FXML
//    private void handleRefresh(ActionEvent event) throws SQLException {
//        loadData();
//        
//    }
//        
//
//    @FXML
//    private void handleAboutMenu(ActionEvent event) {
//    }
//    
//}
