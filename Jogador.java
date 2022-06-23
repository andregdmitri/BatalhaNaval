package com.mycompany.batalhanaval;


public class Jogador extends IJogador{

    
    public Jogador(Tabuleiro tab){
        super(tab);
    }
        
    public void atirar(int x, int y, IJogador oponente){
        oponente.getTab().getCasa(x, y).Alvo();
    }

    

    
    
    
    
        
        
      
	


	
}