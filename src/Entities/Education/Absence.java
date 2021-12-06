/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Education;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author MehdiS
 */
public class Absence {
    private int id;
    private int matiere;
    private String timestamp;
    private String heure;
    private int IdEtudiant;
    private int classe;
    private String classeS;
    private String NomEtudiant;
    private String etat;
    private String matiereS;
    public Absence( int matiere, String date, String etat ,int IdEtudiant, String heure ,int classe)  {
       this.matiere = matiere;
       this.timestamp = date;
       this.heure = heure;
       this.etat = etat;
       this.IdEtudiant = IdEtudiant;
       this.classe = classe;
    }
    public Absence(int id, String matiere, String date, String etat ,String IdEtudiant, String heure ,String classe)  {
       this.matiereS = matiere;
       this.timestamp = date;
       this.heure = heure;
       this.etat = etat;
       this.NomEtudiant = IdEtudiant;
       this.classeS = classe;
    }

    public int getClasse() {
        return classe;
    }

    public String getHeure() {
        return heure;
    }

    public String getMatiereS() {
        return matiereS;
    }

    
   /* public Absence(int id, String matiere, Timestamp date, String Etat, int IdEtudiant) {
        this.id = id;
        this.matiere = matiere;
        this.timestamp = date;
        this.IdEtudiant = IdEtudiant;
        this.etat = Etat;
    }

    public Absence(String matiere, Timestamp date, String Etat, int IdEtudiant) {
        this.matiere = matiere;
        this.timestamp = date;
        this.IdEtudiant = IdEtudiant;
        this.etat = Etat;
    }

    public Absence(int id,String matiere, Timestamp timestamp, String NomEtudiant, String etat) {
        this.id = id;
        this.matiere = matiere;
        this.timestamp = timestamp;
        this.NomEtudiant = NomEtudiant;
        this.etat = etat;
    }
    
    
    
    public Absence(int id, String matiere, String DateTime, String etat, int Idetudiant) {
        this.id = id;
        this.matiere = matiere;
        try{
            Date dateTime= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(DateTime);
            long dateL = dateTime.getTime();
            timestamp = new Timestamp(dateL);
         } catch(ParseException e) {
             e.printStackTrace();
        }
        this.etat = etat;
        this.IdEtudiant = Idetudiant;
    }
*/
    public int getIdEtudiant() {
        return IdEtudiant;
    }
    
      public String getIdEtudiantS() {
        return NomEtudiant;
    }
    
    public String getIdS() {
        return Integer.toString(id);
    }
    
    public int getId() {
        return id;
    }

    public int getMatiere() {
        return matiere;
    }

    public String getDate() {
        return timestamp.toString();
    }
    
    
    public String getetat(){
       return etat;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public void setMatiere(int matiere) {
        this.matiere = matiere;
    }

    public void setDate(String date) {
        this.timestamp = date;
    }

    public void setIdEtudiant(int IdEtudiant) {
        this.IdEtudiant = IdEtudiant;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {

       String result = "Absence{" + "id=" + id + ", matiere=" + matiere + ", date=" + timestamp  ;
       
       return result +",Etat="+ etat+  " , Etudiant="+NomEtudiant+", heure="+heure+"}";
    }
    
    public String afficherAbsEtu(){
        String Etat ;
       String result = "Absence{" + "matiere=" + matiere + ", date=" + timestamp ;
      
       
       return result +",Etat="+ etat +"} ";
    }

    
    
    
}

 