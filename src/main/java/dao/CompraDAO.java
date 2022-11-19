/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Cliente;
import static dao.ClienteDAO.login;
import static dao.ClienteDAO.senha;
import static dao.ClienteDAO.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chagas
 */
public class CompraDAO {
    public void Adicionar(Cliente cliente){
      
     Connection conexao = null;
     String sql = "INSERT INTO cadastro_cliente(CPF, nome, endereco, email, sexo, fone, estado_civil, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
          PreparedStatement comandoSQL = conexao.prepareStatement(sql);
          comandoSQL.setString(1, cliente.getCpf());
          comandoSQL.setString(2, cliente.getNome());
          comandoSQL.setString(3, cliente.getEndereco());
          comandoSQL.setString(4, cliente.getEmail());
          comandoSQL.setString(5, cliente.getSexo());
          comandoSQL.setString(6, cliente.getFone());
          comandoSQL.setString(7, cliente.getEstado_civil());
          comandoSQL.setString(8, cliente.getData_nascimento());
          comandoSQL.execute();
     } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
     }
      
 }
    public static boolean deletar(String cpf){
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            conexao = DriverManager.getConnection(url, login, senha);
            
          
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM cadastro_cliente WHERE cpf = ?; ");
            
            comandoSQL.setString(1, cpf);
            
            
           
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
                
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
    public static boolean editar(Cliente obj){
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("UPDATE cadastro_cliente SET nome=?, endereco=?, email=?, sexo=?, fone=?, estado_civil=?, data_nascimento=? WHERE cpf =?; ");
            
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getEndereco());
            comandoSQL.setString(3, obj.getEmail());
            comandoSQL.setString(4, obj.getSexo());
            comandoSQL.setString(5, obj.getFone());
            comandoSQL.setString(6, obj.getEstado_civil());
            comandoSQL.setString(7, obj.getData_nascimento());
            comandoSQL.setString(8, obj.getCpf());
            
            
            comandoSQL.execute();
                
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
    
}
