/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Shape;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;

/**
 * puzzle class that creates the window and puzzle
 * 
 * @author omaralshikh
 * @version 10/21/2019
 *
 */
public class PuzzleWindow implements Observer {
    // fields
    private HanoiSolver game;
    private Window window;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Shape base;

    private Button solveButton;
    // static constant values
    public static final int WIDTH_FACTOR = 20;
    public static final int DISK_GAP = 3;
    public static final int DISK_HEIGHT = 8;


    /**
     * sleep method given
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {

        }
    }


    /**
     * method for when user clicks button
     * 
     * @param button
     *            solve button that shows up in window
     * 
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * method that moves the disk and sets the positions if the poles
     * 
     * @param position
     *            position of towers
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();

        Shape currentPole;

        if (position == Position.LEFT) {

            currentPole = left;

        }
        else if (position == Position.RIGHT) {
            currentPole = right;

        }
        else {
            currentPole = middle;

        }
        // pole placements
        int PoleX = currentPole.getX() + (currentPole.getWidth() - currentDisk
            .getWidth()) / 2;
        int PoleY = currentPole.getY() + (currentPole.getHeight() - game
            .getTower(position).size() * (DISK_HEIGHT + DISK_GAP));
        currentDisk.setX(PoleX);
        currentDisk.setY(PoleY);

    }


    /**
     * constructor
     * 
     * @param game
     *            implement hanoi solver game
     */
    public PuzzleWindow(HanoiSolver game) {
        // initialize game
        this.game = game;
        game.addObserver(this);
        // create window
        window = new Window();
        // window title up top
        window.setTitle("Tower of Hanoi");
        // size and placement of pole/towers
        left = new Shape(120, 55, 5, 262, Color.black);
        middle = new Shape(270, 55, 5, 262, Color.blue);
        right = new Shape(420, 55, 5, 262, Color.red);
        // gives a shape of a base under the toers
        base = new Shape(0, 315, 700, 15, Color.black);
        // color of towers
        left.setBackgroundColor(Color.WHITE);
        right.setBackgroundColor(Color.WHITE);
        middle.setBackgroundColor(Color.WHITE);
        base.setBackgroundColor(Color.BLACK);
        // for loop for disks shape and movement
        for (int i = game.disks(); i > 0; i--) {

            Disk disk;
            disk = new Disk(i * WIDTH_FACTOR);
            window.addShape(disk);
            game.getTower(Position.RIGHT).push(disk);
            moveDisk(Position.RIGHT);

        } // end for loop
          // adding shapes to window
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        window.addShape(base);
        // creating and adding the solve button to the window
        solveButton = new Button("Solve");
        window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");

    }


    /**
     * update method that updates the towers
     * 
     * @param o
     *            Observable parameter
     * @param arg
     *            arguments for update
     */
    @Override
    public void update(Observable o, Object arg) {

        if (arg.getClass() == Position.class) {

            moveDisk((Position)arg);
            sleep();
        } // end if

    }

} // end class
