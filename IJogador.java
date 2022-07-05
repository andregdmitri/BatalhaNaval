package com.mycompany.batalhanaval;

import java.util.ArrayList;
import java.util.Random;

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
    protected final Random rand = new Random();
    protected ArrayList<Navio> navios; 
    protected String nome;
    
    public IJogador(Tabuleiro tab){
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
        for(Navio i : navios){
            if(!i.verificarAfundado()){
                return true;
            }
        }
        return false;    
    }
    
    public Tabuleiro getTab() {
        return tab;
    }
    
    public ArrayList<Navio> getNavios(){
        return navios;
    }

    public String getNome() {
        return nome;
    }
     
    public void posicionarNavios(){
        for(Navio i : navios){
            posicionarNavio(i);
        }
    }
    
    public void posicionarNavio(Navio navio){
        Direcao ndirecao;
        int x;
        int y;
        
        do{
            ndirecao = (Direcao.values())[rand.nextInt(4)];
            x = rand.nextInt(tab.getX());
            y = rand.nextInt(tab.getY());
        }
        while(!tab.podeColocar(x, y, ndirecao, navio.getComprimento())); 
        
        navio.criarNavio(x, y, ndirecao, tab);
    }
    
}
