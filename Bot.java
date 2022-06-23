/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;
import java.util.Random;

/**
 *
 * @author rurineco
 */
public class Bot extends IJogador {
    private int[] ultimotiro;
    private boolean acertou;
    private Direcao direcao;
    private final Random rand = new Random();
    private int c;
        
    public Bot(Tabuleiro tab){
        super(tab);
        acertou = false;
        direcao = Direcao.VAZIO;
        c = 0;
    }
    
    
    @Override
    public void atirar(int x, int y, IJogador Oponente){
        Tabuleiro oTab = Oponente.getTab();
        Direcao novaDirecao;
        if (!acertou){
            x = rand.nextInt(oTab.getX());
            y = oTab.getY();
            super.atirar(x, y, Oponente);
            if (oTab.getCasa(x, y).getStatus() == StatusQ.AFUNDADO){
                acertou = true;
                ultimotiro[0] = x;
                ultimotiro[1] = y;
            }
        }
        else{
            if(direcao == Direcao.VAZIO){
                novaDirecao = Direcao.values()[rand.nextInt(4)];
                x = ultimotiro[0]+novaDirecao.getX();
                y = novaDirecao.getY();
                super.atirar(x, y, Oponente);
                if(oTab.getCasa(x, y).getStatus() == StatusQ.AFUNDADO){
                    direcao = novaDirecao;
                    c++;
                    ultimotiro[0] = x;
                    ultimotiro[1] = y;
                }
                else{
                    direcao = Direcao.VAZIO;
                    
                }
            }
            else{
                if (c >= 5){
                    c = 0;
                    acertou = false;
                   
                }
            
            }
        }
        
        
    }
  
    
    
    
    
}
