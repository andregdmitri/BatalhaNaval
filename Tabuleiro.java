package com.mycompany.batalhanaval;
/* 
Autores: Rui Emanuel Lima Viera - NUSP: 11810182
         André Guarnier de Mitri - NUSP: 11395579
*/

public class Tabuleiro {
    private int x; //Tamanho horizontal do tabuleiro
    private int y; //Tamanho vertical do tabuleiro
    private Quadrado[][] oceano;

    
    
    public boolean podeColocar(int x1, int x2, int y1, int y2){
        int i; int j;
        if (x1 < 0 || x1 > this.x || x2 < 0 || x2 > this.x || 
            y1 < 0 || y1 > this.y || y2 < 0 || y2 > this.y){//Caso os valores colocados estejam fora do tabuleiro
            
            return false;
        }
        for (i = x1; i <= x2; i++){
            for (j = y1; y <= y2; j++){
                if (oceano[i][j].getStatus() != StatusQ.VAZIO){
                    return false;

                }
            }
        }
        return true;
    }
    
    public void colocarNavio(int x1, int x2, int y1, int y2){
        int i; int j;
        if (podeColocar(x1, x2, y1, y2)){
           for (i = x1; i <= x2; i++){
            for (j = y1; y <= y2; j++){
                oceano[i][j].ColocarNavio();
            }
            }
        }
    } 
     
    
    public StatusQ status(int x, int y){
        return oceano[x][y].getStatus();
    }
}
