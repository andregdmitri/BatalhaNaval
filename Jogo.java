package com.mycompany.batalhanaval;


class Jogo {
    IJogador jogador;
    IJogador oponente;
    Tabuleiro tab1;
    Tabuleiro tab2;
    
    
    
    public void jogoPrincipal(){
        tab1 = new Tabuleiro (10, 10);
        tab2 = new Tabuleiro (10, 10);
        
        jogador = new Jogador (tab1);
        oponente = new Bot(tab2);
        
        while(jogador.isVivo() && oponente.isVivo()){
            
        }  
    }
    
    
    public void colocarNavios(IJogador jogador){
        
    
    }
    public void atirar(){
    
    }
}