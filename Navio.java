package com.mycompany.batalhanaval;


public abstract class Navio{
	protected boolean navioAfundado;
	protected int comprimento;
	protected int posicaoX;
	protected int posicaoY;

	public Navio(int x, int y){
		navioAfundado = false;
		this.posicaoX = x;
		this.posicaoY = y;
		
	}
	
}