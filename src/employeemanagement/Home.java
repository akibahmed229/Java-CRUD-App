/*
 * Home Screen
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description: It serves as the main interface for managing employee records in the system.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

// Code implementation and logic go here
public class Home extends JFrame implements ActionListener {

    RoundedButton addBtn, viewBtn, updateBtn, removeBtn; // Declaring all the custom  buttons

    // Constructor
    Home() {
        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 60, 1200, 700);
        add(image);

        // Showing heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(0, 0, 1120, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Set heading alignment to center
        add(heading);

        // Showing buttons
        addBtn = new RoundedButton("Add Employee");
        addBtn.setBounds(330, 290, 200, 60);
        Font buttonFont4 = addBtn.getFont().deriveFont(16f); // Create a font with a larger size
        addBtn.setFont(buttonFont4);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this); // Register an action listener
        image.add(addBtn);

        viewBtn = new RoundedButton("View Employees");
        viewBtn.setBounds(600, 290, 200, 60);
        Font buttonFont3 = viewBtn.getFont().deriveFont(16f); // Create a font with a larger size
        viewBtn.setFont(buttonFont3);
        viewBtn.setBackground(Color.BLACK);
        viewBtn.setForeground(Color.WHITE);
        viewBtn.addActionListener(this); // Register an action listener
        image.add(viewBtn);

        updateBtn = new RoundedButton("Update Employee");
        updateBtn.setBounds(330, 380, 200, 60);
        Font buttonFont2 = updateBtn.getFont().deriveFont(16f); // Create a font with a larger size
        updateBtn.setFont(buttonFont2);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.addActionListener(this); // Register an action listener
        image.add(updateBtn);

        removeBtn = new RoundedButton("Remove Employee");
        removeBtn.setBounds(600, 380, 200, 60);
        Font buttonFont = removeBtn.getFont().deriveFont(16f); // Create a font with a larger size
        removeBtn.setFont(buttonFont);
        removeBtn.setBackground(Color.BLACK);
        removeBtn.setForeground(Color.WHITE);
        removeBtn.addActionListener(this); // Register an action listener
        image.add(removeBtn);

        setSize(1200, 700);
        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        // Calculate the x and y coordinates to center the frame
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
        setVisible(true);
    }

    // On click action for the button
    public void actionPerformed(ActionEvent ae) {

        // If the add button is clicked
        if (ae.getSource() == addBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new AddEmployee(); // Create a new instance of the AddEmployee frame
        } // If the view button is clicked
        else if (ae.getSource() == viewBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new ViewEmployee(); // Create a new instance of the ViewEmployee frame
        } // If the update button is clicked
        else if (ae.getSource() == updateBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new UpdateEmployee(""); // Create a new instance of the ViewEmployee frame
        } // If the remove button is clicked
        else if (ae.getSource() == removeBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new RemoveEmployee(); // Create a new instance of the RemoveEmployee frame
        }
    }

    public static void main(String[] args) {
        // calling the constructor class
        new Home(); // Create an instance of the Home class
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
