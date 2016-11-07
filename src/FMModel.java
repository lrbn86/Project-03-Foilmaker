/**
 * FMModel.java
 *
 * This class maintains data structures that reflects the internal state of the whole application.
 * Captures data (questions, qord suggestions, etc. received from the server)
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version November 7, 2016
 *
 */
public class FMModel {

    private Foilermaker controller;
    private String username;
    private String password;
    private String gameKey;
    private int numOfParticipants;
    private String[] participants;
    private String[] words;

    public FMModel(Foilermaker controller) {
        this.controller = controller;
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

    public int getNumOfParticipants() {
        return this.numOfParticipants;
    }
}
