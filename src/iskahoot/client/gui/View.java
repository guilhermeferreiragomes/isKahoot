package iskahoot.client.gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // Apenas as vistas necessárias para o jogo
    private QuestionView questionView;
    private RankingView rankingView;
    
    public View() {
        initializeComponents();
        setupLayout();
        setupWindow();
    }
    
    private void initializeComponents() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        questionView = new QuestionView();
        rankingView = new RankingView();
        
        // Adicionar vistas ao CardLayout
        mainPanel.add(questionView, "QUESTION");
        mainPanel.add(rankingView, "RANKING");
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private void setupWindow() {
        setTitle("Kahoot Cliente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showQuestionView();
    }
    
    public void showQuestionView() {
        cardLayout.show(mainPanel, "QUESTION");
    }
    
    public void showRankingView() {
        cardLayout.show(mainPanel, "RANKING");
    }
    
    public QuestionView getQuestionView() {
        return questionView;
    }
    
    public RankingView getRankingView() {
        return rankingView;
    }
}