package com.mycompany.batalhanaval;

public enum Direcao {
    NORTE(-1), SUL(1), LESTE(1), OESTE(-1), VAZIO(0);
    private final int d;
    
    Direcao(int d){ this.d = d;}

    public int getD() {
        return d;
    }

    
    
}
