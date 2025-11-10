package iskahoot.client.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RankingView extends JPanel {
	
	private View view;
	
	public RankingView(View view) {
		this.view = view;
	
		setLayout(new BorderLayout());
		
		JLabel tempLabel = new JLabel("Aqui vai aparecer o Placar/Ranking");
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(tempLabel, BorderLayout.CENTER);
		
		
	}

}
