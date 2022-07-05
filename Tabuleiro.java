/* 
Autores: Rui Emanuel Lima Viera - NUSP: 11810182
         André Guarnier de Mitri - NUSP: 11395579
*/
package com.mycompany.batalhanaval;

import java.util.ArrayList;

public class Tabuleiro {
    private final int x; //Tamanho horizontal do tabuleiro
    private final int y; //Tamanho vertical do tabuleiro
    private Quadrado[][] oceano;

    public Tabuleiro(int x, int y){
        this.x = x;
        this.y = y;
        oceano = new Quadrado[x][y];
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                oceano[i][j] = new Quadrado();
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean podeAtirar(int x, int y){
        return oceano[x][y].getStatus() == StatusQ.NAVIO || oceano[x][y].getStatus() == StatusQ.VAZIO;
    }
    
    public String getCasaString(int x, int y){
        return getCasa(x, y).getStatus().name();
    
    }
    
    public boolean podeColocar(int x, int y, Direcao direcao, int comprimento){
        switch(direcao){
            case NORTE, SUL -> {
                int y2 =  (direcao.getD() * comprimento) - 1;
                if (y2 >= this.y || y2 < 0){
                    return false;
                }
                for(int j = y; j != y2; j=j+direcao.getD()){
                    try{
                        if (oceano[x][j].getStatus() != StatusQ.VAZIO){
                            return false;
                        }
                    } catch(ArrayIndexOutOfBoundsException e){
                        return false;
                    }
                    
                }
            }
 case OESTE, LESTE -> {
     int x2 = (direcao.getD() * comprimento) - 1;
     if (x2 >= this.x || x2 < 0 ){
         return false;
     }
     for(int i = x; i != x2; i=i+direcao.getD()){
         try{
             if (oceano[i][y].getStatus() != StatusQ.VAZIO){
                 return false;
             }
         }catch(ArrayIndexOutOfBoundsException e){
             return false;
         }
     }
            }
        }
        return true;
    }
    
    
    public ArrayList<Quadrado> colocarNavio(int x, int y, Direcao direcao, int comprimento ){
        ArrayList<Quadrado> Navio;
        Navio = new ArrayList();
        if (podeColocar(x, y, direcao, comprimento)){
            switch(direcao){
                case NORTE, SUL->{
                    int y2 =  (direcao.getD() * comprimento) - 1;
                    for(int j = y; j != y2; j=j+direcao.getD()){
                        oceano[x][j].navio();
                        Navio.add(oceano[x][j]);
                    }
                }
                case OESTE, LESTE->{
                    int x2 = (direcao.getD() * comprimento) - 1;
                    for(int i = x; i != x2; i=i+direcao.getD()){
                        oceano[i][y].navio();
                        Navio.add(oceano[i][y]);
                    }
                }
            }
        }
        return Navio;
    } 
     
    
    public Quadrado getCasa(int x, int y){
        return oceano[x][y];
    }
}
