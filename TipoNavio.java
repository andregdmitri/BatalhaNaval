package com.mycompany.batalhanaval;

//Responsável por determinar qual o tipo do navio, seguindo o especificado no enunciado do trabalho.
public enum TipoNavio {
    PORTAAVIOES(5), NAVIOTANQUE(4), CONTRATORPEDOS(3), SUBMARINO(2);
    private final int c;
    
    TipoNavio(int c){ this.c = c; }
    public int comprimento() { return c; }
}


