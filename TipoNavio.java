package com.mycompany.batalhanaval;


public enum TipoNavio {
    PORTAAVIOES(5), NAVIOTANQUE(4), CONTRATORPEDOS(3), SUBMARINO(2);
    private final int c;
    
    TipoNavio(int c){ this.c = c; }
    public int comprimento() { return c; }
}


