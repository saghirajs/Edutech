/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Education;


import Entities.Education.Absence;
import Entities.Utilisateur.Etudiant;
import IServices.ExtraScolaire.IService;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author MehdiS
 */
public class ServiceAbsence {

     private Connection con;
     private Statement ste;
   
     public ServiceAbsence() {
        con = DataBase.getInstance().getConnection();
    }
     
   
    public void ajouter(Absence a) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `absence` (`id`, `matiere`, `date`, `etat`,`idEtudiant`,`heure`,`classe`) VALUES (NULL, '" +   a.getMatiere() + "', '" + a.getDate() + "', '"+a.getetat() + "','"+a.getIdEtudiant()+ "','"+a.getHeure()+ "','"+a.getClasse()+"');";
        ste.executeUpdate(requeteInsert);
    }

    
    public boolean delete(Absence a) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "DELETE FROM `absence` WHERE `id` = '"+a.getIdS()+"'";
        if(ste.executeUpdate(requeteInsert) == 1){
            System.out.println("Suppression effectué");
            return true;
        };
        System.out.println("Suppression non effectué");
        return false;
    }

   
    public boolean update(Absence a) throws SQLException {
         ste = con.createStatement();
         System.out.println(a.getId());
         System.out.println(a.getetat());
         System.out.println(a.getDate());
         String requeteInsert ="UPDATE `absence` SET `etat`='"+a.getetat()+"' WHERE `id` = '"+a.getId()+"'";
         if(ste.executeUpdate(requeteInsert) == 1){
            System.out.println("modification effectué");
            return true;
        };
        System.out.println("modification non effectué");
        return false;
    }

  
    public List readAll() throws SQLException {
        List<Absence> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from absence");
    while (rs.next()) {                
               int id=rs.getInt(1);
               String matiere=rs.getString(2);
               String Etat=rs.getString(3);
               Timestamp date=rs.getTimestamp(4);
               int IdEtudiant = rs.getInt(5);
//               Absence p = new Absence(id,matiere,date, Etat,IdEtudiant);
 //    arr.add(p);
     }
    return arr;
    }
    
    public ObservableList<Absence> readAllV2() throws SQLException {
    ObservableList<Absence> AbsenceData = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT a.id , a.matiere , a.etat , a.date , (SELECT u.nom WHERE a.idEtudiant = u.id) FROM absence a , utilisateur u WHERE a.idEtudiant = u.id");
    while (rs.next()) {      
               int id = rs.getInt(1);
               String matiere=rs.getString(2);
               Timestamp date=rs.getTimestamp(4);
               String Etat=rs.getString(5);
               String nomEtudiant = rs.getString(3);
//               Absence p = new Absence(id,matiere,date, Etat,nomEtudiant);
  //   AbsenceData.add(p);
     }
    return AbsenceData;
    }
     
    public ObservableList<Timestamp> readAllS() throws SQLException {
    ObservableList<Timestamp> AbsenceData = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select date from absence");
    while (rs.next()) {                
    Timestamp date=rs.getTimestamp(1);
               
     AbsenceData.add(date);
     }
    return AbsenceData;
    }
    
    
    public int readAbsStudent(String nom)throws SQLException{
        int id = -1;
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select id from fos_user u where u.nom ='" +nom+"'"); 
        while (rs.next()) {       
               id =rs.getInt(1);
        }
        return id;
    }
    
    public ObservableList<Absence> readAllV2(Etudiant e) throws SQLException {
    ObservableList<Absence> AbsenceData = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT a.id , a.matiere , a.etat , a.date , (SELECT e.nom WHERE"+e.getId()+"= e.id) FROM absence a , etudiant e WHERE "+e.getId()+"= e.id");
    while (rs.next()) {      
               int id = rs.getInt(1);
               String matiere=rs.getString(2);
               Timestamp date=rs.getTimestamp(4);
               String Etat=rs.getString(5);
               String nomEtudiant = rs.getString(3);
//               Absence p = new Absence(id,matiere,date, Etat,nomEtudiant);
 //    AbsenceData.add(p);
     }
    return AbsenceData;
    }
    
    public ObservableList<Absence> readEduAbs(String cin) throws SQLException {
    ObservableList<Absence> AbsenceData = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT DISTINCT a.id ,(SELECT c.nomClasse FROM classe c WHERE a.classe = c.idClasse )  ,(SELECT m.nom FROM matiere m WHERE a.matiere = m.id ) ,a.etat , a.date,a.heure ,(SELECT u.nom WHERE a.idEtudiant = u.id) FROM absence a , fos_user u  WHERE a.idEtudiant = u.id and u.cin= '"+cin+"'");
    while (rs.next()) {      
               int id = rs.getInt(1);
               String matiere=rs.getString(3);
               String date=rs.getString(5);
               String heure=rs.getString(6);
               String Etat=rs.getString(4);
               String nomEtudiant = rs.getString(7);
               String classe = rs.getNString(2);
           Absence p = new Absence(id,matiere,date, Etat,nomEtudiant,heure,classe);
         AbsenceData.add(p);
     }
    return AbsenceData;
    }
    public int readMatiereId(String matiere) throws SQLException{
        int id = -1;
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select id from matiere u where u.nom ='" +matiere+"'"); 
        while (rs.next()) {       
               id =rs.getInt(1);
               System.out.println(id);
        }
        return id;
    }
    public int readClasseId(String classe) throws SQLException{
        int id = -1;
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select idClasse from classe u where u.nomClasse ='" +classe+"'"); 
        while (rs.next()) {       
               id =rs.getInt(1);
               System.out.println(id);
        }
        return id;
    }
}
