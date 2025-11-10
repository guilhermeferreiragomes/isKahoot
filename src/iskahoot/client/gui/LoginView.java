package iskahoot.client.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginView extends JPanel {
	private View view;
	private JTextField ipField, portField, roomField, teamField, usernameField;
	private JButton loginButton;

	public LoginView(View view) {
		this.view = view;
		
		setLayout(new BorderLayout(20,20));
		this.setBorder(new EmptyBorder(10, 10, 10, 10)); //espaçamento entre os componentes
		
		JLabel title = new JLabel("Bem-vindo ao 	IsKahoot!", SwingConstants.CENTER); //a ultima parte é para o texto ficar centrado
		add(title, BorderLayout.NORTH);
		
		JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
		
		//IP
		formPanel.add(new JLabel("IP do servidor"));
		ipField = new JTextField("127.4.4.4");
		formPanel.add(ipField);
		
		//PORT
		formPanel.add(new JLabel("Porto atribuído"));
		portField = new JTextField("444");
		formPanel.add(portField);
		
		//ROOM
		formPanel.add(new JLabel("Escolhe a sala"));
		roomField = new JTextField();
		formPanel.add(roomField);
		
		//TEAM
		formPanel.add(new JLabel("Escolhe a tua equipa"));
		teamField = new JTextField();
		formPanel.add(teamField);
		
		//USERNAME
		formPanel.add(new JLabel("Escolhe o teu username"));
		usernameField = new JTextField();
		formPanel.add(usernameField);
		
		add(formPanel, BorderLayout.CENTER);
		
		loginButton = new JButton("Entrar no jogo");
		add(loginButton, BorderLayout.SOUTH);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});

		
	}
	
	private void doLogin() {
		System.out.println("A entrar na sessão...");
		view.showView(View.VIEW_QUESTION);
		
	}

}
