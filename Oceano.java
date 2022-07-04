/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
/**
 *
 * @author rurineco
 */
public class Oceano extends JPanel {
    private String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private GridBagLayout grid;
    private GridBagConstraints constraints;
    private Tabuleiro tab;
    private JButton casas[][];
    private ActionListener ButtonListener;
    private boolean vez;

    
    public Oceano(boolean vez, Tabuleiro tab){
        grid = new GridBagLayout();
        constraints = new GridBagConstraints();
        this.setLayout(grid);
        this.vez = vez;
        this.tab = tab;
        
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent ke){
                cheatmode();
            }

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                cheatmode();
            }
        
        
        });
        ButtonListener = (ActionEvent e) -> {
            int xCoord =   Character.getNumericValue(e.getActionCommand().charAt(0));
            int yCoord = Character.getNumericValue(e.getActionCommand().charAt(1));    
            tirodado(IJogador.atirar(xCoord, yCoord, tab));
            cor(xCoord, yCoord);
        };
    
        for (int i = 0; i < tab.getX(); i++){
            for (int j = 0; j < tab.getY(); j++){
                constraints.gridx = i + 1;
                constraints.gridy = j + 1;
                casas[i][j] = new JButton();
                casas[i][j].setEnabled(true);
                casas[i][j].setPreferredSize(new Dimension(60, 60));
                casas[i][j].setBorder(BorderFactory.createEtchedBorder(0));
                casas[i][j].addActionListener(ButtonListener);
                casas[i][j].setActionCommand(String.valueOf(i) + String.valueOf(j));
                cor(i, j);
                this.add(casas[i][j], constraints);
            }
        }
    }
    
    private void tirodado(boolean certo){
        if (certo){
            JLabel texto = new JLabel("Você acertou o tiro! :D");
        }
        else{
            JLabel texto = new JLabel("Você errou o tiro... :(");
        }
    }
    
    private void cor(int i, int j){
        StatusQ status = tab.getCasa(i, j).getStatus();
        switch (status) {
            case VAZIO -> casas[i][j].setBackground(Color.CYAN);
            case ERRADO -> casas[i][j].setBackground(Color.RED);
            case AFUNDADO -> casas[i][j].setBackground(Color.BLACK);
            case NAVIO -> {
                if (vez){
                    casas[i][j].setBackground(Color.GRAY);
                    break;
                }
                else{
                    casas[i][j].setBackground(Color.CYAN);
                }
            }
            default -> {
            }
        }
    
    }
    
    private void cheatmode(){
        vez = !vez;
    }
}
