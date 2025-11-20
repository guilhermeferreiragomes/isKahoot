package iskahoot.server;

import iskahoot.game.Question;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameState {
    private final String gameCode;
    private final int numTeams;
    private final int numPlayerPerTeam;
    private final List<Question> questions;
    private GamePhase currentPhase;
    private final Map<String, PlayerThread> players;
    private final Map<String, String> teams; // username -> teamName

    public GameState(String gameCode, int numTeams, int numPlayerPerTeam, List<Question> questions) {
        this.gameCode = gameCode;
        this.numTeams = numTeams;
        this.numPlayerPerTeam = numPlayerPerTeam;
        this.questions = questions;
        this.currentPhase = GamePhase.WAITING;
        this.players = new ConcurrentHashMap<>();
        this.teams = new ConcurrentHashMap<>();
    }

    public synchronized boolean addPlayer(String username, String teamName, PlayerThread playerThread) {
        if (currentPhase != GamePhase.WAITING) {
            return false;
        }

        // Verificar se o username já existe
        if (players.containsKey(username)) {
            return false;
        }

        // Contar quantos jogadores já estão na equipa
        long teamMemberCount = teams.values().stream()
                .filter(team -> team.equals(teamName))
                .count();

        if (teamMemberCount >= numPlayerPerTeam) {
            return false; // Equipa cheia
        }

        players.put(username, playerThread);
        teams.put(username, teamName);
        return true;
    }

    public boolean isReadyToStart() {
        return players.size() >= numTeams * numPlayerPerTeam;
    }

    // Getters
    public String getGameCode() { return gameCode; }
    public int getNumTeams() { return numTeams; }
    public int getNumPlayerPerTeam() { return numPlayerPerTeam; }
    public List<Question> getQuestions() { return questions; }
    public GamePhase getCurrentPhase() { return currentPhase; }
    public Map<String, PlayerThread> getPlayers() { return players; }
    public Map<String, String> getTeams() { return teams; }
}