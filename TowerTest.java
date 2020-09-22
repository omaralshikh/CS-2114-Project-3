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
 * tower test class
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class TowerTest extends TestCase {

    private Tower tower;


    /**
     * set up method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        tower = new Tower(Position.LEFT);

    }


    /**
     * tests method for position of tower
     */
    public void testPosition() {
        Tower tower2;
        Tower tower3;
        Tower tower4;
        tower2 = new Tower(Position.MIDDLE);
        tower3 = new Tower(Position.RIGHT);
        tower4 = new Tower(Position.DEFAULT);

        assertEquals(Position.LEFT, tower.position());
        assertEquals(Position.MIDDLE, tower2.position());
        assertEquals(Position.RIGHT, tower3.position());
        assertEquals(Position.DEFAULT, tower4.position());

    }


    /**
     * tests push method for adding disks to tower
     */
    public void testPush() {
        Disk disk;
        disk = new Disk(5);
        assertEquals(0, tower.size());
        tower.push(disk);
        assertEquals(1, tower.size());
        Disk disk2;
        Disk disk3;
        Disk disk4;
        disk2 = new Disk(4);
        disk3 = new Disk(6);
        tower.push(disk2);
        assertEquals(2, tower.size());
        Exception thrown = null;
        try {
            // call push method
            tower.push(disk3);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalStateException);

        disk4 = null;

        Exception thrown2 = null;

        try {
            // call push method
            tower.push(disk4);
        }
        catch (Exception exception) {
            thrown2 = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown2);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown2 instanceof IllegalArgumentException);

    }

}
