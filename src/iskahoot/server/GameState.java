package iskahoot.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import iskahoot.common.Question;

public class GameState {

    private final String gameCode;
    private final int numTeams;
    private final int numPlayerPerTeam;
    private final List<Question> questions;

    private GamePhase currentePhase;
  
    private Map<String, PlayerThread> players;
    private Map<String, String> teams;


    public GameState(String gameCode, int numTeams, int numPlayerPerTeam, List<Question> questions) {
        this.gameCode = gameCode;
        this.numTeams = numTeams;
        this.numPlayerPerTeam = numPlayerPerTeam;
        this.questions = questions;

        this.currentePhase = GamePhase.WAITING_FOR_PLAYERS;

        this.players = new HashMap<>();
        this.teams = new HashMap<>();

    }

    public synchronized boolean addPlayer(String username, String team, PlayerThread playerThread) {
        if(currentePhase != GamePhase.WAITING_FOR_PLAYERS)
            return false;
        if(players.size() >= (numTeams * numPlayerPerTeam))
            return false;
        if(players.containsKey(username))
            return false;
        
        players.put(username, playerThread);
        teams.put(username, team);
        return true;
    }

    public boolean isReadyToStart() {
        if(currentePhase == GamePhase.WAITING_FOR_PLAYERS && players.size() == numTeams * numPlayerPerTeam)
            return true;
        return false;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public GamePhase getCurrentePhase() {
        return currentePhase;
    }

    public String getGameCode() {
        return gameCode;
    }

    public int getNumTeams() {
        return numTeams;
    }

    public int getNumPlayerPerTeam() {
        return numPlayerPerTeam;
    }

}
