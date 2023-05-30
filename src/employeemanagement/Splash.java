package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener {

    // Constructor
    Splash() {
        // setting the backgroud color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // showing text message
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(300, 30, 1400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        add(heading);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front1.jpg")); // Create a new image icon
        Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT); // Scale the image
        ImageIcon i3 = new ImageIcon(i2); // Create a new image icon
        JLabel image = new JLabel(i3); // Create a new label
        image.setBounds(50, 100, 1050, 500); // Set the position and size of the image
        add(image); // Add the image to the frame

        // showing Button
        JButton clickHereBtn = new JButton("Click Here To Continue");
        clickHereBtn.setBounds(380, 400, 300, 70);
        // Create a font with a larger size
        Font buttonFont = clickHereBtn.getFont().deriveFont(24f);
        clickHereBtn.setFont(buttonFont);
        clickHereBtn.addActionListener(this);
        image.add(clickHereBtn); // Add the button to the frame

        // Showing Splash Screen
        setSize(1200, 700);
        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        // Calculate the x and y coordinates to center the frame
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
        setVisible(true); // Set the visibility of the current frame to true

        // showing the Screen message after some interval
        while (true) {
            heading.setVisible(false); // Set the visibility of the current frame to false

            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (Exception e) {
                e.printStackTrace();
            }

            heading.setVisible(true); // Set the visibility of the current frame to true

            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // onclick action for the button
    public void actionPerformed(ActionEvent ae) {
        setVisible(false); // Set the visibility of the current frame to false
        new Login(); // Create a new instance of the Login frame
    }

    public static void main(String[] args) {
        new Splash(); // Create an instance of the Splash class
    }

}
