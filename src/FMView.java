import javax.swing.*;
import java.awt.*;

/**
 * FMView.java
 *
 * GUI
 *
 * Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version November 11, 2016
 *
 */
public class FMView extends JFrame {

    private JButton loginButton = new JButton ("Login");
    private JButton registerButton = new JButton ("Register");
    private JButton startNewGameButton = new JButton ("Start New Game");
    private JButton joinAGameButton = new JButton ("Join a Game");
    private JButton startGameButton = new JButton ("Start Game");
    private JButton joinGameButton = new JButton ("Join Game");
    private JButton submitSuggestionButton = new JButton ("Submit Suggestion");
    private JButton submitOptionButton = new JButton ("Submit Option");
    private JButton nextRoundButton = new JButton ("Next Round");
    private JRadioButton optionOne = new JRadioButton();
    private JRadioButton optionTwo = new JRadioButton();
    private JRadioButton optionThree = new JRadioButton();
    
    private JTextField usernameInput = new JTextField (8);
    private JPasswordField passwordInput = new JPasswordField (8);
    private JTextField gameKeyOutput = new JTextField (3);
    private JTextField gameKeyInput = new JTextField (3);
    private JTextField suggestionInput = new JTextField(10);
    private JTextArea participantsOutput = new JTextArea(3, 0);

    private JLabel title = new JLabel ("FoilMaker!");
    private JLabel statusMessage = new JLabel ();
    private JLabel word = new JLabel();
    private JLabel descriptionOutput = new JLabel();

    private JPanel top = new JPanel();
    private JPanel states = new JPanel (new CardLayout());
    private JPanel bottom = new JPanel();
//    private JPanel CONNECT_STATE = new JPanel(new GridBagLayout());
    private JPanel LOGIN_REGISTER_STATE = new JPanel (new GridBagLayout());
    private JPanel NEW_OR_JOIN_GAME_STATE = new JPanel(new GridBagLayout());
    private JPanel LEADER_VIEW_STATE = new JPanel(new GridBagLayout());
    private JPanel PARTICIPANT_VIEW_STATE = new JPanel(new GridBagLayout());
    private JPanel PARTICIPANT_WAIT_VIEW_STATE = new JPanel(new GridBagLayout());
    private JPanel GIVE_SUGGESTION_STATE = new JPanel (new GridBagLayout());
    private JPanel SUBMIT_OPTION_STATE = new JPanel (new GridBagLayout());
    private JPanel RESULT_STATE = new JPanel (new GridBagLayout());

