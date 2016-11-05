import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

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
public class Foilermaker {

    FMModel model;
    FMView view;
    private Socket socket ;
    private PrintWriter out ;
    private BufferedReader in ;
    
    //Constructor takes care of server connection
    public Foilermaker ()throws Exception {
        model = new FMModel(this);
        view = new FMView(this);
        
        try {
        	System.out.println("Connecting to Server...");
    		socket = new Socket ("localhost", 9000);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
        }
    }
       
    //Requests addition of a new user
	public void createUser()throws Exception{
		out.println("CREATENEWUSER" + "--" + view.usernameInput.getText() + "--" + view.passwordInput.getText());
    	
    }
	
	//Logs in existing user
	public void loginUser()throws Exception{
        out.println("LOGIN" + "--" + view.usernameInput.getText() + "--" + view.passwordInput.getText());
	}

    public static void main(String[] args)throws Exception {
    	
    	Foilermaker game = new Foilermaker();
  
        
        
        
    }
}
