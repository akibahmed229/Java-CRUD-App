package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpID; // Declaring Choice component

    // Declaring Button variable
    JButton deleteBtn, backBtn;

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
        deleteBtn = new JButton("Delete Employee");
        deleteBtn.setBounds(200, 550, 200, 60);
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        Font buttonFont = deleteBtn.getFont().deriveFont(16f);
        deleteBtn.setFont(buttonFont);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        // Showing Button - Back
        backBtn = new JButton("Back");
        backBtn.setBounds(500, 550, 200, 60);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        Font buttonFont2 = backBtn.getFont().deriveFont(16f);
        backBtn.setFont(buttonFont2);
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
