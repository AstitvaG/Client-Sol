package db;

import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class DBConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement AddClient,GetClient;

    static{
        try{
            
        Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/client_sol_db","root","gail2790");
            st = c.createStatement();
           AddClient= c.prepareStatement("insert into client_info (name,gender,dob,country,address,languages) values (?,?,?,?,?,?)");
           GetClient= c.prepareStatement("select * from client_info where name like ?");
           try{TimeUnit.SECONDS.sleep(1);}catch(Exception ex){System.out.println(ex);}

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Invalid Credentials !");
        }
        }
    static public void dbClose(){
         try{
            c.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    }
