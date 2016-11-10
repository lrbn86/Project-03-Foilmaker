/**
 * Foilmaker.java
 *
 * Game Main Entry Point
 *
 * @author Brandon Nguyen & Daniel Acevedo, nguye299@purdue.edu & acevedd@purdue.edu, Lab Section G06
 *
 * @version November 10, 2016
 *
 */
public class Foilmaker {

    private FMController controller;
    private FMView view;
    private FMModel model;

    public Foilmaker() {
        view = new FMView();
        model = new FMModel();
        controller = new FMController(model, view);
    }

    public static void main(String[] args) {
        Foilmaker game = new Foilmaker();
    }

}
