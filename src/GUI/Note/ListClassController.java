/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;


import Entities.Education.Classe;
import Entities.Education.Matiere;
import Entities.Education.Module;
import Entities.Education.Note;
import Utils.DataBase;
import Utils.DataBasee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.sun.javafx.scene.traversal.Direction;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class ListClassController implements Initializable {
    @FXML
    private TableView<Note> tableEtuddiant;

    @FXML
    private TableColumn<Note, String> tabnomEtud;

    @FXML
    private TableColumn<Note, Float> tabCC;

    @FXML
    private TableColumn<Note, Float> tabDS;

    @FXML
    private TableColumn<Note, Float> tabEX;

    @FXML
    private TableColumn<Note, Float> tabMoy;
    
    @FXML
    private StackPane rootPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private JFXTabPane mainTabPane;
    @FXML
    private Tab bookIssueTab;
    @FXML
    private Tab renewTab21;
    @FXML
    private HBox book_info;
    @FXML
    private TableView<Module> tableModule;

    @FXML
    private TableColumn<Module, String> tabnomMod;

    @FXML
    private TableColumn<Module, String> tabCoefMod;

    @FXML
    private StackPane bookInfoContainer;
    @FXML
    private HBox aaa;
    @FXML
    private TableView<Classe> tableClasse;
     @FXML
    private TableColumn<Classe, String> tabNom;
    @FXML
    private TableColumn<Classe, String> tabAnnee;

    private HBox member_info;
    @FXML
    private StackPane memberInfoContainer;
    @FXML
    private HBox box_a;
    @FXML
    private Tab renewTab;
    @FXML
    private Tab renewTab2;
    @FXML
    private Text title1;
    @FXML
    private Text title11;
    
    @FXML
    private Text title111;
    @FXML
    private TableView<Matiere> tableMatiere;

    @FXML
    private TableColumn<Matiere, String> tabnomMatiere;

    @FXML
    private TableColumn<Matiere, Integer> tabCoefMatiere;

    @FXML
    private TableColumn<Matiere, String> tabProf;
    @FXML
    private JFXTextField bookID;
    @FXML
    private JFXButton renewButton;
    @FXML
    private JFXButton submissionButton;
    @FXML
    private HBox submissionDataContainer;
    @FXML
    private Text memberNameHolder;
    @FXML
    private Text memberEmailHolder;
    @FXML
    private Text memberContactHolder;
    
    @FXML
    private Text bookNameHolder;
    @FXML
    private Text bookAuthorHolder;
    @FXML
    private Text bookPublisherHolder;
    @FXML
    private Text issueDateHolder;
    @FXML
    private Text numberDaysHolder;
    @FXML
    private Text fineInfoHolder;
    @FXML
    private JFXHamburger hamburger;
    Classe cll;
    Module modl;
    Matiere mt;
    Matiere rowDataMatiere;
    int idMt;
    int idmtt;
    private final Connection con;
    private PreparedStatement ste;
    public ListClassController() {
        DataBase mc=DataBase.getInstance();
	con=mc.getConnection();
	    }
    ObservableList<Classe> Listcl=FXCollections.observableArrayList();
    ObservableList<Module> ListMod=FXCollections.observableArrayList();
    ObservableList<Matiere> ListMat=FXCollections.observableArrayList();
    ObservableList<Note> ListNt=FXCollections.observableArrayList();
    Classe rowData;
    Note nt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        renewTab.setDisable(true);
        
        try {
            initDrawer();
            String req="select * from classe ";
            ResultSet rs;
            Statement st =con.createStatement();
            rs= st.executeQuery(req);
            while(rs.next()){
                int idcl = rs.getInt(1);
                String nomcl=rs.getString(2);
                
                
                 cll=new Classe(idcl,nomcl);
                
                 // System.out.println(m);

                Listcl.add(cll);
                System.out.println(Listcl);

            }
            tabNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tableClasse.getItems().setAll(Listcl);
                
                tableClasse.setRowFactory( tv -> {
                    
                TableRow<Classe> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    tableModule.getItems().clear();
                    renewTab.setDisable(false);
                    try {
                         rowData = row.getItem();
                        mainTabPane.getSelectionModel().select(renewTab);
                        bookIssueTab.setDisable(true);
                        title1.setText("> Liste des modules dans  "+rowData.getNom());
                        System.out.println(rowData);
                        int idcll=rowData.getId();
                        String req2="select m.* from module m  , module_classe mc where mc.classe_id="+idcll+" and m.id=mc.module_id";
                        ResultSet rs2;
                        Statement st2 =con.createStatement();
                        rs2= st2.executeQuery(req2);
                        while(rs2.next()){
                        int idMod = rs2.getInt(1);
                        String nomMod=rs2.getString(2);
                        int coefMod=rs2.getInt(3);
                        

                         modl=new Module(idMod,nomMod,coefMod);
                        ListMod.add(modl);}
                        System.out.println(ListMod);
                        tabnomMod.setCellValueFactory(new PropertyValueFactory<>("nomModule"));
                        tabCoefMod.setCellValueFactory(new PropertyValueFactory<>("coefModule"));
                        tableModule.getItems().setAll(ListMod);
                        

            
                    } catch (SQLException ex) {
                        Logger.getLogger(ListClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
        }
                
    });
                return row ;});
                
        } catch (SQLException ex) {
            Logger.getLogger(ListClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableModule.setRowFactory( t -> {
                TableRow<Module> row1 = new TableRow<>();
                row1.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (! row1.isEmpty()) ) {
                    try {
                        Module rowData1 = row1.getItem();
                        mainTabPane.getSelectionModel().select(renewTab2);
                        
                        title11.setText("> Liste des matiere dans  "+rowData1.getNomModule());
                        System.out.println(rowData1);
                        int idmdd=rowData1.getIdModule();
                        System.out.println(idmdd+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        String req3="select mat.id, mat.nom, mat.coefficient  from matiere mat , module_matiere mm where mat.id=mm.matiere_id and mm.module_id = "+idmdd;
                        ResultSet rs3;
                        Statement st3 =con.createStatement();
                        rs3= st3.executeQuery(req3);
                        while(rs3.next()){
                         idMt = rs3.getInt(1);
                        String nomMt=rs3.getString(2);
                        int coefMt=rs3.getInt(3);
                        
                        

                         mt=new Matiere(idMt,nomMt,coefMt);
                        ListMat.add(mt);}
                        System.out.println(ListMat);
                        tabnomMatiere.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
                        tabCoefMatiere.setCellValueFactory(new PropertyValueFactory<>("coefMatiere"));
                        tableMatiere.getItems().setAll(ListMat);
                        renewTab.setDisable(true);
                        

            
                    } catch (SQLException ex) {
                        Logger.getLogger(ListClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }});
        return row1;});
        
        tableMatiere.setRowFactory(tt -> {
            TableRow<Matiere>rowmat = new TableRow<>();
            rowmat.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (!rowmat.isEmpty())){
                    try {
                        renewTab2.setDisable(true);
                        
                         rowDataMatiere = rowmat.getItem();
                        mainTabPane.getSelectionModel().select(renewTab21);
                        title111.setText("> Liste des Etudiants dans  "+rowData.getNom());
                         idmtt=rowDataMatiere.getId();
                        System.out.println(rowDataMatiere);
                        System.out.println(idmtt+"maaaaatiiieeeerrrreeee");
                        System.out.println("matierreeeee"+rowDataMatiere);
                        String req4="select DISTINCT  n.* , concat(nom,' ',prenom)as nomEtud from classe c , note n , fos_user f , etudiant etd where f.id=etd.id and etd.idClasse="+rowData.getId()+" and n.matiere_id="+idmtt+" and n.idEtu=etd.id";
                        ResultSet rs4;
                        Statement st4 =con.createStatement();
                        rs4= st4.executeQuery(req4);
                        while(rs4.next()){
                            int idnote = rs4.getInt(1);
                            int idmaat=rs4.getInt(2);
                            int idEt=rs4.getInt(3);
                            float noteDs=rs4.getFloat(4);
                            float noteEx=rs4.getFloat(5);
                            float noteCc=rs4.getFloat(6);
                            float moyn=rs4.getFloat(7);
                            String nomEtd=rs4.getString(8);
                            nt=new Note(idnote,idmaat,idEt,nomEtd,noteDs,noteCc,noteEx,moyn);
                            
                            ListNt.add(nt);
                            
                        }
                        System.out.println(ListNt);
                        tabnomEtud.setCellValueFactory(new PropertyValueFactory<>("nomEtud"));
                        tabCC.setCellValueFactory(new PropertyValueFactory<>("noteCc"));
                        tabDS.setCellValueFactory(new PropertyValueFactory<>("noteDs"));
                        tabEX.setCellValueFactory(new PropertyValueFactory<>("noteEx"));
                        tabMoy.setCellValueFactory(new PropertyValueFactory<>("moy"));
                        tableEtuddiant.getItems().setAll(ListNt);
                    } catch (SQLException ex) {
                        Logger.getLogger(ListClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                }
                    
                    
                
            });
            return rowmat;
            
        });
    }
                
        
        
        
        
    
    
    
    
    private void initDrawer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("toolbar.fxml"));
            VBox toolbar = loader.load();
            drawer.setSidePane(toolbar);
            ToolbarController controller = loader.getController();
           // controller.setBookReturnCallback(this);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            drawer.toggle();
        });
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.toFront();
        });
        drawer.setOnDrawerClosed((event) -> {
            drawer.toBack();
            task.setRate(task.getRate() * -1);
            task.play();
        });
    }
    private void loadData() throws SQLException {
        ListNt.clear();
        tableEtuddiant.getItems().clear();
        int idmtt=rowDataMatiere.getId();
                        System.out.println(rowData);
                        System.out.println(idmtt);
                        String req4="select DISTINCT  n.* , concat(nom,' ',prenom)as nomEtud from classe c , note n , fos_user f , etudiant etd where f.id=etd.id and etd.idClasse="+rowData.getId()+" and n.matiere_id="+idmtt+" and n.idEtu=e.id";
                        ResultSet rs4;
                        Statement st4 =con.createStatement();
                        rs4= st4.executeQuery(req4);
                        while(rs4.next()){
                            int idnote = rs4.getInt(1);
                            int idmaat=rs4.getInt(2);
                            int idEt=rs4.getInt(3);
                            float noteDs=rs4.getFloat(4);
                            float noteEx=rs4.getFloat(5);
                            float noteCc=rs4.getFloat(6);
                            float moyn=rs4.getFloat(7);
                            String nomEtd=rs4.getString(8);
                            nt=new Note(idnote,idmaat,idEt,nomEtd,noteDs,noteCc,noteEx,moyn);
                            
                            ListNt.add(nt);
                //tableMatiere.getItems().add(m);
     }
                        tabnomEtud.setCellValueFactory(new PropertyValueFactory<>("nomEtud"));
                        tabCC.setCellValueFactory(new PropertyValueFactory<>("noteCc"));
                        tabDS.setCellValueFactory(new PropertyValueFactory<>("noteDs"));
                        tabEX.setCellValueFactory(new PropertyValueFactory<>("noteEx"));
                        tabMoy.setCellValueFactory(new PropertyValueFactory<>("moy"));
                        tableEtuddiant.getItems().setAll(ListNt);
    }

    @FXML
    private void loadBookInfo2(ActionEvent event) {
    }

    @FXML
    private void loadRenewOp(ActionEvent event) {
    }

    @FXML
    private void loadSubmissionOp(ActionEvent event) {
    }

    @FXML
    private void handleMenuSettings(ActionEvent event) {
    }

    @FXML
    private void handleMenuClose(ActionEvent event) {
    }

    @FXML
    private void handleMenuAddBook(ActionEvent event) {
    }

    @FXML
    private void handleMenuAddMember(ActionEvent event) {
    }

    @FXML
    private void handleMenuViewBook(ActionEvent event) {
    }

    @FXML
    private void handleMenuViewMemberList(ActionEvent event) {
    }

    @FXML
    private void handleIssuedList(ActionEvent event) {
    }

    @FXML
    private void handleMenuFullScreen(ActionEvent event) {
    }

    @FXML
    private void handleMenuOverdueNotification(ActionEvent event) {
    }
    @FXML
    private void handleBookEditOption(ActionEvent event) {
        Note selectedForEdit = tableEtuddiant.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateNote.fxml"));
            Parent parent = loader.load();

            UpdateNoteController controller = (UpdateNoteController) loader.getController();
            controller.inflateUIII(selectedForEdit);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Editer note");
            stage.setScene(new Scene(parent));
            stage.show();
            

            stage.setOnHiding((e) -> {
                try {
                    handleRefresh(new ActionEvent());
                    
                   
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
             
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    @FXML
    private void handleBookDeleteOption(ActionEvent event) {
        Note selectedForDeletion = tableEtuddiant.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer Note");
        alert.setContentText("etez vous sur ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Statement st;
		try {
	        String requeteDelete =
	                "DELETE FROM note where id = "+selectedForDeletion.getId();
	                st =con.createStatement();
	                st.executeUpdate(requeteDelete);
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Supprimer note");
                        alert1.setContentText("note a été supprimer avec succes");
                        Optional<ButtonType> answer1 = alert1.showAndWait();
                        loadData();
	        }
	        catch (SQLException ex){
	            System.out.println(ex.getMessage());
	        }  
        }
    }
    
    
     
        
        
    

    @FXML
    private void handleAboutMenu(ActionEvent event) {
    }
    @FXML
    private void handleAjoutNote(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutNote.fxml"));
            Parent parent = loader.load();

            AjoutNoteController controller1 = (AjoutNoteController) loader.getController();
            controller1.inflateUII(rowData,idmtt);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Ajout Note");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnHiding((e) -> {
                try {
                    handleRefresh(new ActionEvent());
                    loadData();
                   
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ListClassController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });


    }
    @FXML
    private void handleRefresh(ActionEvent event) throws SQLException {
        loadData();
        
    }
    
    
   
}
