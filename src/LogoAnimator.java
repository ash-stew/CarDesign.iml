
import javax.swing.JFrame;

public class LogoAnimator {

    // execute the animation as a JFrame

    public static void main(String[] args)
    {
        // creating an object of CarAnimatorJPanel
        CarAnimatorJPanel carAnimation = new CarAnimatorJPanel();

        JFrame window = new JFrame("Car Animation"); // create an object of JFrame called window
        window.setSize(300, 200);

        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        window.add(carAnimation);   // add the Car Animator panel to the JFrame

        window.setLocationRelativeTo(null); // To centre the JFrame
        window.setVisible( true ); // display the window

        carAnimation.startAnimation();

    } // end of main

} // end of LogoAnimator class
