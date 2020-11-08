/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
public Connection getConexao(){
     try{
         
         Class.forName("org.postgresql.Driver");
     String url = "jdbc:postgresql://localhost:5432/eletronicos";
     String usuario = "postgres";
     String senha = "root";
   
        
     
     return DriverManager.getConnection(url, usuario, senha);

     
     } catch (SQLException e){
         System.out.println("Não funcionou");
         throw new RuntimeException(e);
     }    catch (ClassNotFoundException ex){
         throw new RuntimeException(ex);
     }
    }
}

    

