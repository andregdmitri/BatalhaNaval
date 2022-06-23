package com.mycompany.batalhanaval;


class Jogo {
    private static Jogador vez;


/*
    - Implementar alternação de vez
    - Inicialização do jogador - colocar navios (Quantos navios? Quantos de cada?)
    - Bot
    - Tela de finalização
    */
    
    
    
  public static void main(String[] args) {
      int x; int y;
      Tabuleiro T1 = new Tabuleiro(x, y);
      Tabuleiro T2 = new Tabuleiro(x, y);
      Jogador P1 = new Jogador();
      Jogador P2 = new Jogador();
      vez = P1;
      
      
      
      while(P1.isVivo() && P2.isVivo()){
      
      }
      
      
  }
}