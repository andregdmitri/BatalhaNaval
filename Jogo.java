package com.mycompany.batalhanaval;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

final class Jogo {
    IJogador jogador;
    IJogador oponente;
    Bot ai;
    Tabuleiro tab1;
    Tabuleiro tab2;
    
    public Jogo(){
        tab1 = new Tabuleiro (10, 10);
        tab2 = new Tabuleiro (10, 10);
        
        
        String nomeP1 = JOptionPane.showInputDialog("Por favor insira seu nome");
        jogador = new Jogador (tab1, nomeP1);
        jogador.posicionarNavios();
        
        /*        for (Navio n : jogador.getNavios()){
        colocarNavios colocarnavios = new colocarNavios(tab1, n);
        while(colocarnavios.estaEmUso());
        colocarnavios.dispose();
        }*/
        Object[] opcoes = {"Singleplayer", "Multiplayer"};
       
        Object reply = JOptionPane.showInputDialog(null, "Escolha um modo de jogo", "Menu", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (reply.equals("Singleplayer")){
            ai = new Bot (tab2);
            while(jogador.isVivo() && ai.isVivo()){
                Partida oTab = new Partida(true, tab2);
                while(oTab.estaEmUso()); 
                esperar(5000);
                oTab.dispose();
                Partida jTab = new Partida(false, tab1);
                esperar(5000);
                jTab.tirodadooponente(ai.atirar(tab1));
                esperar(3000);
                jTab.dispose();
            }
            vitoria(jogador, ai);        
        }
    }
    
    public void esperar(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    
    }
    
    public void vitoria (IJogador jogador, IJogador oponente){
        JLabel texto;
        if (jogador.isVivo()){
            texto = new JLabel(jogador.getNome() + " venceu!");
        }
        else{
            texto = new JLabel(oponente.getNome() + " venceu!");
        }
        JFrame mostrartexto = new JFrame();
        mostrartexto.add(texto);
        mostrartexto.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mostrartexto.setSize( 200, 100 ); 
        mostrartexto.setResizable(false);
        mostrartexto.setVisible( true );
    }
    
}