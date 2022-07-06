package com.mycompany.batalhanaval;
import java.util.ArrayList;

public class Navio{
	private boolean navioAfundado;
	private int posicaoX;
	private int posicaoY;
        private final TipoNavio tipo; 
        private ArrayList<Quadrado> quadrados;
       
        
    public Navio(TipoNavio tipo){
		navioAfundado = false;
                this.tipo = tipo;
                quadrados = new ArrayList();
    }

    public int getComprimento() {
        return tipo.comprimento();
    }
    
    
    
    public boolean verificarPosicionamento(){
        return !quadrados.isEmpty();
    
    }

    @Override
    public String toString() {
        return "Navio{" + "tipo = " + tipo + ", começa em x = " + posicaoX + " e y em = " + posicaoY;
    }
    
    
    
    public void criarNavio(int x, int y, Direcao direcao, Tabuleiro tab){
        this.posicaoX = x;
        this.posicaoY = y;
        this.quadrados = tab.colocarNavio(posicaoX, posicaoY, direcao, tipo.comprimento());
    }
    
    public boolean verificarAfundado (){
        if (this.navioAfundado){
            return true;
        }
        for (Quadrado i : quadrados){
            if (i.getStatus() == StatusQ.NAVIO){
               return false;
            }
        }
            navioAfundado = true;
            return true;
        }

    public TipoNavio getTipo() {
        return tipo;
    }
    
    
}
    