/*
 * Login Screen
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description: : This is the login screen where only the administrator can login. It provides access to the admin panel for managing the system.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Code implementation and logic go here
public class Login extends JFrame implements ActionListener {

    JTextField tfusername, tfpassword; // Declaring the text fields

    // Constructor
    Login() {
        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Showing text for username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        // Text input field for username
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        // Showing text for password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        // Text input field for password
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        // Showing button for login
        JButton login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Scale the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Adding the scaled image to the label
        image.setBounds(350, 0, 200, 200);
        add(image);

        // Showing the login screen
        setSize(600, 300);
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
        try {
            // Extracting the username and password from the fields
            String username = tfusername.getText();
            String password = tfpassword.getText();

            // Checking the username and password against a hardcoded string
            if (username.equals("admin") && password.equals("123456")) {
                setVisible(false); // Set the visibility of the current frame to false
                new Home(); // Create a new instance of the Home frame
            } else {
                // Show a invalid message
                JOptionPane.showMessageDialog(null, "Invalid Username or Password....!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login(); // Create an instance of the Login class
    }
}
