/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

import java.util.EmptyStackException;
import org.junit.Before;
import student.TestCase;

/**
 * test class for linkedStack
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class LinkedStackTest extends TestCase {
    // fields
    private LinkedStack<String> link;
    private String anEntry;


    /**
     * setup method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // initialzie field
        link = new LinkedStack<String>();
    }


    /**
     * test size method
     */
    public void testSize() {
        assertEquals(0, link.size());
        link.push(anEntry);
        assertEquals(1, link.size());

    }


    /**
     * tests clear method
     */
    public void testClear() {

        link.push(anEntry);
        link.clear();
        assertEquals(0, link.size());

    }


    /**
     * tests if stack is empty
     */
    public void testIsEmpty() {

        assertTrue(link.isEmpty());
        anEntry = "red";
        link.push(anEntry);
        assertFalse(link.isEmpty());

    }


    /**
     * test peek method
     */
    public void testPeek() {

        Exception thrown = null;
        try {
            // call method here that will throw the exception
            link.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

        anEntry = "cs";
        link.push(anEntry);

        assertEquals("cs", link.peek());

    }


    /**
     * test pop method that removes items
     */
    public void testPop() {

        anEntry = "tower";
        link.push(anEntry);
        assertEquals(1, link.size());
        assertEquals("tower", link.pop());
        assertEquals(0, link.size());
        Exception thrown = null;
        try {
            // call pop method
            link.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

    }


    /**
     * tests push method that adds items
     */
    public void testPush() {

        assertEquals(0, link.size());
        anEntry = "hanoi";
        link.push(anEntry);
        assertEquals(1, link.size());

    }


    /**
     * test toString method
     */
    public void testToString() {

        anEntry = "tower";
        String anEntry2 = "hanoi";
        link.push(anEntry);
        assertEquals(1, link.size());
        assertEquals("[tower]", link.toString());
        link.push(anEntry2);
        assertEquals("[hanoi, tower]", link.toString());

    }

}
