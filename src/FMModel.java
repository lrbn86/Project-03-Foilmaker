/**
 * FMModel.java
 *
 * This class maintains data structures that reflects the internal state of the whole application.
 * Captures data (questions, qord suggestions, etc. received from the server)
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version October 18, 2016
 *
 */
public class FMModel {

    private Foilermaker controller;
    private String username;
    private String password;
    private String gameToken;
    private String gameKey;
    private int numOfParticipants = 1;
    private String[] participants;
    private String[] words;

    public FMModel(Foilermaker controller) {
        this.controller = controller;
    }
    
    public void setUsername(String username){
    	this.username = username; 
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setGameToken(String gameToken){
    	this.gameToken = gameToken;
    }
    
    public String getGameToken(){
    	return this.gameToken;
    }
    public void setGameKey(String gameKey){
    	this.gameKey = gameKey;
    }
    
    public String getGameKey() {
        return this.gameKey;
    }
    
    public void addParticipant(){
    	this.numOfParticipants++;
    }
    public int getNumOfParticipants() {
        return this.numOfParticipants;
    }
}
