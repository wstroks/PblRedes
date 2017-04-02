/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpbl2;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Pagotto
 */
public class Controller {
      
       private PalavraBD p;//objeto que ira lista as palavras
       private ArrayList<Palavra> listPalavra;
       private ArrayList<Palavra> list;
       
       public Controller(){
           p= new PalavraBD();
           listPalavra= new ArrayList<Palavra>();
           list= new ArrayList<Palavra>();;
       }
       
       /*
       Sorteio da palavra como, cada rodada necessita um nivel de dificuldade colocamos um id
       na tabela Palavra no BD, pra saber qual palavra é de cada rodada... Sendo assim, na primeira rodada 
       o numero de letras é 5 , na segunda é 7, na terceira é 10 e na ultima rodada é 12.
       o método Collections.Shurffle desordena a lista assim alternando as posiçoes da lista fazendo que a cada 
       rodada  senha sorteado uma palavra aleatorio
       */
       public Palavra sort(int x) throws SQLException{
          String a=null;
          Palavra g = null;
          Palavra u=null;
          listPalavra=p.listar(x);
          
          Collections.shuffle ( listPalavra );
                    
          g= (listPalavra.get(0));// como as posiçoes da lista vão está sempre mudadas então escolhemos uma posição fixa para o return
                                
           return g;
       }

      
}
