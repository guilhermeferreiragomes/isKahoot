package iskahoot.game;

import java.util.List;

public class Quiz {
    private String name;
    private List<Question> questions;

    public Quiz(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public boolean isEmpty() {
        return questions.isEmpty();
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}