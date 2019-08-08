/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno2;

public class DaoAluno2 {
    
     public static boolean excluir(Aluno2 objeto) {
        String sql = "DELETE FROM aluno2 WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    
     public static boolean alterar(Aluno2 objeto) {
        String sql = "UPDATE aluno2 SET nome = ?, sobrenome = ?, sexo = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getSobrenome());
            ps.setString(3, objeto.getSexo());
            ps.setInt(4, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
 public static boolean inserir(Aluno2 objeto) {
        String sql = "INSERT INTO aluno2 (nome, sobrenome, sexo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getSobrenome());
            ps.setString(3, objeto.getSexo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
  public static void main(String[] args) {
        Aluno2 objeto = new Aluno2();
        objeto.setNome("Jorge");
        objeto.setSobrenome("da Silva");
        objeto.setSexo("cabra macho");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
