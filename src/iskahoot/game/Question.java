package iskahoot.game;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private int correctAnswer;
    private int points;

    public Question(String question, List<String> options, int correctAnswer, int points) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    // Getters
    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
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

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}