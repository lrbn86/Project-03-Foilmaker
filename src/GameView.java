import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
public class GameView extends JFrame implements ActionListener {

    public final String TITLE = "Foilmaker";
    public final int FRAME_WIDTH = 300;
    public final int FRAME_HEIGHT = 500;

    boolean isGameOver = false;

    String currentWorkingDir = System.getProperty("user.dir");
    File userDatabase = new File(currentWorkingDir + "/UserDatabase.txt");


    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();

    // States will be added into the middlePanel
    // Use CardLayout() to switch between states on button presses
    JPanel loginRegisterState = new JPanel();
    JPanel createOrJoinState = new JPanel();
    JPanel gameStartedState = new JPanel();
    JPanel gameJoinedState = new JPanel();
    JPanel waitingForGameState = new JPanel();
    JPanel submissionState = new JPanel();
    JPanel pickAnOptionState = new JPanel();
    JPanel resultState = new JPanel();

    JPanel bottomPanel = new JPanel();

    // Labels
    JLabel topPanelMessage = new JLabel ("FoilerMaker!");
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
    private JTextField usernameInput = new JTextField();
    private JTextField passwordInput = new JTextField();
    private JTextField gameKeyInput = new JTextField();
    private JTextField userSuggestionInput = new JTextField();

    public GameView() {

        setTitle(TITLE);
        setPreferredSize(new Dimension (FRAME_WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        pack();
        setupGUI();
        handleButtons();
        setVisible(true);

        System.out.println(userDatabase);
        System.out.println(userDatabase.canWrite());

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
        topPanel.add(topPanelMessage);
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

        // There are 8 states (panels)
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        middlePanel.setBorder(BorderFactory.createEtchedBorder());
        middlePanel.setLayout(new BorderLayout());
        setupLoginRegisterState();
    }

    // TODO
    public void setupLoginRegisterState() {

        Border etchedBorder = BorderFactory.createEtchedBorder();

        middlePanel.add(loginRegisterState, BorderLayout.CENTER);
        loginRegisterState.setBorder(etchedBorder);
        loginRegisterState.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 0));
        JPanel loginRegisterButtonsPanel = new JPanel();
        JPanel usernamePasswordPanel = new JPanel();

        loginRegisterButtonsPanel.setBorder(etchedBorder);
        loginRegisterButtonsPanel.add(login);
        loginRegisterButtonsPanel.add(register);

        usernamePasswordPanel.setLayout(new GridLayout(2, 2));
        usernamePasswordPanel.add(usernameLabel);
        usernamePasswordPanel.add(usernameInput);
        usernamePasswordPanel.add(passwordLabel);
        usernamePasswordPanel.add(passwordInput);
        mainPanel.add(usernamePasswordPanel);
        mainPanel.add(loginRegisterButtonsPanel);

        loginRegisterState.add(mainPanel);
    }

    public void setupBottomPanel() {

        // The bottom panel's label will change according to the middle panel states
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JLabel("TEST"), BorderLayout.WEST);

    }

    public void handleButtons() {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Login' button is pressed

                // Set the text of the topPanelMessage to the username

            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Register' button is pressed

                // Store username and password to database


            }
        });

        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Start New Game' button is pressed
            }
        });

        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Join Game' button is pressed
            }
        });

        submitSuggestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Submit Suggestion' button is pressed
            }
        });

        submitOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Submit Option' button is pressed
            }
        });

        nextRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do something when 'Next Round' button is pressed
            }
        });

    }


    // Required unused method to prevent compile error
    public void actionPerformed(ActionEvent e) {}
    
    public static void main(String[] args){
    	new GameView();
    }
}
