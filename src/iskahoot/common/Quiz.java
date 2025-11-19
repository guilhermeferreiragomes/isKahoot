package iskahoot.common;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private String name;
    private List<Question> questions;

public Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    public List<Question> getQuestions() {
        return questions;
    }



}
