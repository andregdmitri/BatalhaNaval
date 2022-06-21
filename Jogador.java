package com.mycompany.batalhanaval;

import java.util.ArrayList;

public class Jogador{
        private boolean vivo; 
        private final ArrayList<Navio> navios; 
        

    public boolean isVivo() {
        return vivo;
    }

    public Jogador(){
            vivo = true;
            navios = new ArrayList();
        }
        
    public void verificarvida(){
        for(Navio i : navios){
            if(!i.VerificarAfundado()){
                break;
            }
        }
        vivo = false;
    }
        
    public void atirar(int x, int y, Tabuleiro tab){
        tab.getCasa(x, y).Alvo();
    }
        
        
      
	


	
}