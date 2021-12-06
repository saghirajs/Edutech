/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Education;


import Entities.Education.Matiere;
import IServices.Education.IServiceMatiere;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MehdiS
 */
public class ServiceMatiere {
    private Connection con;
    private Statement ste;
    PreparedStatement pst;
    
     public ServiceMatiere() {
        con = DataBase.getInstance().getConnection();
    }

    
    
    
    
  
    public void ajouter(Object e1) {
        Matiere e=(Matiere)e1;
        try {
            
            String requeteInsert = "INSERT INTO matiere(nom,coefficient,de_croissant) VALUES(?,?,NULL)";
            
            pst =con.prepareStatement(requeteInsert);

            pst.setString(1, e.getNomMatiere());
            pst.setInt(2, e.getCoefMatiere());

            pst.executeUpdate();
            System.out.println("matiere ajouté");
            
        } catch (SQLException ex) {
            //Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
        }
	 
    }

   
    public void modifier(int id, Object e1) {
        if(e1 instanceof Matiere){
        Matiere m=(Matiere)e1;
        
        try {
            String requeteUpdate =
                    "UPDATE matiere SET nom = ? , coefficient = ? "+"WHERE id='"+id+"'";

            pst =con.prepareStatement(requeteUpdate);

            pst.setString(1, m.getNomMatiere());
            pst.setInt(2, m.getCoefMatiere());
            

            pst.executeUpdate();
            System.out.println("matiere modifier");


        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }    
        }
        else if(e1 instanceof String){
            String m = (String)e1;
         try {
            String requeteUpdate =
                    "UPDATE matiere SET nom = ?  "+"WHERE id='"+id+"'";

            pst =con.prepareStatement(requeteUpdate);

            pst.setString(1, m);
            
            

            pst.executeUpdate();
            System.out.println("matiere modifier");


        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }       
        }
        else if(e1 instanceof Integer){
            int m = (Integer)e1;
         try {
            String requeteUpdate =
                    "UPDATE matiere SET coefficient = ?  "+"WHERE id='"+id+"'";

            pst =con.prepareStatement(requeteUpdate);

            pst.setInt(1, m);
            
            

            pst.executeUpdate();
            System.out.println("matiere modifier");


        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }       
        }
    }

   
    public void supprimer(Object m1) {
        Matiere m =(Matiere)m1;
        try {
        String requeteDelete =
                "DELETE FROM matiere where matiere.nom='"+m.getNomMatiere()+"'";
                ste =con.createStatement();
                ste.executeUpdate(requeteDelete);
                System.out.println("user supprimée____ ");
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }     }

  
    public void afficherList() {
        ResultSet rs;
        String requete = "select * from matiere ";
        try {
            ste =con.createStatement();
            rs= ste.executeQuery(requete);
            while(rs.next()){
                System.out.println("ID: "+rs.getString("id")+" , Nom: "+rs.getString("nom")+" , Coefficient: "+rs.getString("coefficient"));

               
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
        }    }
   
    public ObservableList<String> readAll() throws SQLException {
        ObservableList<String> arr = FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from matiere");
        while (rs.next()) {                
                   int id=rs.getInt(1);
                   String nom = rs.getString(2);

         arr.add(nom);
         }
        return arr;
        }
     public ObservableList<Matiere> getAllMatiere() {
        ResultSet rs;
        ObservableList<Matiere> list = FXCollections.observableArrayList();
        String requete = "select * from matiere ";
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(requete);
            while (rs.next()) {

//                    list.add(new User(rs.getString("nom"), rs.getString("prenom")));
                list.add(new Matiere(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)
                        
                ));
            }
        } catch (SQLException ex) {
           // Logger.getLogger(ServiceSpecialite.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
