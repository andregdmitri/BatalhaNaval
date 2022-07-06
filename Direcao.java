package com.mycompany.batalhanaval;

public enum Direcao {
    NORTE(0, -1), SUL(0, 1), LESTE(1, 0), OESTE(-1, 0), VAZIO(0, 0);
    private final int x;
    private final int y;
    
    Direcao(int x, int y){ this.x = x; this.y = y;}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
