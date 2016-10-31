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

    public Foilermaker () {
        model = new FMModel(this);
        view = new FMView(this);
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
            Socket socket = new Socket (serverHost, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
        }

    }

    public static void main(String[] args) {
        Foilermaker game = new Foilermaker();
        game.startGame();

    }
}
