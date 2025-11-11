package iskahoot.common;

import java.util.List;

public class Question {

    private String question;
    private int points;
    private int correct;
    private List<String> options;

    public String getQuestion() {
        return question;
    }
    public int getPoints() {
        return points;
    }
    public int getCorrect() {
        return correct;
    }
    public List<String> getAnswers() {
        return options;
    }

}
