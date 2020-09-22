/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

/**
 * tower class
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class Tower extends LinkedStack<Disk> {

    private Position pos;


    /**
     * constructor
     * 
     * @param position
     *            position of tower
     */
    public Tower(Position position) {

        super();

        pos = position;

    }


    /**
     * position method
     * 
     * @return position of tower
     */
    public Position position() {
        return pos;
    }


    /**
     * push method that adds disks to tower
     * 
     * @param disk
     *            disk to be added
     */
    @Override
    public void push(Disk disk) {

        if (disk == null) {
            throw new IllegalArgumentException();
        } // end if

        if (this.isEmpty()) {
            super.push(disk);
        } // end if

        else if (disk.compareTo(peek()) == -1) {
            super.push(disk);

        } // end else if
        else {
            throw new IllegalStateException();
        } // end else

    }

} // end class
