import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * Foilermaker.java
 *
 * This class manipulates data in the model as per user interactions.
 * Implements network programming pits, application protocol, etc.
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version October 18, 2016
 *
 */
public class Foilermaker extends Thread{

    FMModel model;
    FMView view;
    private Socket socket ;
    private PrintWriter out ;
    private BufferedReader in;
    private String serverInput;
    private boolean exceptionThrown;
    
    //Constructor takes care of server connection
    public Foilermaker ()throws Exception {
        model = new FMModel(this);
        view = new FMView(this, model);
        
   	 try {
       	
       	System.out.println("Connecting to Server...");
   		  socket = new Socket ("localhost", 9000);
          out = new PrintWriter(socket.getOutputStream(), true);
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       } catch (IOException e) {
       }
        
    }
       
    //Requests addition of a new user
	public void createUser()throws Exception{
		out.println("CREATENEWUSER" + "--" + view.usernameInput.getText() + "--" + view.passwordInput.getText());
		serverInput = in.readLine();
		
		switch(serverInput.substring(0,32)){
    	case "RESPONSE--CREATENEWUSER--SUCCESS":
    		model.setUsername(view.usernameInput.getText());
    		model.setGameToken(serverInput.substring(26, serverInput.length()));
    		this.exceptionThrown = false;
    		break;
    	default:
    		this.exceptionThrown = true;
    	}
		
    	
    }
	
	//Logs in existing user
	public void loginUser()throws IOException{
		
        	out.println("LOGIN" + "--" + view.usernameInput.getText() + "--" + view.passwordInput.getText());
        	this.serverInput = in.readLine();
        		
        	switch(this.serverInput.substring(0,24)){
        	case "RESPONSE--LOGIN--SUCCESS":
        		model.setUsername(view.usernameInput.getText());
        		model.setGameToken(serverInput.substring(26, serverInput.length()));
        		this.exceptionThrown = false;
        		break;
        	default:
        		this.exceptionThrown = true;
        	}
  
	}
	
	//Retrieves boolean exceptionThrown
	public boolean getExceptionThrown(){
		return this.exceptionThrown;
	}
	
	public void setExceptionThrown(boolean bool){
		this.exceptionThrown = bool;
	}
	
	//Retrieves server input
	public String getServerInput(){
		return this.serverInput;
	}
	
	//Start new game
	public void startNewGame() throws IOException{
		out.println("STARTNEWGAME"+"--"+ model.getGameToken());
		serverInput = in.readLine();
		model.setGameKey(serverInput.substring(33, serverInput.length()));		
		start();
		
	}
	
	//updates activity lobby
	public void run(){
		while(true){
			try {
				serverInput = in.readLine();
				String sub = serverInput.substring(16,serverInput.length()-3);
				view.activity.add(new JLabel(sub));
				model.addParticipant();
				
				switch(model.getNumOfParticipants()){
				case 1:
					view.startGame.setEnabled(false);
				default:
					view.startGame.setEnabled(true);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	//Join a game
	public void joinGame()throws IOException{
		out.println("JOINGAME" + "--" + model.getGameToken() + "--" + view.keyInput.getText());
	}
	
	//Start game once there is a number of participants. 
	public void startTheGame() throws IOException{
		out.println("ALLPARTICIPANTSHAVEJOINED" + "--" + model.getGameToken() + "--" + model.getGameKey());
	}
	
	//submit user answer
	public void submitSuggestion() throws IOException{
		out.println("PLAYERSUGGESTION" + "--" + model.getGameToken() + "--" + model.getGameKey() + "--" + view.userSuggestion.getText());
		
	}
	
    public static void main(String[] args)throws Exception {
    	
    	Foilermaker game = new Foilermaker();
    	
    }
}
