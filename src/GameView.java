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
public class FMView extends JFrame implements ActionListener{

    private Foilermaker controller;

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

    JTextField serverHostInput = new JTextField(8);
    JTextField portNumberInput = new JTextField(8);
    JTextField usernameInput = new JTextField(8);
    JPasswordField passwordInput = new JPasswordField(8);

    JPanel top = new JPanel();
    JPanel middle = new JPanel(new CardLayout());
    JPanel bottom = new JPanel();

    JPanel CONNECT_STATE = new JPanel(new GridBagLayout());
    JPanel LOGIN_REGISTER_STATE = new JPanel (new GridBagLayout());
    JPanel NEW_OR_JOIN_GAME_STATE = new JPanel();


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

    }

    public void addToMiddlePanel() {
        middle.add(CONNECT_STATE, "CONNECT_STATE");
        middle.add(LOGIN_REGISTER_STATE, "LOGIN_REGISTER_STATE");
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
    }

    public void actionPerformed(ActionEvent e) {}
}
