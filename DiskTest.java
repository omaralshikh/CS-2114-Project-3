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
 * test class for Disk
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class DiskTest extends TestCase {

    private Disk disk;


    /**
     * set up method left empty
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // intentionally left empty
    }


    /**
     * tests compareTo method
     */
    public void testCompareTo() {
        disk = new Disk(5);
        Disk otherDisk = new Disk(7);
        assertTrue(disk.compareTo(otherDisk) < 0);

        Disk otherDisk2 = new Disk(3);
        assertTrue(disk.compareTo(otherDisk2) > 0);

        Disk otherDisk3 = new Disk(5);
        assertEquals(0, disk.compareTo(otherDisk3));
        Disk otherDisk4 = null;
        Exception thrown = null;
        try {
            // call method here that will throw the exception
            disk.compareTo(otherDisk4);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);

    }


    /**
     * tests ToString method
     */
    public void testToString() {
        // width value set
        disk = new Disk(5);
        assertEquals("5", disk.toString());
        disk = new Disk(20);
        assertEquals("20", disk.toString());

    }


    /**
     * test Equals method
     */
    public void testEquals() {
        Object obj = new Object();
        disk = new Disk(10);
        Disk d1 = null;
        Disk d2;
        Disk d3;
        Disk d4;

        d2 = new Disk(2);
        d3 = new Disk(2);
        d4 = new Disk(6);

        assertTrue(disk.equals(disk));
        assertFalse(disk.equals(d1));
        assertTrue(d2.equals(d3));
        assertFalse(d2.equals(d4));
        assertFalse(disk.equals(obj));
        assertFalse(disk.equals(d3));

        disk = new Disk(2);
        assertTrue(disk.equals(d2));

    }

}
