/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

import org.junit.Before;
import student.TestCase;

/**
 * test class for HanoiSolver
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class HanoiSolverTest extends TestCase {
    // field
    private HanoiSolver han;


    /**
     * set up method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // initialize field
        han = new HanoiSolver(3);

    }


    /**
     * tests disk method
     */
    public void testDisks() {
        assertEquals(3, han.disks());

    }


    /**
     * tests getTower method
     */
    public void testGetTower() {

        assertEquals(Position.LEFT, han.getTower(Position.LEFT).position());
        assertEquals(Position.RIGHT, han.getTower(Position.RIGHT).position());
        assertEquals(Position.MIDDLE, han.getTower(Position.MIDDLE).position());
        assertEquals(Position.MIDDLE, han.getTower(Position.DEFAULT)
            .position());

    }


    /**
     * tests ToString method
     **/
    public void testToString() {

        Disk disk;
        Disk disk2;
        Disk disk3;
        disk = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(30);

        han.getTower(Position.LEFT).push(disk);
        han.getTower(Position.MIDDLE).push(disk2);
        han.getTower(Position.RIGHT).push(disk3);

        assertEquals("[10][20][30]", han.toString());

    }


    /**
     * tests solve method
     */
    public void testSolve() {

        Disk disk;
        Disk disk2;
        Disk disk3;

        disk = new Disk(5);
        disk2 = new Disk(10);
        disk3 = new Disk(15);
        han.getTower(Position.RIGHT).push(disk3);
        han.getTower(Position.RIGHT).push(disk2);
        han.getTower(Position.RIGHT).push(disk);
        assertEquals("[][][5, 10, 15]", han.toString());
        han.solve();
        assertEquals("[5, 10, 15][][]", han.toString());

    }

}
