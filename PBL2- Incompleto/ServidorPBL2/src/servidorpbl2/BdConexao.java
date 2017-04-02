/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpbl2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pagotto
 */
public class BdConexao {
        
        /*
         Os metodos static são para a conexão com o bando de dados isso, os metodos static podem
         ser alternado devido a instalação de cada maquina, o bd usamos o MYSQL WORKBENCH..
         foi necessario a importação do jar musql connector
        */
	private static final String USUARIO="root";//usuario padrão do MYSQL
	private static final String SENHA="secret";// Senha que na instalação fez
	private static final String URL="jdbc:mysql://localhost:3306/cliente";
	

	public static Connection conectar() throws SQLException{
		// driver manager conectar oh sql
		
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());//metodo do jar mysql connect
		Connection conexao=DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	/*
	public static void main(String[] args) {
		try{
		Connection conexao=BdConexao.conectar();
		System.out.println("Sucesso na conexão com banco!");
		}catch(SQLException ex){
			ex.printStackTrace();//comando para descobrir o erro quando não acessar o banco
			System.out.println("Conexão não foi bem sucedida!");
			
		}
		
	}*/
        
}
