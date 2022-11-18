/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import classes.Cliente;
import java.sql.PreparedStatement;
import view.TelaCadastrarNovoCliente;


import java.sql.DriverManager;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_FORWARD_ONLY;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaCliente;
/**
 *
 * @author Chagas
 */
public class ClienteDAO {
   public static String url = "jdbc:mysql://localhost:3306/db_senacsports";
   public static String login = "root";
   public static String senha = "";
  
 public void inserir(Cliente cliente){
      
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
     public static Cliente Consultar(String cpf){
            Connection conexao = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            String sql = "SELECT * FROM cadastro_cliente WHERE CPF = ?;";
        
            PreparedStatement comandoSQL = conexao.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            comandoSQL.setString(1, cpf);
            ResultSet rs = comandoSQL.executeQuery();
            Cliente cliente = new Cliente();
            rs.first();
            cliente.setCpf(cpf);
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setEmail(rs.getString("email"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setFone(rs.getString("fone"));
            cliente.setEstado_civil(rs.getString("estado_civil"));
            cliente.setData_nascimento(rs.getString("data_nascimento"));
            return cliente;
        
                
            
            
        } catch (Exception e) {
          
            System.out.println(e.getMessage());
           
            return null;
        }
    }
    public List<Cliente> listar()
        {
           
             String sql = "SELECT * FROM cadastro_cliente";
             Connection conexao = null;
            try {
                
             Class.forName("com.mysql.cj.jdbc.Driver");
             conexao = DriverManager.getConnection(url, login, senha);
             PreparedStatement comandoSQL = conexao.prepareStatement(sql);
           
             ResultSet rs = comandoSQL.executeQuery();
             List<Cliente> listaCadastro_cliente = new ArrayList<>();
            
             //percore o rs e salva as infromaçoes dentro de uma variavel Cliente e dps salva essa variavel dentro da lista
             while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getString("CPF"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setEmail(rs.getString("email"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setFone(rs.getString("fone"));
            cliente.setEstado_civil(rs.getString("estado_civil"));
            cliente.setData_nascimento(rs.getString("data_nascimento"));
            listaCadastro_cliente.add(cliente);
             }
             return listaCadastro_cliente;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
    
}
  

    

