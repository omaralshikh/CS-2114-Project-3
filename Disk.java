/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package towerofhanoi;

import CS2114.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * Disk class that sets up the disks in towers
 * 
 * @author omaralshikh
 * @version 10/21/2019
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * constructor
     * 
     * @param width
     *            width of disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        // generating random number 0-255
        TestableRandom ranNum;

        ranNum = new TestableRandom();
        int count = ranNum.nextInt(256);
        int count2 = ranNum.nextInt(256);
        int count3 = ranNum.nextInt(256);

        this.setBackgroundColor(new Color(count, count2, count3));

    }


    /**
     * compare method that compares two disks and returns a integer based on
     * conditions
     * 
     * @param otherDisk
     *            what the main disk is being comapred to
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }

        else if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        else if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        return 0;

    }


    /**
     * toString method
     * 
     * @return value of width of disk
     */
    public String toString() {

        return String.valueOf(this.getWidth());

    }


    /**
     * Two disks are equal if they both have the same size and contain the
     * same elements in the same order
     * 
     * @param obj
     *            object to compare with
     * @return false if all if statements fail
     */
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        } // end if
        if (obj == null) {
            return false;
        } // end if
        if (this.getClass() == obj.getClass()) {
            Disk disk = (Disk)obj;
            return this.getWidth() == (disk.getWidth());
        } // end if

        return false;

    }

}
