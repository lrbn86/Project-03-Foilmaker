
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GameView.java
 *
 * This class shows game changes and updates to the user.
 * Implements Java GUI classes.
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version October 18, 2016
 *
 */
public class GameView extends JFrame {

    public final String TITLE = "Foilmaker";
    public final int FRAME_WIDTH = 300;
    public final int FRAME_HEIGHT = 500;

    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel();

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

    public GameView() {

        setTitle(TITLE);
        setPreferredSize(new Dimension (FRAME_WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setupGUI();
        setVisible(true);

    }


    public void setupGUI() {
        setupMainPanel();
    }

    public void setupMainPanel() {
        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        setupTopPanel();
        setupMiddlePanel();
        setupBottomPanel();
    }

    public void setupTopPanel() {

        // The top panel's label will change from 'FoilerMaker!' to the username after logging in

        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.add(new JLabel ("Foilermaker!"));
    }

    public void setupMiddlePanel() {

        // The middle panel will be changing to different panels (different states)

        // The starting panel will show the login/register state
        // The second panel will show the startNewGame/joinAGame state
        // if player chooses startNewGame, then change to the GameStarted state
        // if player chooses joinAGame, then change to the JoinGame state
        // once player press Join Game, change to waiting state

        // once game starts, change to SubmitSuggestion state
        // after submission, change to pick option state
        // after picking options, change to result state
        // after clicking next round, go all the way back to SubmitSuggestion state (but with a different word)

        // user can quit by exiting GUI


        mainPanel.add(middlePanel, BorderLayout.CENTER);
        middlePanel.setBorder(BorderFactory.createEtchedBorder());

    }

    public void setupBottomPanel() {

        // The bottom panel's label will change according to the middle panel states
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JLabel("New user created"), BorderLayout.WEST);

    }
    
    public static void main(String[] args){
    	new GameView();
    }
}
