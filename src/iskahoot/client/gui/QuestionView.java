package iskahoot.client.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class QuestionView extends JPanel implements ActionListener {
    
    private JLabel timer;
    private JLabel question;
    private JButton[] answers = new JButton[4];
    
    // Ranking permanente
    private JTextArea currentRanking;
    private JTextArea lastRound;
    
    public QuestionView() {
        setLayout(new BorderLayout(10, 10));
        this.setBorder(new EmptyBorder(10,10,10,10));

        // Painel principal do jogo (esquerda)
        JPanel gamePanel = createGamePanel();
        this.add(gamePanel, BorderLayout.CENTER);
        
        // Ranking lateral (direita) - SEMPRE VISÍVEL
        JPanel rankingPanel = createRankingPanel();
        this.add(rankingPanel, BorderLayout.EAST);
    }
    
    private JPanel createGamePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        //Temporizador no topo
        this.timer = new JLabel("Tempo restante: 30 segundos", SwingConstants.CENTER);
        panel.add(timer, BorderLayout.NORTH);

        //Pergunta no meio
        this.question = new JLabel("Aguardando início do jogo...", SwingConstants.CENTER);
        panel.add(question, BorderLayout.CENTER);
        
        //Respostas em baixo
        JPanel respostas = new JPanel(new GridLayout(2, 2, 10, 10));
        for(int i = 0; i < answers.length; i++) {
            answers[i] = new JButton("Opção " + (i + 1));
            answers[i].addActionListener(this);
            answers[i].setEnabled(true);
            respostas.add(answers[i]);
        }
        panel.add(respostas, BorderLayout.SOUTH);
        
        return panel;
    }
    
    // Painel de ranking sempre visível
    private JPanel createRankingPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setPreferredSize(new java.awt.Dimension(250, 0));
        
        // Ranking atual
        JPanel currentPanel = new JPanel(new BorderLayout());
        currentPanel.setBorder(new TitledBorder("🏆 Ranking Atual"));
        this.currentRanking = new JTextArea(10, 20);
        this.currentRanking.setEditable(false);
        this.currentRanking.setText("À espera de jogadores...");
        currentPanel.add(new JScrollPane(currentRanking), BorderLayout.CENTER);
        
        // Última ronda
        JPanel lastPanel = new JPanel(new BorderLayout());
        lastPanel.setBorder(new TitledBorder("↩️ Ultima Ronda"));
        this.lastRound = new JTextArea(5, 20);
        this.lastRound.setEditable(false);
        this.lastRound.setText("Nenhuma ronda ainda");
        lastPanel.add(new JScrollPane(lastRound), BorderLayout.CENTER);
        
        panel.add(currentPanel, BorderLayout.CENTER);
        panel.add(lastPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < answers.length; i++) {
            if(e.getSource() == answers[i]) {
                System.out.println("Opção " + (i + 1) + " selecionada!");
                setAnswersEnable(false);
                // TODO: Enviar resposta para servidor
                break;
            }
        }
    }

    // Métodos para atualizar a interface
    public void setQuestion(String questionText, String[] options) {
        this.question.setText(questionText);
        for(int i = 0; i < Math.min(options.length, answers.length); i++) {
            answers[i].setText(options[i]);
        }
        setAnswersEnable(true);
    }
    
    public void setTimer(int secondsLeft) {
        this.timer.setText("Tempo restante: " + secondsLeft + " segundos");
    }
    
    public void updateCurrentRanking(String ranking) {
        this.currentRanking.setText(ranking);
    }
    
    public void updateLastRound(String lastRoundInfo) {
        this.lastRound.setText(lastRoundInfo);
    }
    
    // desativar botoes quando se responde
    private void setAnswersEnable(boolean isEnable) {
        for(JButton button : answers)
            button.setEnabled(isEnable);
    }
}