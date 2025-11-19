package iskahoot.common;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private int points;
    private int correct;
    private List<String> options;

    public Question(String question, int points, int correct) {
        this.question = question;
        this.points = points;
        this.correct = correct;
        this.options = new ArrayList<>();
    }


    public String getQuestion() {
        return question;
    }
    public int getPoints() {
        return points;
    }
    public int getCorrect() {
        return correct;
    }
    public List<String> getOptions() {
        return options;
    }

}
