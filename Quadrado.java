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
    private StatusQ status;


    
    public Quadrado() {
        status = StatusQ.VAZIO;
    }
    
    public boolean Alvo(){
        if (status == StatusQ.VAZIO){
            status = StatusQ.ERRADO;
            return false;
        }
        if (status == StatusQ.NAVIO){
            status = StatusQ.AFUNDADO;
            return true;
        }
        return false;
    }
    
    
    public void navio(){
        status = StatusQ.NAVIO;
    }
    
    
    public StatusQ getStatus(){ return status; }
}
