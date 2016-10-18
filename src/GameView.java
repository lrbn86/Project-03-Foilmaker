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

    public GameView() {
        setTitle(TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}