/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;

/**
 *
 * @author rurineco
 */
public class Quadrado {
    private int x;
    private int y;
    private StatusQ status;

    public Quadrado(int x, int y) {
        this.x = x;
        this.y = y;
        status = StatusQ.VAZIO;
    }
    
    
    
    public void ColocarNavio(){
        if (status == StatusQ.VAZIO){
            status = StatusQ.NAVIO;
        }
    }
    
    public void AfundarNavio(){
        if (status == StatusQ.NAVIO){
            status = StatusQ.AFUNDADO;
        }
    }
    
    public StatusQ getStatus(){ return status; }
}
