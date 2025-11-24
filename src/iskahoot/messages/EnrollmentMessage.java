package iskahoot.messages;

public class EnrollmentMessage extends Message {
    private String gameCode;
    private String teamName;
    private String username;
    
    public EnrollmentMessage(String gameCode, String teamName, String username) {
        this.gameCode = gameCode;
        this.teamName = teamName;
        this.username = username;
    }
    
    @Override
    public String serialize() {
        return "ENROLL," + gameCode + "," + teamName + "," + username;
    }
    
    // Getters
    public String getGameCode() { return gameCode; }
    public String getTeamName() { return teamName; }
    public String getUsername() { return username; }
}