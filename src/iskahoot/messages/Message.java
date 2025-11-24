package iskahoot.messages;

public abstract class Message {
    public abstract String serialize();
    
    public static Message deserialize(String data) {
        String[] parts = data.split(",");
        String type = parts[0];
        
        switch (type) {
            case "ENROLL":
                return new EnrollmentMessage(parts[1], parts[2], parts[3]);
            case "ANSWER":
                return new AnswerMessage(Integer.parseInt(parts[1]));
            case "ERROR":
                return new ErrorMessage(parts[1]);
            // ... outros tipos
            default:
                return null;
        }
    }
}