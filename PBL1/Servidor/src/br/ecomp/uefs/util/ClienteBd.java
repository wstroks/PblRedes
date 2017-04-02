/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ecomp.uefs.util;

import br.ecomp.uefs.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pagotto
 */
public class ClienteBd {

   
    /*
    O BANCO de dados do Cliente será composto por dois campos Nome e Pontuação do mesmo....
    Como só será necessario fazer o cadastro do mesmo e a listagem para exibir na tela o nome e as maiores pontuações
    */
    public void cadastrarCliente(Cliente c) throws SQLException {
                StringBuilder sql = new StringBuilder();//leitor utilizado para pegar o SQL do insert
                sql.append("INSERT INTO jogador "); //nome da tabela se chama Jogador

                sql.append("(Nome, Pontuacao) ");// Atributos
                sql.append("VALUES (?, ?) ");

                Connection conexao = BdConexao.conectar();// CONEXAO com bd
                PreparedStatement comando = conexao.prepareStatement(sql.toString());// enviando o SQL

     
                comando.setString(1, c.getNome());// executando os atributos, Ressaltar que se mudar a ordem tem que altera a numeração
                comando.setInt(2, c.getPontuacao());
     
                comando.executeUpdate();// Enviando os dados pro BD
    }

   
   /*
    Listando todos os jogadores de maneira decrescente.. ou seja, sempre o primeiro da lista será o maior
    pontuador e assim por diante...
    */
    public ArrayList<Cliente> listarC() throws SQLException{
                 StringBuilder sql= new StringBuilder();
	         sql.append("SELECT Pontuacao, Nome ");
	         sql.append("FROM jogador ");	
                 sql.append("ORDER BY Pontuacao DESC LIMIT 3");// Ordena o BD de maneira decrescente 
				
			
                 Connection conexao= BdConexao.conectar();
	         PreparedStatement comando= conexao.prepareStatement(sql.toString());
			
	         ResultSet resultado=comando.executeQuery();
			
	         ArrayList<Cliente> l= new ArrayList<Cliente>();
			
			while(resultado.next()){
				
				
				Cliente p= new Cliente();
				
				p.setNome(resultado.getString("Nome"));
				p.setPontuacao(resultado.getInt("Pontuacao"));
				
				
				l.add(p);
			}
			
			
			return l;
			
		}
        
   
}
