import javax.swing.*;

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

    public final String TITLE = "Psych";
    public final int FRAME_WIDTH = 300;
    public final int FRAME_HEIGHT = 500;

    // Buttons
    private JButton login = new JButton ("Login");
    private JButton register = new JButton ("Register");
    private JButton startNewGame = new JButton ("Start New Game");
    private JButton joinGame = new JButton ("Join a Game");
    private JButton submitSuggestion = new JButton ("Submit Suggestion");
    private JButton submitOption = new JButton ("Submit Option");
    private JButton nextRound = new JButton ("Next Round");

    // Input Fields
    private JTextField gameKeyInput = new JTextField();
    private JTextField userSuggestionInput = new JTextField();



    public GameView() {
        setTitle(TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}