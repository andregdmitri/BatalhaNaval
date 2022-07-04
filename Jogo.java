package com.mycompany.batalhanaval;


class Jogo {
    IJogador jogador;
    IJogador oponente;
    Tabuleiro tab1;
    Tabuleiro tab2;
    
    public Jogo(boolean multiplayer){
        tab1 = new Tabuleiro (10, 10);
        tab2 = new Tabuleiro (10, 10);
        jogador = new Jogador (tab1);

        if (multiplayer){
            oponente = new Jogador(tab2);
        }
        else{
            oponente = new Bot(tab2);
        
        }
    }
    
    public void jogoPrincipal(){

                
        while(jogador.isVivo() && oponente.isVivo()){
            
        }  
    }
    
    
    public void colocarNavios(IJogador jogador){
        
    
    }
    public void atirar(){
    
    }
}