    public FMView() {
        setTitle("FoilMaker");
        setPreferredSize(new Dimension(300, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setupGUI();
        setVisible(true);
    }

    public void setupGUI() {
        top.add(title);
        add(top, BorderLayout.NORTH);

        states.setBorder(BorderFactory.createEtchedBorder());

        states.add(getLoginRegisterState(), "LOGIN_REGISTER_STATE");
        states.add(getNewOrJoinGameState(), "NEW_OR_JOIN_GAME_STATE");
        states.add(getLeaderViewState(), "LEADER_VIEW_STATE");
        states.add(getParticipantViewState(), "PARTICIPANT_VIEW_STATE");
        states.add(getParticipantWaitViewState(), "PARTICIPANT_WAIT_VIEW_STATE");
        states.add(getGiveSuggestionState(), "GIVE_SUGGESTION_STATE");
        states.add(getSubmitOptionState(), "SUBMIT_OPTION_STATE");
        states.add(getResultState(), "RESULT_STATE");
        add(states, BorderLayout.CENTER);

        bottom.add(statusMessage);
        add(bottom, BorderLayout.SOUTH);
    }

    public void setStatusMessage(String message) {
        this.statusMessage.setText(message);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setView(String view) {
        CardLayout c = (CardLayout) states.getLayout();
        c.show(states, view);
    }

    public JPanel getLoginRegisterState() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        LOGIN_REGISTER_STATE.add(new JLabel("Username:"), c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(new JLabel("Password:"), c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(loginButton, c);
        c.gridx = 1;
        c.gridy = 0;
        LOGIN_REGISTER_STATE.add(usernameInput, c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(passwordInput, c);
        c.gridy++;
        LOGIN_REGISTER_STATE.add(registerButton, c);

        return LOGIN_REGISTER_STATE;
    }

    public JPanel getNewOrJoinGameState() {
        NEW_OR_JOIN_GAME_STATE.add(startNewGameButton);
        NEW_OR_JOIN_GAME_STATE.add(joinAGameButton);

        return NEW_OR_JOIN_GAME_STATE;
    }

    public JPanel getLeaderViewState() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        LEADER_VIEW_STATE.add(new JLabel("Others should use this key to join"), c);
        c.gridy++;
        LEADER_VIEW_STATE.add (gameKeyOutput, c);
        c.gridy++;
        participantsOutput.setPreferredSize(new Dimension (200, 250));
        participantsOutput.setBorder(BorderFactory.createTitledBorder("Participants"));
        LEADER_VIEW_STATE.add (participantsOutput, c);
        c.gridy++;
        startGameButton.setEnabled(false);
        LEADER_VIEW_STATE.add (startGameButton, c);

        return LEADER_VIEW_STATE;
    }



    public JPanel getParticipantViewState() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        PARTICIPANT_VIEW_STATE.add(new JLabel("Enter the game key to join a game"), c);
        c.gridy++;
        PARTICIPANT_VIEW_STATE.add(gameKeyInput, c);
        c.gridy++;
        PARTICIPANT_VIEW_STATE.add(joinGameButton, c);

        return PARTICIPANT_VIEW_STATE;
    }

    public JPanel getParticipantWaitViewState() {

        PARTICIPANT_WAIT_VIEW_STATE.add(new JLabel("Waiting for leader ..."));

        return PARTICIPANT_WAIT_VIEW_STATE;
    }

    // TODO
    public JPanel getGiveSuggestionState() {
    	GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        GIVE_SUGGESTION_STATE.add(new JLabel("What is the word for"), c);
        c.gridy++;
        descriptionOutput.setPreferredSize(new Dimension(200, 250));
        GIVE_SUGGESTION_STATE.add(descriptionOutput, c);
        c.gridy++;
        suggestionInput.setBorder(BorderFactory.createTitledBorder("Your suggestion"));
        GIVE_SUGGESTION_STATE.add(suggestionInput, c);
        c.gridy++;
        GIVE_SUGGESTION_STATE.add(submitSuggestionButton, c);

        return GIVE_SUGGESTION_STATE;
    }

    public JPanel getSubmitOptionState() {
    	GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        
        SUBMIT_OPTION_STATE.add(new JLabel("Pick your option below"), c);
        c.gridy++;
        
        SUBMIT_OPTION_STATE.add(this.optionOne, c);
        c.gridy++;
        SUBMIT_OPTION_STATE.add(this.optionTwo, c);
        c.gridy++;
        SUBMIT_OPTION_STATE.add(this.optionThree, c);
        c.gridy++;
        SUBMIT_OPTION_STATE.add(this.submitOptionButton, c);
        c.gridy++;
        return SUBMIT_OPTION_STATE;
    }

    public JPanel getResultState() {
        return RESULT_STATE;
    }


    public JButton getLoginButton() {
        return this.loginButton;
    }

    public JButton getRegisterButton() {
        return this.registerButton;
    }

    public JButton getStartNewGameButton() {
        return this.startNewGameButton;
    }

    public JButton getJoinAGameButton() {
        return this.joinAGameButton;
    }

    public JButton getStartGameButton() {
        return this.startGameButton;
    }

    public JButton getJoinGameButton() {
        return this.joinGameButton;
    }

    public JButton getSubmitSuggestionButton() {
        return this.submitSuggestionButton;
    }

    public JButton getSubmitOptionButton() {
        return this.submitOptionButton;
    }

    public JButton getNextRoundButton() {
        return this.nextRoundButton;
    }

    public JTextField getUsernameInput() {
        return this.usernameInput;
    }

    public JTextField getGameKeyOutput() {
        return this.gameKeyOutput;
    }

    public JTextField getGameKeyInput() {
        return this.gameKeyInput;
    }

    public JTextArea getParticipantsOutput() {
        return this.participantsOutput;
    }

    public JLabel getDescriptionOutput() {
        return this.descriptionOutput;
    }

    public JPasswordField getPasswordInput() {
        return this.passwordInput;
    }
    
    public JTextField getSuggestionInput(){
    	return this.suggestionInput;
    }
    
    public JRadioButton getOptionOne(){
    	return this.optionOne;
    }
    
    public JRadioButton getOptionTwo(){
    	return this.optionTwo;
    }
    
    public JRadioButton getOptionThree(){
    	return this.optionThree;
    }
}
