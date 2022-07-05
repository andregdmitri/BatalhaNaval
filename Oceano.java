/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;
import java.awt.BorderLayout;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit
/**
 *
 * @author rurineco
 */
public class Oceano extends JFrame {
    private final String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private GridBagLayout grid;
    private GridBagConstraints constraints;
    private Tabuleiro tab;
    private JButton casas[][];
    private ActionListener ButtonListener;
    private boolean vez;
    private JLabel textovez;

    
    public Oceano(boolean vez, Tabuleiro tab){
        this.setSize(680, 800);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        JPanel oceano = new JPanel(new FlowLayout(FlowLayout.LEFT));
        oceano.setPreferredSize(new Dimension(650, 750));
        grid = new GridBagLayout();
        constraints = new GridBagConstraints();
        oceano.setLayout(grid);
        this.vez = vez;
        this.tab = tab;
        casas = new JButton[tab.getX()][tab.getY()];
        ButtonListener = (ActionEvent e) -> {
            int xCoord = Character.getNumericValue(e.getActionCommand().charAt(0));
            int yCoord = Character.getNumericValue(e.getActionCommand().charAt(1)); 
            tirodado(tab.getCasa(xCoord, yCoord).Alvo());
            cor(xCoord, yCoord);
            desativarbotoes();
        };
        for (int i = 0; i < tab.getX(); i++){
            for (int j = 0; j < tab.getY(); j++){
                constraints.gridx = i + 1;
                constraints.gridy = j + 1;
                casas[i][j] = new JButton();
                casas[i][j].setEnabled(vez);
                casas[i][j].setPreferredSize(new Dimension(60, 60));
                casas[i][j].setBorder(BorderFactory.createEtchedBorder(0));
                casas[i][j].addActionListener(ButtonListener);
                casas[i][j].setActionCommand(String.valueOf(i) + String.valueOf(j));
                cor(i, j);
                oceano.add(casas[i][j], constraints);
            }
        }
        for (int i = 1; i < tab.getY() + 1; i++) {
           constraints.gridx = 0;
           constraints.gridy = i;
           JLabel gridNum = new JLabel(String.valueOf(i - 1));
           oceano.add(gridNum, constraints);
           constraints.gridx = i;
           constraints.gridy = 0;
           JLabel gridLet = new JLabel(letras[i - 1]);
           oceano.add(gridLet, constraints);
        }
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
        
        this.add(oceano);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void desativarbotoes(){
        for (JButton[] linha : casas) {
            for (JButton casa : linha){
                casa.setEnabled(false);
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
        JFrame mostrartexto = new JFrame();
        mostrartexto.add(texto);
        mostrartexto.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mostrartexto.setSize( 200, 100 ); 
        mostrartexto.setResizable(false);
        mostrartexto.setVisible( true );
        
    }
    
    private void cor(int i, int j){
        StatusQ status = tab.getCasa(i, j).getStatus();
        switch (status) {
            case VAZIO -> casas[i][j].setBackground(Color.CYAN);
            case ERRADO -> casas[i][j].setBackground(Color.RED);
            case AFUNDADO -> casas[i][j].setBackground(Color.BLACK);
            case NAVIO -> {
                if (!vez){
                    casas[i][j].setBackground(Color.GRAY);
                }
                else{
                    casas[i][j].setBackground(Color.CYAN);
                }
            }
        }
    
    }
    
}
