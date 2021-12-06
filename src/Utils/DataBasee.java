/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBasee {
    String url = "jdbc:mysql://localhost:3306/edutech";
     String login = "root";
     String pwd = "";
    public  static DataBasee db;
    public Connection con;
    private DataBasee() {
        try {
            con=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static DataBasee getInstance()
    {if(db==null)
        db=new DataBasee();
    return db;
    }
}
