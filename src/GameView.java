import javax.swing.*;
import java.awt.*;

/**
 * GameView.java
 *
 * This class shows game changes and updates to the user.
 * Implements Java GUI classes.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 18, 2016
 *
 */
public class GameView extends JFrame {

    public final String TITLE = "Foilmaker";
    public final int FRAME_WIDTH = 300;
    public final int FRAME_HEIGHT = 500;

    // Labels
    JLabel greetingLabel = new JLabel ("Welcome!");
    JLabel newUserLabel = new JLabel ("New user created");
    JLabel usernameLabel = new JLabel ("Username");
    JLabel passwordLabel = new JLabel ("Password");

    JLabel startGameLabel = new JLabel ("Press <Start game> to start game");
    JLabel joinedGameLabel = new JLabel ("Joined game: waiting for leader");
    JLabel useThisKeyToJoin = new JLabel ("Others should use this key to join your game");
    JLabel waitForLeaderLabel = new JLabel ("Waiting for leader ...");
    JLabel playerIsLeaderLabel = new JLabel ("Game started: You are the leader");

    JLabel whatIsWordLabel = new JLabel ("What is the word for");
    JLabel yourSuggestionLabel = new JLabel ("Your Suggestion");
    JLabel enterSuggestionLabel = new JLabel ("Enter your suggestion");
    JLabel pickOptionLabel = new JLabel ("Pick your option below");
    JLabel pickChoiceLabel = new JLabel ("Pick your choice");
    JLabel nextRoundReadyLabel = new JLabel ("Click <Next Round> when ready");
    JLabel gameOverLabel = new JLabel ("Game over!");

    // Buttons
    private JButton login = new JButton ("Login");
    private JButton register = new JButton ("Register");
    private JButton startNewGame = new JButton ("Start New Game");
    private JButton joinGame = new JButton ("Join a Game");
    private JButton submitSuggestion = new JButton ("Submit Suggestion");
    private JButton submitOption = new JButton ("Submit Option");
    private JButton nextRound = new JButton ("Next Round");

    // Input Fields
    private JTextField username = new JTextField();
    private JTextField password = new JTextField();
    private JTextField gameKeyInput = new JTextField();
    private JTextField userSuggestionInput = new JTextField();

    private Container cPane;



    public GameView() {
        setTitle(TITLE);
        setPreferredSize(new Dimension (FRAME_WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        cPane = this.getContentPane();
        login.setSize(200, 200);
        cPane.add(login, BorderLayout.CENTER);

    }
}