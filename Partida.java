/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author rurineco
 */
public class Partida extends Oceano{
    private boolean vez;
    private JLabel textovez;
    private JFrame mostrartexto = new JFrame();
    private ActionListener ButtonListener;

    
    public Partida(boolean vez, Tabuleiro tab){
        super(tab);
        this.vez = vez;
        this.emuso = true;
        ativarbotoes(vez);
        atualizar();
        ButtonListener = (ActionEvent e) -> {
            int xCoord = Character.getNumericValue(e.getActionCommand().charAt(0));
            int yCoord = Character.getNumericValue(e.getActionCommand().charAt(1)); 
            if (tab.getCasa(xCoord, yCoord).getStatus() != StatusQ.AFUNDADO && tab.getCasa(xCoord, yCoord).getStatus() != StatusQ.ERRADO){
                tirodado(tab.getCasa(xCoord, yCoord).Alvo());
                cor(xCoord, yCoord);
                ativarbotoes(false);
                emuso = false;
            }
        };
        for (int i = 0; i < tab.getX(); i++){
            for (int j = 0; j < tab.getY(); j++){
                    casas[i][j].addActionListener(ButtonListener); 
        } }
        constraints.gridx = 5;
        constraints.gridy = tab.getY() + 1;
        constraints.gridwidth = 3;
        constraints.ipady = 18;
        if (vez){
            textovez = new JLabel("Sua vez!");
        }
        else{
            textovez = new JLabel("Vez do adversário");
        }
        oceano.add(textovez, constraints);
    }
    

    
    public void tirodadooponente(boolean certo){
        atualizar();
        JLabel texto;
        if (certo){
            texto = new JLabel("O oponente acertou o tiro");
        }
        else{
            texto = new JLabel("O oponente errou o tiro");
        }
        mostrartexto.add(texto);
        mostrartexto.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mostrartexto.setSize( 200, 100 ); 
        mostrartexto.setResizable(false);
        mostrartexto.setVisible( true );
        
    }
    
    @Override
    protected void cor(int i, int j){
        super.cor(i,j);
        StatusQ status = tab.getCasa(i, j).getStatus();
        if(status == StatusQ.NAVIO){
            if(!vez){
                casas[i][j].setBackground(Color.GRAY);
            }
            else{
                casas[i][j].setBackground(Color.CYAN);
            }
        }
    
    }
    
    private void tirodado(boolean certo){
        JLabel texto;
        if (certo){
            texto = new JLabel("Você acertou o tiro! :D");
        }
        else{
            texto = new JLabel("Você errou o tiro... :(");
        }
        mostrartexto.add(texto);
        mostrartexto.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mostrartexto.setSize( 200, 100 ); 
        mostrartexto.setResizable(false);
        mostrartexto.setVisible( true );        
    }
    
    @Override
    public void dispose(){
        mostrartexto.dispose();
        super.dispose();
    }
    
}
