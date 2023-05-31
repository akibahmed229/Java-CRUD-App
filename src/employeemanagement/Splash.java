/*
 * Splash Screen
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description: The Splash Screen provides a visually appealing introduction to the application.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.RoundRectangle2D;

// Code implementation and logic go here
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

        // showing custom Button
        RoundedButton roundedButton = new RoundedButton("Click Here To Continue");
        roundedButton.setBounds(380, 400, 300, 70);
        roundedButton.setFont(new Font("serif", Font.CENTER_BASELINE, 23));
        roundedButton.setBackground(Color.BLACK);
        roundedButton.setForeground(Color.WHITE);
        roundedButton.addActionListener(this);
        image.add(roundedButton);

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

class RoundedButton extends JButton {

    private static final int ARC_WIDTH = 20;  // The width of the button's rounded corners
    private static final int ARC_HEIGHT = 20; // The height of the button's rounded corners

    public RoundedButton(String text) {
        super(text);
        init();
    }

    private void init() {
        setContentAreaFilled(false); // Set the content area to be transparent
        setFocusPainted(false); // Remove focus painting
        setBorderPainted(false); // Remove border painting
        setOpaque(false); // Make the button background transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        Shape shape = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, ARC_WIDTH, ARC_HEIGHT); // Create the shape of the rounded rectangle
        g2.setColor(getBackground()); // Set the button background color
        g2.fill(shape); // Fill the shape with the background color

        g2.setColor(getForeground()); // Set the button text color
        g2.setFont(getFont()); // Set the button text font

        FontMetrics fontMetrics = g2.getFontMetrics();
        Rectangle textBounds = fontMetrics.getStringBounds(getText(), g2).getBounds();
        int textX = (width - textBounds.width) / 2; // Calculate the x-coordinate to center the text horizontally
        int textY = (height - textBounds.height) / 2 + fontMetrics.getAscent(); // Calculate the y-coordinate to center the text vertically

        g2.drawString(getText(), textX, textY); // Draw the button text
        g2.dispose(); // Dispose the Graphics2D object
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the border
    }
}
