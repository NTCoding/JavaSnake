/*
 * Picture.java
 *
 * This class includes a constructor that can be used to set up a Picture object
 * to allow drawing on an area of known size
 * The method draw receives a graphics context 
 *
 */
package tma02q3;

import java.awt.Graphics;

/**
 *
 * @author M257 CT
 */
public class Picture
{
    //TODO add instance variables

    private int width, height;

    //TODO complete constructor
    public Picture(int width, int height)
    {
        this.width = width;
        this.height = height;

        //TODO complete
    }

    //TODO add updatePictureState method
    //parameters can be removed/changed if required
    //This method does not do any drawing - it changes the state of the
    //picture object(s). The draw method does the drawing
    public void updatePictureState()
    {
        //TODO complete
    }

    //TODO complete draw method
    public void draw(Graphics g)
    {
        //TODO complete

        // draw tip of head at starting coordinates

        // draw tail going backwards
    }
    //TODO add further methods here if required - up to you!
}
