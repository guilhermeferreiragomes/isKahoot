package iskahoot.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import iskahoot.game.Quiz;

public class GameServer {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("--- A testar o QuizLoader ---");
        Quiz quiz = QuizLoader.loadQuizFromFile("data/quizzes.json");
        
        if (quiz != null && quiz.getQuestions() != null) {
            System.out.println("Quiz '" + quiz.getName() + "' carregado.");
            System.out.println("Total de perguntas: " + quiz.getQuestions().size());
            
            try {
                System.out.println("🚀 A iniciar o servidor...");
                new GameServer().startServing();
            } catch (IOException e) {
                System.err.println("❌ Erro a iniciar o servidor: " + e.getMessage());
            }
            
        } else {
            System.err.println("ERRO: O QuizLoader falhou.");
        }
    }

    public void startServing() throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("✅ Servidor pronto na porta " + PORT);
        
        try {
            while (true) {
                Socket clientSocket = ss.accept();
                System.out.println("🔌 Nova conexão recebida!");
                
                PlayerThread playerThread = new PlayerThread(clientSocket);
                playerThread.start();
            }
        } finally {
            ss.close();
        }
    }
}