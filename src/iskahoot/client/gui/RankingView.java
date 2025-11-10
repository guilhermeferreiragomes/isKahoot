package iskahoot.client.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RankingView extends JPanel {
	
	private View view;
	private JLabel title;
	private JTextArea rankings;

	public RankingView(View view) {
		this.view = view;

		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(10, 200, 10, 200));

		//Titulo em cima
		this.title = new JLabel("CLASSIFICAÇÃO", SwingConstants.CENTER);
		add(title, BorderLayout.NORTH);

		//Rankings
		this.rankings = new JTextArea();
		rankings.setEditable(false); // Se não dá para escrever
		add(rankings, BorderLayout.CENTER);

		//Temporario
		rankings.setText("RESULTADOS DA RONDA: \n\n");
		rankings.append("Equipa Gui - 100 pontos\n");
		rankings.append("Equipa Francisco - 100 pontos\n");
		
		JScrollPane scrollPane = new JScrollPane(rankings); //caso seja muito comprido
		add(scrollPane, BorderLayout.CENTER);
	}

}
