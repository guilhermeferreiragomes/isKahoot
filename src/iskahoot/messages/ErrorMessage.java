package iskahoot.messages;

public class ErrorMessage extends Message {
    private String errorMessageText;
    
    public ErrorMessage(String errorMessageText) {
        this.errorMessageText = errorMessageText;
    }
    
    @Override
    public String serialize() {
        return "ERROR," + errorMessageText;
    }
    
    // Getter
    public String getErrorText() {
        return errorMessageText;
    }
}