package iskahoot.client.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class QuestionView extends JPanel {
	
	private View view;
	
	public QuestionView(View view) {
		this.view = view;
		
		setLayout(new BorderLayout());
		JLabel tempLabel = new JLabel("Aqui vão aparecer as Perguntas e Respostas");
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(tempLabel, BorderLayout.CENTER);
		
	}

}
