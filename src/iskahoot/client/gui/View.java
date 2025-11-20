package iskahoot.client.gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private QuestionView questionView;
    
    public View() {
        initializeComponents();
        setupWindow();
    }
    
    private void initializeComponents() {
        questionView = new QuestionView();
        add(questionView, BorderLayout.CENTER);
    }
    
    private void setupWindow() {
        setTitle("Kahoot Cliente");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public QuestionView getQuestionView() {
        return questionView;
    }
}