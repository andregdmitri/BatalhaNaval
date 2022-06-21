package com.mycompany.batalhanaval;
import java.util.ArrayList;

public class Navio{
	private boolean navioAfundado;
	private int comprimento;
	private int posicaoX;
	private int posicaoY;
<<<<<<< HEAD
        private TipoNavio tipo; 
        private ArrayList<Quadrado> quadrados;
        
        enum TipoNavio{
            NAVIOTANQUE(4), 
            PORTAAVIOES(5), 
            SUBMARINO(3), 
            CONTRATORPEDOS(2);
            private final int c;
            TipoNavio(int c){
                this.c = c;
            }
            private int comprimento() {return c; }
        }

        enum Direcao{
            NORTE, SUL, LESTE, OESTE
        }
        
	public Navio(int x, int y, TipoNavio tipo, Direcao direcao){
		navioAfundado = false;
		this.posicaoX = x;
		this.posicaoY = y;
                this.comprimento = tipo.comprimento();
        }
        private void PosicionarNavio(Direcao direcao){
            int i;
            switch(direcao):
                    case NORTE:
                        colocarNavio(posicaoX, posicaoX, posicaoY, posicaoY + comprimento);
                    case SUL:
                    case OESTE:
                    case LESTE:
        }

    }
                
=======
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
>>>>>>> 573c295abaf9e503bc085cd8bfe1c324d65be88c
