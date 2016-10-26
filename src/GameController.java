/**
 * GameController.java
 *
 * This class manipulates data in the model as per user interactions.
 * Implements network programming pits, application protocol, etc.
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version October 18, 2016
 *
 */
public class GameController {

    private GameView view;

    private GameController() {
        view = new GameView();
    }

    public static void main(String[] args) {
        GameController demo = new GameController();
    }

}
