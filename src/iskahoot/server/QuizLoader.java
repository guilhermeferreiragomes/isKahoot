package iskahoot.server;

import com.google.gson.Gson;

import iskahoot.game.Quiz;

import java.io.FileReader;
import java.io.Reader;

public class QuizLoader {

    public static Quiz loadQuizFromFile(String filePath) {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(filePath)) {
            
            Quiz quiz = gson.fromJson(reader, Quiz.class); 

            if (quiz != null && quiz.getQuestions() != null) {
                return quiz;
            } else {
                System.err.println("Erro: O ficheiro JSON está mal formatado ou vazio.");
                return null;
            }

        } catch (Exception e) {
            System.err.println("Erro crítico ao ler o ficheiro '" + filePath + "': " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}