/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

import java.util.Observable;

/**
 * solver class for the puzzle
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class HanoiSolver extends Observable {
    // fields
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;


    /**
     * constructor
     * 
     * @param numDisks
     *            number of disks
     */
    public HanoiSolver(int numDisks) {
        // initialize numDisks
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);

    }


    /**
     * disk method
     * 
     * @return integer number of numDisks
     */
    public int disks() {
        return numDisks;

    }


    /**
     * method that uses switch to set positions
     * 
     * @param pos
     *            position of tower
     * @return corresponding name for position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;

            case MIDDLE:
                return middle;

            case RIGHT:
                return right;
            default:
                return middle;

        }

    }


    /**
     * ToString method that sets up towers to be one after another
     * 
     * @return return towers from left to right
     */
    public String toString() {

        return left.toString() + middle.toString() + right.toString();

    }


    /**
     * move method that moves disks from one tower to another
     * 
     * @param source
     *            disk to be removed from tower
     * @param destination
     *            disk that is removed destitnation
     */
    private void move(Tower source, Tower destination) {
        // remove (pop)
        Disk src = source.pop();
        destination.push(src);
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * recursive method for tower
     * 
     * @param currentDisks
     *            disk that is on top
     * @param startPole
     *            right pole
     * @param tempPole
     *            middle pole
     * @param endPole
     *            left pole
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        // base for recursive call
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        // recursive call
        else {

            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            // call on move method
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);

        }

    }


    /**
     * solve method that is put into action once solve button is clicked.
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }

}
