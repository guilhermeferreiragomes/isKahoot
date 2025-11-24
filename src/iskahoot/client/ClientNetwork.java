package iskahoot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import iskahoot.messages.EnrollmentMessage;
import iskahoot.messages.AnswerMessage;

public class ClientNetwork {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean isConnected;

    private String serverIP;
    private int serverPort;
    private String gameCode;
    private String teamName;
    private String username;

    public ClientNetwork(String serverIP, int serverPort, String gameCode, String teamName, String username) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.gameCode = gameCode;
        this.teamName = teamName;
        this.username = username;
        this.isConnected = false;
    }

    public boolean connect() {
        try {
            this.socket = new Socket(serverIP, serverPort);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.isConnected = true;
            
            System.out.println("Conectado ao servidor " + serverIP + ":" + serverPort);
            
            // Enviar inscrição automática
            return enrollInGame();
            
        } catch (IOException e) {
            System.out.println("Erro de conexão " + e.getMessage());
            return false;
        }
    }
    
    private boolean enrollInGame() throws IOException {
        // Criar e enviar mensagem de inscrição
        EnrollmentMessage enrollment = new EnrollmentMessage(gameCode, teamName, username);
        out.println(enrollment.serialize());
        System.out.println("Enviada inscrição: " + enrollment.serialize());
        
        // Aguardar resposta do servidor
        String response = in.readLine();
        System.out.println("Resposta: " + response);
        
        if ("ACCEPTED".equals(response)) {
            System.out.println("Aceite no jogo!");
            return true;
        } else {
            System.out.println("Rejeitado: " + response);
            return false;
        }
    }
    
    public void sendAnswer(int answerIndex) {
        if (isConnected && out != null) {
            AnswerMessage answer = new AnswerMessage(answerIndex);
            out.println(answer.serialize());
            System.out.println("Enviada resposta: " + answerIndex);
        }
    }
    
    public void disconnect() {
        try {
            isConnected = false;
            if (out != null) out.println("FIM");
            if (socket != null) socket.close();
            System.out.println("Desconectado do servidor");
        } catch (IOException e) {
            System.err.println("Erro ao desconectar: " + e.getMessage());
        }
    }
    
    public boolean isConnected() {
        return isConnected;
    }
}