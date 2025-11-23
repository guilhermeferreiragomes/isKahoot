package iskahoot.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

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
           System.out.println("PlayerThread #" +  Thread.currentThread().threadId() + " a conectar ao servidor");
           listenToClient();
        } catch (Exception e) {
            System.err.println("Erro de conexão " + e.getMessage());
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
            if (message.equals("FIM")) {
                break; 
            }
        }
        System.out.println("Cliente desconectou");
    }


}
