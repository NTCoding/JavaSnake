/*
 * M257DrawingApplication.java
 *
 */
package tma02q3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author M257 CT
 */
public class M257DrawingApplication extends JFrame
{
    // instance variables provided

    private final int FRAME_WIDTH = 550;
    private final int FRAME_HEIGHT = 550;
    private DrawingPanel drawingPanel;

   
    // TODO add further instance variables as required
    /**
     * Creates a new instance of M257DrawingApplication
     */
    public M257DrawingApplication(String title) throws InterruptedException
    {
        super(title);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        setLayout(new BorderLayout());

        //set visible here, now size is available
        setVisible(true);

        drawingPanel = new DrawingPanel(getAvailableWidth(), getAvailableHeight());
        add(drawingPanel);

        // given exiting on close
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //TODO add registering of any event handlers here
        this.addKeyListener(new KeyListener(drawingPanel.getSnake()));
    }

    
    //These methods should only be called after the frame is visible.
    //They tell you about the available width and height in the frame
    private int getAvailableWidth()
    {
        return getWidth() - getInsets().left - getInsets().right;
    }

    private int getAvailableHeight()
    {
        return getHeight() - getInsets().top - getInsets().bottom;
    }

    //TODO complete update method
    //this method drives the application
    public void update() throws InterruptedException
    {
        //the idea here is to loop
        //and change the picture
        //this involves updating the content of the drawingPanel
        // by calling the panel's updatePictureState method
        while(true)
        {
            Thread.sleep(100);

            if (this.hasOutOfBoundsSnake())
            {
                drawingPanel.startNewGame();
            }
            else
            {
                drawingPanel.moveSnake();
            }
            repaint();
         }
    }

    private boolean hasOutOfBoundsSnake()
    {
        // get the inner extents of the border
        int minX = 0 + drawingPanel.getMargin() + drawingPanel.getBorderWidth();
        int maxX = minX + (drawingPanel.getWidth() - (drawingPanel.getMargin() * 2) - (drawingPanel.getBorderWidth() * 2));

        int minY = minX;
        int maxY = minY + (drawingPanel.getHeight() - (drawingPanel.getMargin() * 2) - (drawingPanel.getBorderWidth() * 2));

        Point headPosition = drawingPanel.getSnakeHeadPosition();

        return  headPosition.x < minX || headPosition.x > maxX || headPosition.y < minY || headPosition.y > maxY;
    }

    // inner class on which to draw everything - you can add
    // to this class as much as you like
    private class DrawingPanel extends JPanel // provided
    {

        private Picture myPicture;

        private final int margin = 20;
        private final int borderWidth = 10;

        // add further instance variables if required
        public DrawingPanel(int width, int height) throws InterruptedException // given
        {
            myPicture = new Picture(width, height);
            setSize(width, height);

            startNewGame();
        }

        public void startNewGame()
        {
            setInitialFrameAppearance();
            setSnakeStartPosition();
        }

        private void setInitialFrameAppearance()
        {
            this.setBorder(new SnakeBorder(getMargin(), getBorderWidth()));
            this.setBackground(new Color(218, 188, 230));
        }

        private void setSnakeStartPosition()
        {
            int xPos =  this.getMargin() + this.getBorderWidth() + 40;
            int yPos = this.getHeight() - this.getMargin() - this.getBorderWidth() - this.getSnake().getTotalLength() - 5;
            this.getSnake().setPosition(xPos, yPos);
        }

        public void moveSnake()
        {
            this.updatePictureState();
        }

        //this method is invoked automatically when repaint occurs in
        //the outer container
        public void paintComponent(Graphics g) // given
        {
            super.paintComponent(g);

            myPicture.draw(g); //This does the redrawing based on current state
        }

        // TODO complete updatePictureState method
        //this is about updating the state of elements in the picture
        //not about redrawing
        public void updatePictureState()
        {
            //TODO update state of myPicture
            this.getSnake().move();
        }
        //TODO add further methods as required
        public int getMargin()
        {
            return this.margin;
        }

        public int getBorderWidth()
        {
            return this.borderWidth;
        }

        private Picture getSnake()
        {
            return this.myPicture;
        }

        private Point getSnakeHeadPosition()
        {
            String direction = this.getSnake().getDirection();
            Point position = this.getSnake().getPosition();
            int headHeight = this.getSnake().getHeadHeight();

            if (direction.equals("up"))
            {
                return new Point(position.x, position.y - headHeight);
            }
            if (direction.equals("down"))
            {
                return new Point(position.x, position.y + headHeight);
            }
            if (direction.equals("left"))
            {
                return new Point(position.x - headHeight, position.y);
            }
            if (direction.equals("right"))
            {
                return new Point(position.x + headHeight, position.y);
            }

            return null;
        }
    }
    //TODO add further (inner) classes as required

    private class KeyListener extends KeyAdapter
    {
        private Picture snake;

        public KeyListener(Picture snake)
        {
            this.snake = snake;
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                this.getSnake().goUp();
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                this.getSnake().goDown();
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                this.getSnake().goLeft();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                this.getSnake().goRight();
            }
        }

        private Picture getSnake()
        {
            return this.snake;
        }

    }
}
