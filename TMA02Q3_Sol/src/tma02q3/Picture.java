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

    private final String UP = "up";
    private final String DOWN = "down";
    private final String LEFT = "left";
    private final String RIGHT = "right";

    private String direction = UP;

    SnakeBuilder builder = new SnakeBuilder();

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
        
        SnakeBuilder builder = this.getSnakeBuilder();

        Polygon head = null;
        if (this.getDirection().equals(UP))
        {
            head = builder.getUpwardFacingHead(x, y, headTipWidth, headBaseWidth, headHeight);
        }
        if (this.getDirection().equals(DOWN))
        {
            head = builder.getDownwardFacingHead(x, y, headTipWidth, headBaseWidth, headHeight);
        }

        g.fillPolygon(head);

        return head;
    }

    private Polygon getSnakeTail(Graphics g)
    {
        Point startPoint = getCentreOfBaseOfHead();
        int tailWidth = this.getTailWidth();
        int halfTailWidth = this.getTailWidth() / 2;

        Polygon tail = null;
        if (this.getDirection().equals(UP))
        {
           tail = this.getSnakeBuilder().getForwardsTail(startPoint, halfTailWidth, tailWidth, this.getTailLength());
        }

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

    private void setX(int x)
    {
        this.x = x;
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

    private int getStepDistance()
    {
        return this.stepDistance;
    }

    void move()
    {
        String directon = this.getDirection();
        
        if (direction == UP) this.moveUp();
        if (direction == DOWN) this.moveDown();
        if (direction == LEFT) this.moveLeft();
        if (direction == RIGHT) this.moveRight();
    }

    private void moveUp()
    {
        this.setY(this.getY() - this.getStepDistance());
    }

    private void moveDown()
    {
        this.setY(this.getY() + this.getStepDistance());
    }

    private void moveLeft()
    {
        this.setX(this.getX() - this.getStepDistance());
    }

    private void moveRight()
    {
        this.setX(this.getX() + this.getStepDistance());
    }

    public int getTotalLength()
    {
        return this.getHeadHeight() + this.getTailLength();
    }

    public void goUp()
    {
        this.setDirection(UP);
    }

    public void goDown()
    {
        this.setDirection(DOWN);
    }

    public void goLeft()
    {
        this.setDirection(LEFT);
    }

    public void goRight()
    {
        this.setDirection(RIGHT);
    }

    private String getDirection()
    {
        return this.direction;
    }

    private void setDirection(String direction)
    {
        this.direction = direction;
    }

    private SnakeBuilder getSnakeBuilder()
    {
        return this.builder;
    }
}