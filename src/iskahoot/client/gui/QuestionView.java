package iskahoot.client.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class QuestionView extends JPanel implements ActionListener {
	
	private JLabel timer;
	private JLabel question;
	private JButton[] answers = new JButton[4];
	private JButton temporario;
	
	
	public QuestionView() {
		setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(10,10,10,10));

		//Temporizador no topo
		this.timer = new JLabel("Tempo restante: 30 segundos", SwingConstants.CENTER);
		this.add(timer, BorderLayout.NORTH);

		//Pergunta no meio
		this.question = new JLabel("A pergunta vai aparecer aqui", SwingConstants.CENTER);
		this.add(question, BorderLayout.CENTER);
		
		//Respostas em baixo
		JPanel respostas = new JPanel(new GridLayout(2, 2, 10, 10));
		for(int i = 0; i < answers.length; i++) {
			answers[i] = new JButton("Opção " + (i + 1));
			answers[i].addActionListener(this);
			respostas.add(answers[i]);
		}
		this.add(respostas, BorderLayout.SOUTH);

		//Temporario para passar para rankings
		this.temporario = new JButton("Rankings");
		this.temporario.addActionListener(this);
		this.add(temporario, BorderLayout.EAST);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//TEMPORARIO
		if(e.getSource() == temporario) {
			return;
		}
		for(int i = 0; i < answers.length; i++) {
			if(e.getSource() == answers[i]) {
				System.out.println("Opção " + (i + 1) + " selecionada!");
				setAnswersEnable(false);
			}
		}
	}

	
	// desativar botoes quando se responde
	private void setAnswersEnable(boolean isEnable) {
		for(JButton button : answers)
			button.setEnabled(isEnable);
	}


}
