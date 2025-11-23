package iskahoot.server;

import iskahoot.game.Question;
import iskahoot.game.Quiz;

public class GameServer {

    public static void main(String[] args) {
        
        System.out.println("--- A testar o QuizLoader ---");

        Quiz quiz = QuizLoader.loadQuizFromFile("data/quizzes.json");
        
        if (quiz != null && quiz.getQuestions() != null) {
            
            System.out.println("Quiz '" + quiz.getName() + "' carregado.");
            System.out.println("Total de perguntas: " + quiz.getQuestions().size());
            System.out.println("--------------------------------------");

            for (Question q : quiz.getQuestions()) {
                System.out.println("Pergunta: " + q.getQuestion());
                System.out.println("  Opções: " + q.getOptions());
                System.out.println("  Correta (índice): " + q.getCorrect());
                System.out.println("  Pontos: " + q.getPoints());
                System.out.println();
            }
            
        } else {
            System.err.println("ERRO: O QuizLoader falhou.");
        }
    }
}