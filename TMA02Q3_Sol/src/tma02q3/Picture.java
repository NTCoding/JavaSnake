/*
 * Picture.java
 *
 * This class includes a constructor that can be used to set up a Picture object
 * to allow drawing on an area of known size
 * The method draw receives a graphics context 
 *
 */
package tma02q3;

import com.sun.org.apache.xerces.internal.util.XML11Char;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author M257 CT
 */
public class Picture
{
    //TODO add instance variables

    private int width, height;

    private int x = 0;
    private int y = 0;


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

        g.setColor(Color.DARK_GRAY);

        // draw tip of head at starting coordinates
        int height = 24;
        int tipWidth = 10;
        int baseWidth = 20;
        
        int x = this.getX();
        int y = this.getY();

        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x - tipWidth, y);
        head.addPoint(x - baseWidth, y + height);
        head.addPoint(x + baseWidth, y + height);
        head.addPoint(x + tipWidth, y);

        g.fillPolygon(head);
        g.drawPolygon(head);

             
        // draw tail going backwards
    }

    //TODO add further methods here if required - up to you!
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    private int getX()
    {
        return this.x;
    }

    private int getY()
    {
         return this.y;
    }
}