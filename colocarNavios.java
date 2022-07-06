/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;




/**
 *
 * @author rurineco
 */

//Essa classe é responsável pela tela na qual o usuário posiciona os seus navios no tabuleiro. 
public class colocarNavios extends Oceano{
    private Direcao direcao;
    private ActionListener ButtonListener;
    private int xCoord;
    private int yCoord;
    private Navio navio;
    
    public colocarNavios(Tabuleiro tab, Navio n){
        super(tab);
        super.ativarbotoes(true);
        this.navio = n;
        this.direcao = Direcao.VAZIO;
        ButtonListener = (ActionEvent e) -> {
            atualizar();
            xCoord = Character.getNumericValue(e.getActionCommand().charAt(0));
            yCoord = Character.getNumericValue(e.getActionCommand().charAt(1)); 
            casas[xCoord][yCoord].setBackground(Color.WHITE);
        };
        for (int i = 0; i < tab.getX(); i++){
            for (int j = 0; j < tab.getY(); j++){
                casas[i][j].addActionListener(ButtonListener); 
        } }
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_UP){
                    System.out.println("Setinha pra cima");
                }
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_UP -> {direcao = Direcao.NORTE; direcaoatual(); System.out.println("Setinha pra cima");}
                    case KeyEvent.VK_DOWN -> {direcao = Direcao.SUL; direcaoatual();}
                    case KeyEvent.VK_LEFT -> {direcao = Direcao.OESTE; direcaoatual();}
                    case KeyEvent.VK_RIGHT -> {direcao = Direcao.LESTE; direcaoatual();}
                    case KeyEvent.VK_ENTER -> colocarNavio();
                }
        }});
        
        constraints.gridx = 0;
        constraints.gridy = tab.getY() + 1;
        constraints.gridwidth = 10;
        constraints.ipady = 20;
        JLabel navioatual = new JLabel("Colocando agora: " + n.getTipo().name() + ", de tamanho: " + n.getTipo().comprimento());
        oceano.add(navioatual, constraints);
    }
    
    private void colocarNavio(){
        if (tab.podeColocar(xCoord, yCoord, direcao, navio.getComprimento())){
            navio.criarNavio(xCoord, yCoord, direcao, tab);
            emuso=false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Alerta", "Você não pode colocar esse navio", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void direcaoatual(){
        constraints.gridx = 5;
        constraints.gridy = tab.getY() + 2;
        JLabel direcaoatual = new JLabel("Direção atual: " + direcao.name());
        oceano.add(direcaoatual);
    }
}
