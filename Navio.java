package com.mycompany.batalhanaval;


public class Navio{
	private boolean navioAfundado;
	private int comprimento;
	private int posicaoX;
	private int posicaoY;
        private TipoNavio tipo; 
        
        enum TipoNavio{}

	public Navio(int x, int y){
		navioAfundado = false;
		this.posicaoX = x;
		this.posicaoY = y;
		
	}
	
}