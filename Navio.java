package com.mycompany.batalhanaval;


public class Navio{
	private boolean navioAfundado;
	private int comprimento;
	private int posicaoX;
	private int posicaoY;
  private TipoNavio tipo; 
        
	enum TipoNavio{
    NAVIOTANQUE(4), 
		PORTAAVIOES(5),
		SUBMARINO(3),
		CONTRATORPEDOS(2);
		
		private final int c;
		TipoNavio(int c){ this.c = c;      }
    private int comprimento() {return c; }
    
	}

	public Navio(int x, int y, TipoNavio tipo){
		navioAfundado = false;
		this.posicaoX = x;
		this.posicaoY = y;
  	this.comprimento = tipo.comprimento();
                    
	}
	
}