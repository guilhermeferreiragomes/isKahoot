package iskahoot.game;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private int correct;
    private int points;

    public Question(String question, List<String> options, int correct, int points) {
        this.question = question;
        this.options = options;
        this.correct = correct;
        this.points = points;
    }

    // Getters
    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrect() { 
        return correct;
    }

    public int getPoints() {
        return points;
    }

    // Setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}