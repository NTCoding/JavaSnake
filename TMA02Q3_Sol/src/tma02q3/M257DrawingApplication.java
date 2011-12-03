/*
 * M257DrawingApplication.java
 *
 */
package tma02q3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author M257 CT
 */
public class M257DrawingApplication extends JFrame
{
    // instance variables provided

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;
    private DrawingPanel drawingPanel;

    // TODO add further instance variables as required
    /**
     * Creates a new instance of M257DrawingApplication
     */
    public M257DrawingApplication(String title)
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
    public void update()
    {
        //the idea here is to loop
        //and change the picture
        //this involves updating the content of the drawingPanel
        // by calling the panel's updatePictureState method
    }

    // inner class on which to draw everything - you can add
    // to this class as much as you like
    private class DrawingPanel extends JPanel // provided
    {

        private Picture myPicture;

        // add further instance variables if required
        public DrawingPanel(int width, int height) // given
        {
            myPicture = new Picture(width, height);
            setSize(width, height);
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
        }
        //TODO add further methods as required
    }
    //TODO add further (inner) classes as required
}