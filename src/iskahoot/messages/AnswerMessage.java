package iskahoot.messages;

public class AnswerMessage extends Message {
    private int answerIndex;
    
    public AnswerMessage(int answerIndex) {
        this.answerIndex = answerIndex;
    }
    
    @Override
    public String serialize() {
        return "ANSWER," + answerIndex;
    }
    
    public int getAnswerIndex() { return answerIndex; }
}