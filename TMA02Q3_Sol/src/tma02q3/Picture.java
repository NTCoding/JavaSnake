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
import java.awt.Point;
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
    private final int headHeight = 24;
    private final int headTipWidth = 8;
    private final int headBaseWidth = 16;
    private int tailLength = 60;
    private int tailWidth = 6;
    private int stepDistance = 4;


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
        g.drawPolygon(getSnakeHead(g));
        g.drawPolygon(getSnakeTail(g));
    }

    private Polygon getSnakeHead(Graphics g)
    {
        int headHeight = this.getHeadHeight();
        int headTipWidth = this.getHeadTipWidth();
        int headBaseWidth = this.getHeadBaseWidth();
        int x = this.getX();
        int y = this.getY();

        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x - headTipWidth, y);
        head.addPoint(x - headBaseWidth, y + headHeight);
        head.addPoint(x + headBaseWidth, y + headHeight);
        head.addPoint(x + headTipWidth, y);
        g.fillPolygon(head);

        return head;
    }

    private Polygon getSnakeTail(Graphics g)
    {
        Point startPoint = getCentreOfBaseOfHead();
        int tailWidth = this.getTailWidth();
        int halfTailWidth = this.getTailWidth() / 2;
        
        Polygon tail = new Polygon();
        tail.addPoint(startPoint.x - halfTailWidth, startPoint.y);
        tail.addPoint(startPoint.x - halfTailWidth, startPoint.y + this.getTailLength());
        tail.addPoint(startPoint.x + tailWidth, startPoint.y + this.getTailLength());
        tail.addPoint(startPoint.x + tailWidth, startPoint.y);

        g.fillPolygon(tail);

        return tail;
    }

    private Point getCentreOfBaseOfHead()
    {
        int y = this.getY() + this.getHeadHeight();

        return new Point(this.getX() - 1, y);
    }

    private int getTailLength()
    {
        return this.tailLength;
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

    private void setY(int value)
    {
        this.y = value;
    }

    public int getHeadHeight()
    {
        return headHeight;
    }

    private int getHeadTipWidth()
    {
        return this.headTipWidth;
    }

    private int getHeadBaseWidth()
    {
        return headBaseWidth;
    }

    private int getTailWidth()
    {
        return this.tailWidth;
    }

    void move()
    {
        this.setY(this.getY() + this.getStepDistance());
    }

    private int getStepDistance()
    {
        return this.stepDistance;
    }
}