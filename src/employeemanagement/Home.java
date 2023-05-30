package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {

    JButton addBtn, viewBtn, updateBtn, removeBtn; // Declaring all the buttons

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
        addBtn = new JButton("Add Employee");
        addBtn.setBounds(330, 290, 200, 60);
        Font buttonFont4 = addBtn.getFont().deriveFont(16f); // Create a font with a larger size
        addBtn.setFont(buttonFont4);
        addBtn.addActionListener(this); // Register an action listener
        image.add(addBtn);

        viewBtn = new JButton("View Employees");
        viewBtn.setBounds(600, 290, 200, 60);
        Font buttonFont3 = viewBtn.getFont().deriveFont(16f); // Create a font with a larger size
        viewBtn.setFont(buttonFont3);
        viewBtn.addActionListener(this); // Register an action listener
        image.add(viewBtn);

        updateBtn = new JButton("Update Employee");
        updateBtn.setBounds(330, 380, 200, 60);
        Font buttonFont2 = updateBtn.getFont().deriveFont(16f); // Create a font with a larger size
        updateBtn.setFont(buttonFont2);
        updateBtn.addActionListener(this); // Register an action listener
        image.add(updateBtn);

        removeBtn = new JButton("Remove Employee");
        removeBtn.setBounds(600, 380, 200, 60);
        Font buttonFont = removeBtn.getFont().deriveFont(16f); // Create a font with a larger size
        removeBtn.setFont(buttonFont);
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
