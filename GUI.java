import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    private JFrame frame;
    private Canvas canvas;
    private int size;
    private Umbrella umbrella;
    
    public GUI(int size) {
        this.size = size;
        makeFrame();
        umbrella = new Umbrella(200, 175, 50);
        umbrella.makeVisible();
    }

    /**
     * This method is called whenever a button is clicked in the GUI window.
     * @param event the event that has occurred.
     */
    public void actionPerformed(ActionEvent event) 
    {
        if (event.getActionCommand().equals("Bouncing Ball")) {
            BouncingThread bounce = new BouncingThread();
            bounce.start();
        } else if (event.getActionCommand().equals("Umbrella Open")){
            umbrella.open();
        } else if (event.getActionCommand().equals("Umbrella Close")) {
            umbrella.close();
        } else if (event.getActionCommand().equals("Bouncing Banana")) {
            
        } else {
            JOptionPane.showMessageDialog(frame, event.getActionCommand() + " doesn't work.");
        }
    }
    
    /**
     * Makes a green ball bounce across the canvas.  Woohoo!
     */
    public void bounce()
    {
        // Create a ball object.
        BouncingBall a = new BouncingBall(0, 0, 25, Color.GREEN, size, canvas);
       
        // Draw the ball on the canvas.
        a.draw();
        
        // Make the ball bounce across the canvas.
        while(a.getXPosition() < size+50) {
            canvas.wait(50);    // Wait 50 milliseconds so we can see the ball move.
            a.move();           // Move the ball a little to the right.
        }
    }
        
    /**
     * Builds and displays the GUI window.
     */
    private void makeFrame() {
        frame = new JFrame("Random Stuff");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        
        canvas = new Canvas(pane, size, size, Color.white);
        
        JPanel buttonPanel = makeButtons();
        pane.add(buttonPanel, BorderLayout.NORTH);
        
        frame.setSize(350, 350);
        canvas.setSize(size, size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        canvas.setVisible(true);
    }
    
    /**
     * Creates the button panel.
     * @return JPanel containing four buttons.
     */
    private JPanel makeButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        
        JButton bounce = new JButton("Bouncing Ball");
        bounce.addActionListener(this);
        panel.add(bounce);
        
        JButton umbrellaOpen = new JButton("Umbrella Open");
        umbrellaOpen.addActionListener(this);
        panel.add(umbrellaOpen);
        
        JButton umbrellaClose = new JButton("Umbrella Close");
        umbrellaClose.addActionListener(this);
        panel.add(umbrellaClose);
        
        JButton banana = new JButton("Bouncing Banana");
        banana.addActionListener(this);
        panel.add(banana);
        
        return panel;
    }
    
    /**
     * This is a private class for the thread that makes the ball bounce
     * across the screen.  Without this, you would not see the ball bounce.
     */
    private class BouncingThread extends Thread {
        
        // private GUI g;
        
        /*
        public BouncingThread() GUI g) {
            this.g = g;
        }
        */
        
        public void run() {
            bounce();
        }
        
    }
    
}