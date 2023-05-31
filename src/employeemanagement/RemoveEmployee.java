/*
 * Employee Management - Remove Employee
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description:  This screen allows the user to remove an employee from the OS database.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

// Code implementation and logic go here
public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpID; // Declaring Choice component

    // Declaring Button variable
    RoundedButton deleteBtn, backBtn;

    RemoveEmployee() {
        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Showing heading
        JLabel heading = new JLabel("Remove Employee Details");
        heading.setBounds(0, 30, 900, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Set heading alignment to center
        add(heading);

        // Showing text Employee ID
        JLabel lblEmpID = new JLabel("Employee ID :");
        lblEmpID.setFont(new Font("Serif", Font.BOLD, 17));
        lblEmpID.setBounds(50, 120, 120, 30);
        add(lblEmpID);

        cEmpID = new Choice();
        cEmpID.setBounds(170, 125, 150, 30);
        add(cEmpID);

        // Specify the file path where you have stored the employee details
        String filePath = "employees.txt";

        // Create a BufferedReader instance to read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Split the line into an array of values
                cEmpID.add(data[0]); // Add Employee ID to the Choice component
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Showing text Employee name
        JLabel lblName = new JLabel("Name :");
        lblName.setFont(new Font("Serif", Font.BOLD, 17));
        lblName.setBounds(50, 150, 120, 30);
        add(lblName);

        JLabel lblNameDb = new JLabel();
        lblNameDb.setFont(new Font("Serif", Font.BOLD, 17));
        lblNameDb.setBounds(170, 150, 200, 30);
        add(lblNameDb);

        // Showing text Employee Phone
        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setFont(new Font("Serif", Font.BOLD, 17));
        lblPhone.setBounds(50, 180, 120, 30);
        add(lblPhone);

        JLabel lblPhoneDb = new JLabel();
        lblPhoneDb.setFont(new Font("Serif", Font.BOLD, 17));
        lblPhoneDb.setBounds(170, 180, 200, 30);
        add(lblPhoneDb);

        // Showing text Employee Email
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setFont(new Font("Serif", Font.BOLD, 17));
        lblEmail.setBounds(50, 210, 120, 30);
        add(lblEmail);

        JLabel lblEmailDb = new JLabel();
        lblEmailDb.setFont(new Font("Serif", Font.BOLD, 17));
        lblEmailDb.setBounds(170, 210, 200, 30);
        add(lblEmailDb);

        // Read the file and retrieve the employee details based on empId
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract individual fields
                String[] fields = line.split(",");

                // Check if the first field (empId) matches the desired empId
                if (fields.length > 0 && fields[0].equals(cEmpID.getSelectedItem())) {
                    // Set the retrieved employee details to the corresponding text fields
                    lblNameDb.setText(fields[1]);
                    lblPhoneDb.setText(fields[6]);
                    lblEmailDb.setText(fields[7]);

                    // Break the loop since we have found the matching empId
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Action listener
        cEmpID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    // Read the file and retrieve the employee details based on empId
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Split the line by comma to extract individual fields
                        String[] fields = line.split(",");

                        // Check if the first field (empId) matches the desired empId
                        if (fields.length > 0 && fields[0].equals(cEmpID.getSelectedItem())) {
                            // Set the retrieved employee details to the corresponding text fields
                            lblNameDb.setText(fields[1]);
                            lblPhoneDb.setText(fields[6]);
                            lblEmailDb.setText(fields[7]);

                            // Break the loop since we have found the matching empId
                            break;
                        }
                    }
                    reader.close(); // Close the reader
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Showing Button - Delete Employee
        deleteBtn = new RoundedButton("Delete Employee");
        deleteBtn.setBounds(200, 550, 200, 60);
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        deleteBtn.setFont(new Font("serif", Font.PLAIN, 20));
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        // Showing Button - Back
        backBtn = new RoundedButton("Back");
        backBtn.setBounds(500, 550, 200, 60);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        backBtn.setFont(new Font("serif", Font.PLAIN, 20));
        backBtn.addActionListener(this);
        add(backBtn);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT); // Scale the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Adding the scaled image to the label
        image.setBounds(350, 50, 800, 500);
        add(image);

        // Window screen size decleration
        setSize(900, 700);
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteBtn) {
            // Specify the file path where you have stored the employee details
            String filePath = "employees.txt";

            // Create a StringBuilder to build the updated content
            StringBuilder updatedContent = new StringBuilder();

            try {
                // Read the file and retrieve the employee details
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split the line by comma to extract individual fields
                    String[] fields = line.split(",");

                    // Check if the first field (empId) matches the desired empId
                    if (fields.length > 0 && fields[0].equals(cEmpID.getSelectedItem())) {
                        // Skip the line to delete it
                        continue;
                    }
                    // Add the existing line to the updated content
                    updatedContent.append(line).append("\n");
                }
                reader.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "An error occurred while retrieving data.");
                e.printStackTrace();
            }

            // Write the updated content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(updatedContent.toString());
                writer.flush(); // Flush the data to the file system to ensure that all the data is written to the file

                // Show a success message
                JOptionPane.showMessageDialog(null, "Employee Details deleted successfully!");
                setVisible(false); // Set the visibility of the current frame to false
                new Home(); // Navigate to the Home screen
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "An error occurred while deleting data.");
                e.printStackTrace();
            }
        } else if (ae.getSource() == backBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new Home(); // Navigate to the Home screen
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
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
