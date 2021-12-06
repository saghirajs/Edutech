/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;

import Utils.DataBasee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class MainController implements Initializable {
    
    
    @FXML
    private ChoiceBox<String> choiceMatiere;
    @FXML
    private CategoryAxis catAxis;

    @FXML
    private NumberAxis numAxis;

    @FXML
    private BarChart<String, Number> chartnote;
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
    private HBox book_info;
    @FXML
    private StackPane bookInfoContainer;
    @FXML
    private HBox member_info;
    @FXML
    private StackPane memberInfoContainer;
    @FXML
    private Tab renewTab;
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
    int idMatiere=0;

    private final Connection con;
    private PreparedStatement ste;
    private String matiereSel;
    @FXML
    private HBox aaa;
    @FXML
    private HBox box_a;

    public MainController() {
        DataBasee mc=DataBasee.getInstance();
	con=mc.getConnection();
	    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> listMatiere = FXCollections.observableArrayList();
        ObservableList<String> listClasse = FXCollections.observableArrayList();
        ObservableList<Float> listMoyPos = FXCollections.observableArrayList();
        ObservableList<Float> listMoyNeg = FXCollections.observableArrayList();
        XYChart.Series<String , Number> dataSeries1 = new XYChart.Series<>();
        XYChart.Series<String , Number> dataSeries2 = new XYChart.Series<>();
        dataSeries1.setName(">=10");
       
        
        
        
        initDrawer();
        try {
            String req="select nom from matiere";
            ResultSet rs;
            Statement st =con.createStatement();
            rs= st.executeQuery(req);
            while(rs.next()){
                listMatiere.add(rs.getString(1));
            }
            for(String cl : listMatiere){
            choiceMatiere.getItems().add(cl);}
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        choiceMatiere.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
           matiereSel= choiceMatiere.getItems().get((Integer)newValue);
            try {
                String requete="select id from matiere where nom = \""+matiereSel+"\"";
                ResultSet rs,rs1,rs2,rs3;
            
            Statement st =con.createStatement();
            rs= st.executeQuery(requete);
            if(rs.next()){
            idMatiere = rs.getInt(1);
            System.out.println(idMatiere);
            }
            
            String req1="select id ,  nom from classe";
            System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+idMatiere);
            
//            
            
            rs1=st.executeQuery(req1);
            while(rs1.next()){
                String reeq="select count(moy) from note n , user u where u.idclasse ="+rs1.getInt(1)+" and n.matiere_id="+idMatiere+" and u.id=n.etudiant_id and n.moy <10";
                
            
            Statement st3 =con.createStatement();
            rs3= st3.executeQuery(reeq);
            while(rs3.next()){
                dataSeries1.getData().add(new XYChart.Data<>(rs1.getString(2),rs3.getInt(1)));
            }
            String reeq1="select count(moy) from note n , user u where u.idclasse ="+rs1.getInt(1)+" and n.matiere_id="+idMatiere+" and u.id=n.etudiant_id and n.moy >=10";
                
            
            Statement st4 =con.createStatement();
            ResultSet rs4;
            rs4= st4.executeQuery(reeq1);
            while(rs4.next()){
                dataSeries2.getData().add(new XYChart.Data<>(rs1.getString(2),rs4.getInt(1)));
            }
            
                
                

                
                String classe=rs1.getString(2);
                
                
            }
            chartnote.getData().addAll(dataSeries1,dataSeries2);
            
            
            System.out.println(listClasse);
            
            
           
//        
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
        getStage().close();
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
    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }


    @FXML
    private void handleMenuFullScreen(ActionEvent event) { 
        Stage stage = getStage();
        stage.setFullScreen(!stage.isFullScreen());
    
    }

    @FXML
    private void handleMenuOverdueNotification(ActionEvent event) {
    }

    @FXML
    private void handleAboutMenu(ActionEvent event) {
    }
    
}
