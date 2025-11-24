package iskahoot.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import iskahoot.messages.AnswerMessage;
import iskahoot.messages.EnrollmentMessage;
import iskahoot.messages.ErrorMessage;
import iskahoot.messages.Message;

public class PlayerThread extends Thread {

    private Socket clientSocket;
    private BufferedReader in; //Ler o que o cliente comunica
    private PrintWriter out; //Dizer ao cliente o que o server comunica

    public PlayerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            connectToServer();
            System.out.println("PlayerThread #" +  Thread.currentThread().threadId() + " conectada");
            listenToClient();
        } catch (Exception e) {
            System.err.println("Erro de conexão " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    private void connectToServer() throws IOException {
        this.in = new BufferedReader(new InputStreamReader(
            clientSocket.getInputStream()
        ));
        this.out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(clientSocket.getOutputStream())), true
        );
    }

    private void listenToClient() throws IOException {
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Recebido: " + message);            
            processMessage(message);
            if (message.equals("FIM")) {
                break; 
            }
        }
        System.out.println("Cliente desconectou");
    }

    private void processMessage(String message) {
        if (message.equals("FIM")) {
            return; // Vai sair do loop no listenToClient
        }
        
        String[] parts = message.split(",");
        String messageType = parts[0];
        
        switch (messageType) {
            case "ENROLL":
                if (parts.length >= 4) {
                    EnrollmentMessage enroll = new EnrollmentMessage(parts[1], parts[2], parts[3]);
                    handleEnrollment(enroll);
                } else {
                    System.out.println("Formato de inscrição inválido");
                    ErrorMessage error = new ErrorMessage("Formato de inscrição inválido");
                    out.println(error.serialize());
                }
                break;
            case "ANSWER":
                if (parts.length >= 2) {
                    try {
                        AnswerMessage answer = new AnswerMessage(Integer.parseInt(parts[1]));
                        handleAnswer(answer);
                    } catch (NumberFormatException e) {
                        System.out.println("Número de resposta inválido");
                        ErrorMessage error = new ErrorMessage("Número de resposta inválido");
                        out.println(error.serialize());
                    }
                } else {
                    System.out.println("Formato de resposta inválido");
                    ErrorMessage error = new ErrorMessage("Formato de resposta inválido");
                    out.println(error.serialize());
                }
                break;
            default:
                System.out.println("Tipo de mensagem desconhecido: " + messageType);
                ErrorMessage error = new ErrorMessage("Tipo de mensagem inválido");
                out.println(error.serialize());
        }
    }

    private void handleEnrollment(EnrollmentMessage enroll) {
        String gameCode = enroll.getGameCode();
        String teamName = enroll.getTeamName();
        String username = enroll.getUsername();
        
        System.out.println("Inscrição: " + username + " quer entrar no jogo " + 
                          gameCode + " (equipa " + teamName + ")");
        
        // Por agora, aceitar sempre
        out.println("ACCEPTED");
    }

    private void handleAnswer(AnswerMessage answer) {
        int answerIndex = answer.getAnswerIndex();
        System.out.println("Resposta recebida: " + answerIndex);
        
        // Por agora, só confirmar
        out.println("OK,Resposta registada");
    }

    private void cleanup() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (clientSocket != null) clientSocket.close();
        } catch (IOException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}