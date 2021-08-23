
import java.awt.Dimension; // Used to get preferred and minimum size
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.*;

public class CarAnimatorJPanel extends JPanel {

    private final static String IMAGE_NAME = "RacingCarBlue";   // The base image name
    protected ImageIcon[] images; // array to store images
    private final int TOTAL_IMAGES = 16; // will be the size of images array. Set as constant
    private int currentImage = 0; // will represent the image array's index
    private final int ANIMATION_DELAY = 100;  // delay in milliseconds
    private int width;  // image width
    private int height; // image height
    private Timer animationTimer; // creating timer object for animation

    // constructor that initializes CarAnimatorJPanel by loading the images
    public CarAnimatorJPanel()
    {

        images = new ImageIcon[TOTAL_IMAGES]; // initializing the array of size 16

        // Load all images into array RacingCar0 to 15, according to value of i
        for (int i = 0; i < images.length; i++)
           {
            images[i] = new ImageIcon(getClass().getResource( "res/" + IMAGE_NAME + i + ".jpg"));
           }

        // getting the height an width of the image. 50x50 is expected
        width = images[0].getIconWidth();
        height = images[0].getIconHeight();

    } // end of CarAnimatorJPanel constructor


    // display the current image, 'this' gets called behind the scenes when necessary
    public void paintComponent( Graphics g)
    {
       super.paintComponent(g); // calling the superclass paintComponent. Used for JPanel

        images[currentImage].paintIcon(this, g, 120, 50); // paint image at x, y location
                                                                 // ( within the JPanel)

        try {
            // set the next image to be drawn only if timer running
            if (animationTimer.isRunning()) { //  Mod ensures current image returns to 0 when 16 reached
                currentImage = (currentImage + 1) % TOTAL_IMAGES;

            } // end of if
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    } // end of the paintComponent method


    // start animation, or restart if window is redisplayed
    public void startAnimation()
    {
        if(animationTimer == null)
        {
            currentImage = 0; // to display first image of the array
            // create timer that fires action events
           animationTimer = new Timer(ANIMATION_DELAY, new TimerHandler());
            animationTimer.start();
        } // end of if statement
        else  // then there already is an animation timer. Restart animation
        {
            if( ! animationTimer.isRunning())
            {
                animationTimer.restart();
            }
        } // end of else

    } // end of startAnimation method

    public Dimension getMinimumSize() // returning the minimum size of the animation
    {
        return getPreferredSize();
    } // end method getMinimumSize

    public Dimension getPreferredSize()
    {
        return new Dimension( width, height);
    } // end method getPreferredSize


    private class TimerHandler implements ActionListener  // inner class, Action event handler
    {
        // respond to the Timer's events
        public void actionPerformed(ActionEvent actionEvent)
        {
            repaint(); // repaint animator
        } // end actionPerformed method

    } // end of the TimerHandler class

} // End of CarAnimatorJPanel class