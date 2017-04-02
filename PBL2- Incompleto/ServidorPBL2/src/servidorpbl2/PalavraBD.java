/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpbl2;

import servidorpbl2.Cliente;
import servidorpbl2.Palavra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import static java.util.Spliterators.iterator;
import static java.util.Spliterators.iterator;
import static java.util.Spliterators.iterator;
import static java.util.Spliterators.iterator;

/**
 *
 * @author Pagotto
 */
public class PalavraBD {
    
   
     /*
    Como a Campo  a tabela Palavra já estará presente no banco de dados, e o servidor só será necessario 
    fazer um consulta atraves do seu id para saber qual rodada deseja.. O banco já estará alimentado 
    */
   public ArrayList<Palavra> listar(int id) throws SQLException{
			StringBuilder sql= new StringBuilder();
			sql.append("SELECT Palavra, Tema, Id ");//SQL
			sql.append("FROM Palavra WHERE Id ="+id);//SQL procura por id da tabela 1,2,3,4		
				
			
			Connection conexao= BdConexao.conectar();//conexao
			PreparedStatement comando= conexao.prepareStatement(sql.toString());
			
			ResultSet resultado=comando.executeQuery();
			
			ArrayList<Palavra> l= new ArrayList<Palavra>();
			
			while(resultado.next()){// o resultado é uma lista com todos os resultados do banco e assim percorre 
				
				
				Palavra p= new Palavra();
				
				p.setPalavra(resultado.getString("Palavra"));
				p.setTema(resultado.getString("Tema"));
				p.setId(resultado.getInt("Id"));
				
				l.add(p);
			}
			
			
			return l;
			
		}
   
}
