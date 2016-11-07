import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FMView.java
 *
 * This class shows game changes and updates to the user.
 * Implements Java GUI classes.
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version November 7, 2016
 *
 */
public class FMView extends JFrame implements ActionListener{

    boolean isGameOver = false;

    private Foilermaker controller;
    private FoilMakerNetworkProtocol protocol;

    public final static String GAME_TITLE = "FoilerMaker";
    public final static int FRAME_WIDTH = 300;
    public final static int FRAME_HEIGHT = 500;

    private JLabel title = new JLabel("FoilerMaker!");
    private JLabel statusMessage = new JLabel("Enter the valid server host and the port number");
    private JLabel serverHostLabel = new JLabel ("Server Host: ");
    private JLabel portNumberLabel = new JLabel("Port Number: ");
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");

    JButton connectButton = new JButton ("Connect");
    JButton loginButton = new JButton ("Login");
    JButton registerButton = new JButton("Register");
    JButton startNewGame = new JButton("Start New Game");
    JButton joinAGame = new JButton("Join a Game");
    JButton startGame = new JButton ("Start Game");
    JButton joinGame = new JButton("Join Game");
    JButton submitSuggestion = new JButton("Submit Suggestion");
    JButton submitOption = new JButton("Submit Option");
    JButton nextRound = new JButton("Next Round");

    JTextField serverHostInput = new JTextField(8);
    JTextField portNumberInput = new JTextField(8);
    JTextField usernameInput = new JTextField(8);
    JPasswordField passwordInput = new JPasswordField(8);
    JTextField participantsOutput = new JTextField();
    JTextField gameKeyInput = new JTextField(3);
    JTextField gameKeyOutput = new JTextField(3);
    JTextField suggestionInput = new JTextField(8);
    JTextField descriptionOutput = new JTextField();

    JPanel top = new JPanel();
    JPanel middle = new JPanel(new CardLayout());
    JPanel bottom = new JPanel();

    JPanel CONNECT_STATE = new JPanel(new GridBagLayout());
    JPanel LOGIN_REGISTER_STATE = new JPanel (new GridBagLayout());
    JPanel NEW_OR_JOIN_GAME_STATE = new JPanel(new GridBagLayout());
    JPanel LEADER_VIEW_STATE = new JPanel(new GridBagLayout());
    JPanel PARTICIPANT_VIEW_STATE = new JPanel(new GridBagLayout());
    JPanel PARTICIPANT_WAIT_VIEW_STATE = new JPanel(new GridBagLayout());
    JPanel GAME_GIVE_SUGGESTION_STATE = new JPanel (new GridBagLayout());
    JPanel GAME_SUBMIT_OPTION_STATE = new JPanel (new GridBagLayout());
    JPanel GAME_RESULT_STATE = new JPanel (new GridBagLayout());


