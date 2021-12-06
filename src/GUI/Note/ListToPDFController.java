/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Note;


import Entities.Utilisateur.Utilisateur;
import Utils.DataBase;
import Utils.DataBasee;
//import be.quodlibet.boxable.BaseTable;
//import be.quodlibet.boxable.datatable.DataTable;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Math.round;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author ousse
 */
public class ListToPDFController implements Initializable {
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private TableView<Utilisateur> tableView;
    @FXML
    private TableColumn<Utilisateur,Integer > titleCol;
    @FXML
    private TableColumn<Utilisateur, String> idCol;
    @FXML
    private TableColumn<Utilisateur, String> authorCol;
    @FXML
    private TableColumn<Utilisateur, String> publisherCol;
    @FXML
    private TableColumn<Utilisateur, Float> availabilityCol;

    /**
     * Initializes the controller class.
     */
    
     private final Connection con;
    private PreparedStatement ste;
    public ListToPDFController() {
        DataBase mc=DataBase.getInstance();
	con=mc.getConnection();
	    }
    public enum Orientation {
        PORTRAIT, LANDSCAPE
    };
    Orientation orientation;
    File saveLoc ;
    List<String> list1=new ArrayList<String>();
    List<String> list2=new ArrayList<String>();
       List<List> ListEE = new ArrayList<List>() ;

    Utilisateur u ;
    Utilisateur rowData;
    float somme = 0;
    int compteur = 0;
    float mg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<Utilisateur> ListE=FXCollections.observableArrayList();
            String req="select f.id , f.cin , f.concat(firstname,' ',lastname),email,c.nomClasse , e.idclasse  from fos_user f , classe c , etudiant e where f.id=e.id and c.id=e.idclasse ";
            ResultSet rs;
            Statement st =con.createStatement();
            rs= st.executeQuery(req);
            
            while(rs.next()){
                int idU = rs.getInt(1);
                int cin=rs.getInt(2);
                String nomU=rs.getString(3);
                String email=rs.getString(4);
                String nomCL=rs.getString(5);
                int idCL=rs.getInt(6);
            String req6="select sum(n.moy) / count(*) as moyenne from note n where idEtu="+idU;
            ResultSet rs6;
            Statement st6 =con.createStatement();
            rs6= st6.executeQuery(req6);
            if(rs6.next()){
                mg=rs6.getFloat(1);
            }
                
                
                
                
                
                
                u=new Utilisateur(idU,nomU,email,cin,idCL,mg,nomCL);
                ListE.add(u);
            }
            
            titleCol.setCellValueFactory(new PropertyValueFactory<>("cin"));
            idCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            authorCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            publisherCol.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
            availabilityCol.setCellValueFactory(new PropertyValueFactory<>("mg"));
            tableView.getItems().setAll(ListE);
            System.out.println(ListE);
            tableView.setRowFactory( tv -> {
                TableRow<Utilisateur> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    try {
                        rowData = row.getItem();
                        String req1="select * from fos_user where id="+rowData.getId()+" ";
                        ResultSet rs1;
                        Statement st1 =con.createStatement();
                        rs1= st1.executeQuery(req1);
                        
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream("releve_note_"+rowData.getUsername()+".pdf"));
                        document.open();
                        document.add(new Paragraph("releve de note ",FontFactory.getFont(FontFactory.COURIER_BOLD,20,BaseColor.DARK_GRAY)));
                        document.add(new Paragraph("Nom Prenom :      "+rowData.getUsername()));
                        document.add(new Paragraph("C.I.N :      "+rowData.getCin()));
                        document.add(new Paragraph("Classe : "+rowData.getNomCl()+"                                                                                 Annee universitaire: 2019/2020"));
                        document.add(new Paragraph("  "));
                        document.add(new Paragraph("  "));
                        PdfPTable table = new PdfPTable(6);
                        table.setWidths(new int[]{100,12,10,10,10,10});
                        table.addCell("Matiere");
                        table.addCell("Coef");
                        table.addCell("CC");
                        table.addCell("DS");
                        table.addCell("EX");
                        table.addCell("Moy");
                        String req2="select * from Module";
                        ResultSet rs2;
                        Statement st2 =con.createStatement();
                        rs2= st2.executeQuery(req2);
                        while(rs2.next()){
                            PdfPCell cell1=new PdfPCell(new Paragraph("Module "+rs2.getString(2)));
                            cell1.setColspan(6);
                            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell1.setBackgroundColor(BaseColor.YELLOW);
                            table.addCell(cell1);
                            String req3="select mt.nom,mt.coefficient,n.noteCc,n.noteDs,n.noteEx,n.moy from note n , matiere mt where mt.id="+rs2.getInt(1)+" and n.idEtu="+rowData.getId()+" and mt.id=n.matiere_id";
                           ResultSet rs3;
                        Statement st3 =con.createStatement();
                        rs3= st3.executeQuery(req3);
                        while(rs3.next()){
                        table.addCell(rs3.getString(1));
                        table.addCell(String.valueOf(rs3.getInt(2)));
                        table.addCell(String.valueOf(rs3.getFloat(3)));
                        table.addCell(String.valueOf(rs3.getFloat(4)));
                        table.addCell(String.valueOf(rs3.getFloat(5)));
                        DecimalFormat df = new DecimalFormat("########.00");
                        String str = df.format((rs3.getFloat(6)));
                        double ss=Double.parseDouble(str.replace(',', '.'));
                        table.addCell(String.valueOf(ss));
                        somme=somme+rs3.getFloat(6);
                        compteur++;
                        System.out.println("somme= "+somme+"  compteur = "+compteur+"  moyenne = "+somme/compteur);
                            
                        }
                        }
                        DecimalFormat df1 = new DecimalFormat("########.00");
                        String str1 = df1.format((somme/compteur));
                        double ss1=Double.parseDouble(str1.replace(',', '.'));
                        PdfPCell cell2=new PdfPCell(new Paragraph("Moyenne Generale = "+ss1));
                            cell2.setColspan(6);
                            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell2.setBackgroundColor(BaseColor.ORANGE);
                            table.addCell(cell2);
                        
                        
                        
                        
                        
                        document.add(table);
                        
                        document.close();
                        JOptionPane.showMessageDialog(null, "releve de note a ete telehargé");
                        
                        
                        
                           
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ListToPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ListToPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DocumentException ex) {
                        Logger.getLogger(ListToPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                    
                });
            
            return row;
            });
            
            
            
            
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ListToPDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
        
    

    @FXML
    private void handleRefresh(ActionEvent event) {
    }

    @FXML
    private void handleBookEditOption(ActionEvent event) {
    }

    @FXML
    private void handleBookDeleteOption(ActionEvent event) {
    }

    @FXML
    private void exportAsPDF(ActionEvent event) {
    }

    @FXML
    private void closeStage(ActionEvent event) {
    }
    
}
