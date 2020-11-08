/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joao-
 */
public class DaoEstoque {
    
    private ArrayList<Estoque> lista = new ArrayList<>();
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Statement st;
    
    public DaoEstoque(){
        con = new ConnectionFactory().getConexao();
    }
    
    
    public void insert (Estoque est){
        
        
        String sql = "INSERT INTO eletro(nome,quantidade,fornecedor) VALUES (?,?,?)" ;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, est.getNome());
            stmt.setString(2, est.getFornecedor());
            stmt.setString(3, est.getQuantidade());
            stmt.execute();
            con.close();
            
        }catch(SQLException ex2){
            throw new RuntimeException("ERRO:" + ex2);
            
        }
        
        
    } public void delete (Estoque est){
        
        String sql = "DELETE FROM eletro WHERE nome=?";
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, est.getNome());
            stmt.execute();
            con.close();
                    } catch (SQLException ex3){
            throw new RuntimeException("ERRO:" + ex3);
                      
        }
        
    } 
    
   /* public void alterar (Estoque est){
        
        String sql = "UPDATE eletro SET nome=?, fornecedor=?, quantidade=? WHERE id=?";
               
        
        try{ 
            stmt = con.prepareStatement(sql);
            stmt.setString(1, est.getNome());
            stmt.setString(2, est.getFornecedor());
            stmt.setString(3, est.getQuantidade());
            stmt.setInt(4, est.getId());
                        stmt.execute();
            con.close();
            
        }  catch(SQLException ex4){
            throw new RuntimeException("ERRO:" + ex4);
            
        }
    }
     */   
    
    
    public ArrayList<Estoque> Listartodos(){
        
        String sql = "SELECT * FROM eletro";
        
        try{ 
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                Estoque est = new Estoque();
                est.setId(rs.getInt("id"));
                est.setNome(rs.getString("nome"));
                est.setFornecedor(rs.getString("fornecedor"));
                est.setQuantidade(rs.getString("quantidade"));
                lista.add(est);
                }
            
        } catch(SQLException ex5){
            throw new RuntimeException("ERRO:" + ex5);
            
        } return lista;
        
    }
    
    public ArrayList<Estoque> ListarTodosDescri(){
        
        String sql = "SELECT * FROM eletro WHERE nome LIKE '%'+valor+'%'"; 
        
        try{ st = con.createStatement();
             rs = st.executeQuery(sql);
             
             while (rs.next()){
                 Estoque est = new Estoque();
                 
                 est.setId(rs.getInt("id"));
                 est.setNome(rs.getString("nome"));
                 est.setFornecedor(rs.getString("fornecedor"));
                 est.setQuantidade(rs.getString("quantidade"));
                 lista.add(est);
             } 
            
        } catch (SQLException ex6){
            throw new RuntimeException("ERRO:" + ex6);
            
        } return lista;
    }
    
    
}
