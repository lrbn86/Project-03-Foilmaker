import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * FMView.java
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
    private FMModel model;
    public final static String GAME_TITLE = "FoilerMaker";
    public final static int FRAME_WIDTH = 310;
    public final static int FRAME_HEIGHT = 500;

    private JLabel title = new JLabel("FoilerMaker!");
    private JLabel statusMessage = new JLabel("Login or register");
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel userInstruction = new JLabel("Other users should use this key to join your game: ");
    private JLabel joinInstruction = new JLabel("Enter the game key to join a game");
    private JLabel useKey = new JLabel("Something");
    private JLabel waiting = new JLabel("Waiting for leader...");

    JButton connectButton = new JButton ("Connect");
    JButton loginButton = new JButton ("Login");
    JButton registerButton = new JButton("Register");
    JButton newGameButton = new JButton("Start a new game");
    JButton joinGameButton = new JButton("Join a game");
    JButton startGame = new JButton("Start game");
    JButton joinGame = new JButton("Join game");

    JTextField usernameInput = new JTextField(8);
    JTextField keyInput = new JTextField(3);
    JPasswordField passwordInput = new JPasswordField(8);

    JPanel top = new JPanel();
    JPanel middle = new JPanel(new CardLayout());
    JPanel bottom = new JPanel();
    

    JPanel CONNECT_STATE = new JPanel(new GridBagLayout());
    JPanel LOGIN_REGISTER_STATE = new JPanel (new GridBagLayout());
    JPanel NEW_OR_JOIN_GAME_STATE = new JPanel(new GridBagLayout());
    JPanel NEW_GAME_STATE = new JPanel(new GridBagLayout());
    JPanel JOIN_GAME_STATE = new JPanel(new GridBagLayout());
    JPanel activity = new JPanel();
    JPanel wait = new JPanel(new GridBagLayout());

    public FMView(Foilermaker controller, FMModel model) {
        this.controller = controller;
        this.model = model;
        setTitle(GAME_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpGUI();
        //this.pack();		commented out as it changes the set frame width & height
        setVisible(true);
    }
    public void setTitleMessage(String msg){
    	title.setText(msg);
    }
    public void setStatusMessage(String msg) {
        statusMessage.setText(msg);
    }
    public void setUseKey(String key){
    	useKey.setText(key);
    }
    public void setUpGUI() {
        top.add(title);
        add(top, BorderLayout.NORTH);

        middle.setBorder(BorderFactory.createEtchedBorder());
        add(middle, BorderLayout.CENTER);

        bottom.add(statusMessage);
        add(bottom, BorderLayout.SOUTH);
       
        addToMiddlePanel();
        //do{
        showLoginRegisterState();
        //}while();
        showNewOrJoinGameState();
        showNewGameState();
        showJoinGameState();
        showWaitState();

    }

    public void addToMiddlePanel() {
        middle.add(LOGIN_REGISTER_STATE, "LOGIN_REGISTER_STATE");
        middle.add(NEW_OR_JOIN_GAME_STATE, "NEW_OR_JOIN_GAME_STATE");
        middle.add(NEW_GAME_STATE, "NEW_GAME_STATE");
        middle.add(JOIN_GAME_STATE, "JOIN_GAME_STATE");
        middle.add(wait, "wait");
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
        
        loginButton.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent arg0){
    			
			try{
				controller.loginUser();
			}catch(IOException e){
			}
			if(controller.getExceptionThrown() == false){
    			CardLayout c = (CardLayout) middle.getLayout();
    			setStatusMessage("Welcome!");
                c.show(middle, "NEW_OR_JOIN_GAME_STATE");
                setTitleMessage(model.getUsername());
			}else{
				setStatusMessage(controller.getServerInput());
			}
    		}
    	});
        
    	registerButton.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent arg0){
    			try {
					controller.createUser();
				} catch (Exception e) {
				}
    			
    			if(controller.getExceptionThrown() == false){
        			setStatusMessage("New user created");
    			}else{
    				setStatusMessage(controller.getServerInput());
    			}
    		}
    	});
    	
    }
    
    public void showNewOrJoinGameState(){
    	GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 0;
        c.gridy = 0;
        
        NEW_OR_JOIN_GAME_STATE.add(newGameButton, c);
        c.gridx = 1;
        c.gridy = 0;
      
        
        NEW_OR_JOIN_GAME_STATE.add(joinGameButton, c);
        
        
        newGameButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        		try {
					controller.startNewGame();
				} catch (IOException e) {
				}
        		CardLayout c = (CardLayout) middle.getLayout();
        		c.show(middle, "NEW_GAME_STATE");
        		setStatusMessage("Game started: You are the leader");
        		setUseKey(model.getGameKey());
        		
        		
        	}
        });
        
        joinGameButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        		CardLayout c = (CardLayout) middle.getLayout();
        		c.show(middle, "JOIN_GAME_STATE");
        		setStatusMessage("Welcome!");
        		
        	}
        });
        
    }
    
    //TODO: Fix host's panel to match that in handout.
    public void showNewGameState(){
    	GridBagConstraints c = new GridBagConstraints();
    	
    	c.gridx = 0;
        c.gridy = 0;
        
        NEW_GAME_STATE.add(userInstruction, c);
        c.gridy++;
        
        NEW_GAME_STATE.add(useKey, c);
        c.gridy++;
       
        activity.setBorder(BorderFactory.createTitledBorder("Participants"));
        activity.setPreferredSize(new Dimension(300, 200));
        activity.setBackground(Color.LIGHT_GRAY);
        NEW_GAME_STATE.add(activity);
        c.gridx--;
        c.gridy--;
        
        NEW_GAME_STATE.add(startGame,c);
        c.gridy++;
        
        //disable or enables start game button
        if(model.getNumOfParticipants() < 1){
        	startGame.setEnabled(false);
        }else{
        	startGame.setEnabled(true);
        }
        
        
        startGame.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        	
        		startGame.setEnabled(true);
        		try {
					//create controller.startGame();
				} catch (IOException e) {
				}
        		setStatusMessage("Game started: You are the leader");
        		
        	}
        	
        });
        
    }
    
    public void showJoinGameState(){
    	GridBagConstraints c = new GridBagConstraints();
    	
    	c.gridx = 0;
        c.gridy = 0;
        
        JOIN_GAME_STATE.add(joinInstruction, c);
        c.gridy++;
        
        JOIN_GAME_STATE.add(keyInput, c);
        c.gridy++;
        
        JOIN_GAME_STATE.add(joinGame, c);
        c.gridx--;
        c.gridy--;
        
        joinGame.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        		try {
					controller.joinGame();
				} catch (IOException e) {
				}
        		CardLayout c = (CardLayout) middle.getLayout();
        		c.show(middle, "wait");
        		setStatusMessage("Joined game: waiting for leader");
        	}
        	
        });
    }
    
    public void showWaitState(){
    	GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 0;
        c.gridy = 0;
        
        wait.add(waiting, c);
    	
    }
    

    public void actionPerformed(ActionEvent e) {
   
    }