    public FMView(Foilermaker controller) {
        this.controller = controller;
        setTitle(GAME_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpGUI();
//        this.pack();
        setVisible(true);
    }

    public void setStatusMessage(String msg) {
        statusMessage.setText(msg);
    }

    public void setUpGUI() {
        top.add(title);
        add(top, BorderLayout.NORTH);

        middle.setBorder(BorderFactory.createEtchedBorder());
        add(middle, BorderLayout.CENTER);

        bottom.add(statusMessage);
        add(bottom, BorderLayout.SOUTH);

        addToMiddlePanel();
        showConnectState();
        showLoginRegisterState();
        showNewOrJoinGameState();
        showLeaderView();
        showParticipantView();
        showParticipantWaitView();
        showGameGiveSuggestionState();
        showGameSubmitOptionState();
        showGameResultState();

    }

    public void addToMiddlePanel() {
        middle.add(CONNECT_STATE, "CONNECT_STATE");
        middle.add(LOGIN_REGISTER_STATE, "LOGIN_REGISTER_STATE");
        middle.add(NEW_OR_JOIN_GAME_STATE, "NEW_OR_JOIN_GAME_STATE");
        middle.add(LEADER_VIEW_STATE, "LEADER_VIEW_STATE");
        middle.add(PARTICIPANT_VIEW_STATE, "PARTICIPANT_VIEW_STATE");
        middle.add(PARTICIPANT_WAIT_VIEW_STATE, "PARTICIPANT_WAIT_VIEW_STATE");
        middle.add(GAME_GIVE_SUGGESTION_STATE, "GAME_GIVE_SUGGESTION_STATE");
        middle.add(GAME_SUBMIT_OPTION_STATE, "GAME_SUBMIT_OPTION_STATE");
        middle.add(GAME_RESULT_STATE, "GAME_RESULT_STATE");
    }

    public void showConnectState() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        CONNECT_STATE.add(serverHostLabel, c);
        c.gridy++;
        CONNECT_STATE.add(portNumberLabel, c);
        c.gridy++;

        c.gridx = 1;
        c.gridy = 0;

        CONNECT_STATE.add(serverHostInput, c);
        c.gridy++;
        CONNECT_STATE.add(portNumberInput, c);

        c.gridy++;
        CONNECT_STATE.add(connectButton, c);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO The button does not care whether serverHost or serverPort is valid
                controller.connectToServer();
                CardLayout c = (CardLayout) middle.getLayout();
                c.show(middle, "LOGIN_REGISTER_STATE");
                setStatusMessage("Please login or register to play!");
            }
        });
    }

    public void showLoginRegisterState() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        LOGIN_REGISTER_STATE.add(usernameLabel, c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(passwordLabel, c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(loginButton, c);
        c.gridx = 1;
        c.gridy = 0;
        LOGIN_REGISTER_STATE.add(usernameInput, c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(passwordInput, c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(registerButton, c);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Do something when login button is clicked
                CardLayout c = (CardLayout) middle.getLayout();
                c.show(middle, "NEW_OR_JOIN_GAME_STATE");
                setStatusMessage("Welcome!");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Do something when register button is clicked
//                controller.sendNewUserRequest();
//                System.out.println(controller.getServerResponse());
//                if (controller.getServerResponse().equals(FoilMakerNetworkProtocol.MSG_DETAIL_T.SUCCESS)); {
//                    setStatusMessage("New user created!");
//                }
            }
        });
    }

    public void showNewOrJoinGameState() {

        NEW_OR_JOIN_GAME_STATE.add(startNewGame);
        NEW_OR_JOIN_GAME_STATE.add(joinAGame);

        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Do something when 'Start New Game' button is clicked
                CardLayout c = (CardLayout) middle.getLayout();
                c.show(middle, "LEADER_VIEW_STATE");
                setStatusMessage("Game started: You are the leader");
            }
        });

        joinAGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO DO something when 'Join a Game' button is clicked
                CardLayout c = (CardLayout) middle.getLayout();
                c.show(middle, "PARTICIPANT_VIEW_STATE");
            }
        });

    }

    public void showLeaderView() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        JLabel instruction = new JLabel("Others should use this key to join your game");
        LEADER_VIEW_STATE.add(instruction);
        c.gridy++;
        LEADER_VIEW_STATE.add(gameKeyOutput, c);
        c.gridy++;
        participantsOutput.setSize(new Dimension (100, 100)); // TODO Fix this
        LEADER_VIEW_STATE.add(participantsOutput, c);
        c.gridy++;
        LEADER_VIEW_STATE.add(startGame, c); // TODO This needs to be disabled until one player joins

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Do something when 'Start Game' button is clicked
            }
        });
    }

    public void showParticipantView() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        JLabel instruction = new JLabel("Enter the game key to join a game");
        PARTICIPANT_VIEW_STATE.add(instruction);
        c.gridy++;
        PARTICIPANT_VIEW_STATE.add(gameKeyInput, c);
        c.gridy++;
        PARTICIPANT_VIEW_STATE.add(joinGame, c);

        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Do something when 'Join Game' button is clicked
                CardLayout c = (CardLayout) middle.getLayout();
                c.show(middle, "PARTICIPANT_WAIT_VIEW_STATE");
                setStatusMessage("Joined game: waiting for leader");
            }
        });
    }

    public void showParticipantWaitView() {
        JLabel status = new JLabel ("Waiting for leader ...");
        PARTICIPANT_WAIT_VIEW_STATE.add(status);
    }

    public void showGameGiveSuggestionState() {

        // TODO

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        JLabel instruction = new JLabel ("What is the word for");
        GAME_GIVE_SUGGESTION_STATE.add(instruction);
        GAME_GIVE_SUGGESTION_STATE.add(descriptionOutput, c);
        GAME_GIVE_SUGGESTION_STATE.add(suggestionInput, c);
        GAME_GIVE_SUGGESTION_STATE.add(submitSuggestion, c);

        setStatusMessage("Enter your suggestion");

    }

    public void showGameSubmitOptionState() {

        // TODO

        GridBagConstraints c = new GridBagConstraints();

        JLabel instruction = new JLabel ("Pick your option below");
        GAME_SUBMIT_OPTION_STATE.add(instruction);
        // TODO Add in the options here...
        GAME_SUBMIT_OPTION_STATE.add(submitOption, c);
        setStatusMessage("Pick your choice");

    }

    public void showGameResultState() {

        // TODO

        if (isGameOver == true) {
            setStatusMessage("Game over!");
        } else {
            setStatusMessage("Click <Next Round> when ready");
        }
    }

    public void actionPerformed(ActionEvent e) {}
}
