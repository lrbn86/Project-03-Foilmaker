import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * FoilerMakerNetworkProtocol.java
 *
 *
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version October 25, 2016
 *
 */

public class FoilerMakerNetworkProtocol {
	
	public static void main(String[] args){
		
	String serverIP = "localhost";
		
	int serverPort = 9999;
		
	try{
		//Connect to server
		Socket socket = new Socket(serverIP, serverPort);
		
		//Create data writer
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		//Create data reader
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		
		//Send message to server
		out.println("Message to server");
		
		//Read server response
		String serverMessage = in.readLine();
		
	}catch(IOException e){
		e.printStackTrace();
	}
	

}}
