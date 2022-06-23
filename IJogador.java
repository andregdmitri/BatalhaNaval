package com.mycompany.batalhanaval;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rurineco
 */
abstract public class IJogador {
    protected Tabuleiro tab;
    protected boolean vivo; 
    protected ArrayList<Navio> navios; 
    
    public IJogador(Tabuleiro tab){
        vivo = true;
        navios = new ArrayList();
        this.tab = tab;
    }
    
    
    public boolean isVivo() {
        return vivo;
    }
        
    public boolean verificarvida(){
        for(Navio i : navios){
            if(!i.VerificarAfundado()){
                return true;
            }
        }
        vivo = false;
        return false;
    }
    
    public Tabuleiro getTab() {
        return tab;
    }
    
    public void adicionarNavio(Navio navio){
        this.navios.add(navio);
    }
}
