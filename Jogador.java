package com.mycompany.batalhanaval;


public class Jogador extends IJogador{

    
    public Jogador(Tabuleiro tab, String nome){
        super(tab);
        this.nome = nome;
    }


    
    public void posicionarNavio(int x, int y, Navio navio, Direcao direcao){
        navio.criarNavio(x, y, direcao, tab);
    }


        
    


    

    
    
    
    
        
        
      
	


	
}