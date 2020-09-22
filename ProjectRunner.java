/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

/**
 * Main class to run the code and generate the puzzle for user to be able to
 * interact with
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class ProjectRunner {

    /**
     * Main method
     * 
     * @param args
     *            parameter for main
     */
    public static void main(String[] args) {

        int disks = 5;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);

            HanoiSolver hanoi;
            hanoi = new HanoiSolver(disks);
            new PuzzleWindow(hanoi);

        }
        else {
            HanoiSolver hanoi;
            hanoi = new HanoiSolver(disks);
            new PuzzleWindow(hanoi);
        }

    } // end main

} // end class
