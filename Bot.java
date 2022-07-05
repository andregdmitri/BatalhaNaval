/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;
import java.util.Random;
import java.util.*;
/**
 *
 * @author rurineco
 */
public final class Bot extends IJogador {
    private int[] ultimotiro;
    private boolean acertou;
    private Direcao direcao;
    private int c;
    private LinkedList<Direcao> possiveis = new LinkedList<Direcao>();
        
    public Bot(Tabuleiro tab){
        super(tab);
        acertou = false;
        ultimotiro = new int[2];
        nome = "Computador";
        direcao = Direcao.VAZIO;
        c = 0;
        possiveis.addAll(Arrays.asList(Arrays.copyOfRange(Direcao.values(), 0, 4)));
        posicionarNavios();
    }
    
    public boolean atirar(Tabuleiro oTab){
        Direcao novaDirecao;
        int x;
        int y;
        if(c >= 5 || possiveis.isEmpty()){
            c = 0;
            acertou = false;
            direcao = Direcao.VAZIO;
            possiveis.addAll(Arrays.asList(Arrays.copyOfRange(Direcao.values(), 0, 4)));
            return atirar(oTab);
        }
        if (!acertou){
            do{            
                x = rand.nextInt(oTab.getX());
                y = rand.nextInt(oTab.getY());}
            while(!oTab.podeAtirar(x, y));
            if(oTab.getCasa(x, y).Alvo()){
                acertou = true;
                ultimotiro[0] = x;
                ultimotiro[1] = y;
                return true;
            }
            return false;
        }
        if(direcao == Direcao.VAZIO){
            do{
                novaDirecao = possiveis.get(rand.nextInt(possiveis.size()));
                x = ultimotiro[0]+novaDirecao.getX();
                y = ultimotiro[1]+novaDirecao.getY();
            }while((x < 0 || x >= tab.getX() || y < 0 || y >= tab.getY()) && ((oTab.getCasa(x, y).getStatus() != StatusQ.ERRADO) || oTab.getCasa(x,y).getStatus() != StatusQ.AFUNDADO));

            if(oTab.getCasa(x, y).Alvo()){
                direcao = novaDirecao;
                c++;
                ultimotiro[0] = x;
                ultimotiro[1] = y;
                return true;
            }
            else{
                possiveis.remove(novaDirecao);
                return false;
            }
        }
        x = ultimotiro[0] + direcao.getX();
        y = ultimotiro[1] + direcao.getY();
        if (oTab.getCasa(x, y).Alvo()){
            c++;
            ultimotiro[0] = x;
            ultimotiro[1] = y;
            return true;
        }
        c = 0;
        direcao = Direcao.VAZIO;
        acertou = false;
        possiveis.addAll(Arrays.asList(Arrays.copyOfRange(Direcao.values(), 0, 4)));
        return false;           
    }  
    

}
