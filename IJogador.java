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
    protected String nome;
    
    public IJogador(Tabuleiro tab){
        vivo = true;
        navios = new ArrayList();
        this.tab = tab;
        this.navios.add(new Navio(TipoNavio.PORTAAVIOES));
        this.navios.add(new Navio(TipoNavio.NAVIOTANQUE));
        this.navios.add(new Navio(TipoNavio.NAVIOTANQUE));
        this.navios.add(new Navio(TipoNavio.PORTAAVIOES));
        this.navios.add(new Navio(TipoNavio.PORTAAVIOES));
        this.navios.add(new Navio(TipoNavio.PORTAAVIOES));
        this.navios.add(new Navio(TipoNavio.SUBMARINO));
        this.navios.add(new Navio(TipoNavio.SUBMARINO));
        this.navios.add(new Navio(TipoNavio.SUBMARINO));
        this.navios.add(new Navio(TipoNavio.SUBMARINO));
    }
    
    
    public boolean isVivo() {
        return vivo;
    }
        
    public boolean verificarvida(){
        for(Navio i : navios){
            if(!i.verificarAfundado()){
                return true;
            }
        }
        vivo = false;
        return false;
    }
    
    public Tabuleiro getTab() {
        return tab;
    }
    
    public ArrayList<Navio> getNavios(){
        return navios;
    }
    
    public static boolean atirar(int x, int y, Tabuleiro tab){
        return tab.getCasa(x, y).Alvo();
    }
    
    public void posicionarNavio(int x, int y, Navio navio, Direcao direcao){
        navio.criarNavio(x, y, direcao, tab);
    
    }
}
