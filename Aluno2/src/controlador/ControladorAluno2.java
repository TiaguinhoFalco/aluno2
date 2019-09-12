/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoAluno2;
import javax.swing.JOptionPane;
import modelo.Aluno2;
import tela.manutencao.ManutencaoAluno2;

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorAluno2 {
    
    public static void alterar(ManutencaoAluno2 man){
        Aluno2 objeto = new Aluno2();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setSobrenome(man.jtfSobrenome.getText());
        objeto.setSexo(man.jtfSexo.getText());
        
        boolean resultado = DaoAluno2.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }


        public static void inserir(ManutencaoAluno2 man){
        Aluno2 objeto = new Aluno2();
        objeto.setNome(man.jtfNome.getText());
        objeto.setSobrenome(man.jtfSobrenome.getText());
        objeto.setSexo(man.jtfSexo.getText());
        
        boolean resultado = DaoAluno2.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
        
        
         public static void excluir(ManutencaoAluno2 man){
        Aluno2 objeto = new Aluno2();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        
        boolean resultado = DaoAluno2.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    
         public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Sobrenome");
        modelo.addColumn("Sexo");
        List<Aluno2> resultados = DaoAluno2.consultar();
        for (Aluno2 objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getSobrenome());
            linha.add(objeto.getSexo());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }

    

    
    }
    
    

