package iskahoot.client.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	
	public static final String VIEW_LOGIN = "LOGIN";
	public static final String VIEW_QUESTION = "QUESTION";
	public static final String VIEW_RANKING = "RANKING";

	
	
	private JPanel panel;
	private CardLayout layout;
	
	private LoginView loginView;
	private QuestionView questionView;
	private RankingView rankingView;
	
	
	public View() {
		setTitle("IsKahoot");
		
		setSize(700, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		layout = new CardLayout();
		panel = new JPanel(layout);
		
		
		loginView = new LoginView(this);
		questionView = new QuestionView(this);
		rankingView = new RankingView(this);

		
		panel.add(loginView, VIEW_LOGIN);
		panel.add(questionView, VIEW_QUESTION);
		panel.add(rankingView, VIEW_RANKING);
		
		this.add(panel);
		
		showView(VIEW_LOGIN);

		
	}
	
	public void showView(String viewName) {
        layout.show(panel, viewName);
    }

}
