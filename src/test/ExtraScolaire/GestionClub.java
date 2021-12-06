
package Test.ExtraScolaire;

import Entities.ExtraScolaire.*;

import Services.ExtraScolaire.ServiceClub;
import Utils.DataBase;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class GestionClub {
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
       
        Services.ExtraScolaire.ServiceClub sc = new ServiceClub();

        Club c = new Club("eeeee","aaaaaaaa") ;
        
        //sc.ajouterClub(c);
        //sc.supprimerEvent(c);
        //sc.modifierEvent(c);
      
      }
         //sv.modifierEvent(e);
        
        // sv.afficherListEvent();
        
         //sc.ajouterClub(c);
         //sc.ajouterClub(c1);
         //sc.ajouterClub(c2);
         
        // sc.modifierClub(c1);
         //sc.supprimerClub(c1);
        // sc.afficherListClub();
         
         
         
        
    }
    

