/**
 * FMModel.java
 *
 * This class maintains data structures that reflects the internal state of the whole application.
 * Captures data (questions, qord suggestions, etc. received from the server)
 *
 * Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version November 11, 2016
 *
 */
public class FMModel {

    private String username;
    private String password;
    private String gameKey;
    private String sessionCookie;
    private int numOfPlayers;
    private String[] participants = new String[10];
    private int score;

    public void addParticipants(String name) {
        participants[numOfPlayers] = name;
        numOfPlayers++;
    }

    public String getParticipants() {
        String output = "";
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] != null) {
                output += participants[i] + "\n";
            }
        }
        return output;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionCookie() {
        return this.sessionCookie;
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    public String getGameKey() {
        return this.gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
}
