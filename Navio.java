package com.mycompany.batalhanaval;
import java.util.ArrayList;

public class Navio{
	private boolean navioAfundado;
	private int comprimento;
	private int posicaoX;
	private int posicaoY;
        private TipoNavio tipo; 
        private ArrayList<Quadrado> quadrados;
       

    public Navio(int x, int y, TipoNavio tipo, Direcao direcao, Tabuleiro tab){
		navioAfundado = false;
		this.posicaoX = x;
		this.posicaoY = y;
                this.comprimento = tipo.comprimento();
                this.tipo = tipo;
                switch(direcao){
                    case NORTE:
                        this.quadrados = tab.colocarNavio(posicaoX, posicaoX, posicaoY, posicaoY - comprimento);
                    case SUL:
                        this.quadrados = tab.colocarNavio(posicaoX, posicaoX, posicaoY, posicaoY + comprimento);
                    case OESTE:
                        this.quadrados = tab.colocarNavio(posicaoX, posicaoX, posicaoY, posicaoY - comprimento);
                    case LESTE:
                        this.quadrados = tab.colocarNavio(posicaoX, posicaoX, posicaoY, posicaoY + comprimento);
                } 
    } 
    
        public boolean VerificarAfundado (){
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

}
    