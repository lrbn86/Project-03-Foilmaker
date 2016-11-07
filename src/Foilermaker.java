import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Foilermaker.java
 *
 * This class manipulates data in the model as per user interactions.
 * Implements network programming pits, application protocol, etc.
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version November 7, 2016
 *
 */
public class Foilermaker {

    FMModel model;
    FMView view;
    FoilMakerNetworkProtocol p;

    String serverResponse;

    Socket socket;
    PrintWriter out;
    InputStreamReader isr;
    BufferedReader in;

    public Foilermaker () {
        model = new FMModel(this);
        view = new FMView(this);
        p = new FoilMakerNetworkProtocol();
    }

    public void startGame() {
        connectToServer();
    }


    // Networking
    public void connectToServer() {

        String serverHost = view.serverHostInput.getText();
        int portNumber = Integer.parseInt(view.portNumberInput.getText());

        try {
            System.out.println("Connecting to Server...");

            // Connect to server
            socket = new Socket(serverHost, portNumber);

//            // Create data writer
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//            // Create data reader
//            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//            BufferedReader in = new BufferedReader(isr);

            // Send message to server
//            out.println();

            // Read server response
//            String serverMessage = in.readLine();
//            System.out.println(serverMessage);
            System.out.println("Connected to Server.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendNewUserRequest() {

        model.setUsername(view.usernameInput.getText());
        model.setPassword(view.passwordInput.getText());

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(FoilMakerNetworkProtocol.MSG_TYPE.CREATENEWUSER + p.SEPARATOR + model.getUsername() + p.SEPARATOR + model.getPassword());
            while (in.readLine() != null) {
                setServerResponse(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getServerResponse() {
        return this.serverResponse;
    }

    public void setServerResponse(String serverResponse) {
        this.serverResponse = serverResponse;
    }

    public static void main(String[] args) {
        Foilermaker game = new Foilermaker();
        game.startGame();
        System.out.println(game.getServerResponse());

    }
}
