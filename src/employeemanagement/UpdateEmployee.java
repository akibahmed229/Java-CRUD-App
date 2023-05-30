/*
 * Employee Management - Update Employee
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description: This screen allows the user to update employee records stored in the OS database.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.List;

// Code implementation and logic go here
public class UpdateEmployee extends JFrame implements ActionListener {

    // Declaring normal text variable
    JLabel lblEmpID;
    // Declaring Button variable
    JButton updateBtn, backBtn;
    // Declaring Input TextField variable
    JTextField tfeducation, tffname, tfsalary, tfaddress, tfphone, tfemail;
    // Declaring Input Text variable
    JLabel lblname, lbldob;

    Choice cEmpID; // Choice component for Employee ID

    // Employee ID
    String empId;

    UpdateEmployee(String empId) {
        // Getting the Employee id from constructor and setting the instance variable
        // data
        this.empId = empId;

        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Showing heading
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(0, 30, 900, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Set heading alignment to center
        add(heading);

        // Showing text Employee ID
        lblEmpID = new JLabel("Search By Employee ID :");
        lblEmpID.setFont(new Font("Serif", Font.BOLD, 17));
        lblEmpID.setBounds(50, 120, 200, 30);
        add(lblEmpID);

        cEmpID = new Choice();
        cEmpID.setBounds(250, 125, 160, 30);
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

        // Showing Text name
        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50, 170, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        // Text Field input
        lblname = new JLabel();
        lblname.setBounds(170, 170, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 17));
        lblname.setForeground(Color.RED);
        add(lblname);

        // Showing Text father name
        JLabel labelfname = new JLabel("Father's Name :");
        labelfname.setBounds(400, 170, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        // Text Field input
        tffname = new JTextField();
        tffname.setBounds(550, 170, 150, 30);
        add(tffname);

        // Showing Text date of birth
        JLabel labeldob = new JLabel("Date of Birth :");
        labeldob.setBounds(50, 210, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        // shwoing callender
        lbldob = new JLabel();
        lbldob.setBounds(170, 210, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 17));
        lbldob.setForeground(Color.RED);
        add(lbldob);

        // Showing Text salary
        JLabel labelsalary = new JLabel("Salary :");
        labelsalary.setBounds(400, 210, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        // Text Field input
        tfsalary = new JTextField();
        tfsalary.setBounds(550, 210, 150, 30);
        add(tfsalary);

        // Showing Text Address
        JLabel labeladdress = new JLabel("Address :");
        labeladdress.setBounds(50, 260, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        // Text Field input
        tfaddress = new JTextField();
        tfaddress.setBounds(170, 260, 150, 30);
        add(tfaddress);

        // Showing Text Phone
        JLabel labelphone = new JLabel("Phone :");
        labelphone.setBounds(400, 260, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        // Text Field input
        tfphone = new JTextField();
        tfphone.setBounds(550, 260, 150, 30);
        add(tfphone);

        // Showing Text Email
        JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(50, 320, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        // Text Field input
        tfemail = new JTextField();
        tfemail.setBounds(170, 320, 150, 30);
        add(tfemail);

        // Showing Text Higest Education
        JLabel labeleducation = new JLabel("Higest Education :");
        labeleducation.setBounds(400, 320, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        // DropDrown Box to select Option
        tfeducation = new JTextField();
        tfeducation.setBounds(550, 320, 150, 30);
        add(tfeducation);

        // Showing Text Employee Id
        JLabel labelempId = new JLabel("Employee ID :");
        labelempId.setBounds(50, 370, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        // Text Field input
        lblEmpID = new JLabel();
        lblEmpID.setBounds(170, 370, 150, 30);
        lblEmpID.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEmpID);

        // Read the file and retrieve the employee details based on empId
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract individual fields
                String[] fields = line.split(",");

                if (!empId.isEmpty()) {
                    // Check if the first field (empId) matches the desired empId
                    if (fields.length > 0 && fields[0].equals(empId)) {
                        // Set the retrieved employee details to the corresponding text fields
                        lblEmpID.setText(fields[0]);
                        lblname.setText(fields[1]);
                        tffname.setText(fields[2]);
                        lbldob.setText(fields[3]);
                        tfsalary.setText(fields[4]);
                        tfaddress.setText(fields[5]);
                        tfphone.setText(fields[6]);
                        tfemail.setText(fields[7]);
                        tfeducation.setText(fields[8]);

                        // Break the loop since we have found the matching empId
                        break;
                    }
                } else {
                    if (fields.length > 0 && fields[0].equals(cEmpID.getSelectedItem())) {
                        // Set the retrieved employee details to the corresponding text fields
                        lblEmpID.setText(fields[0]);
                        lblname.setText(fields[1]);
                        tffname.setText(fields[2]);
                        lbldob.setText(fields[3]);
                        tfsalary.setText(fields[4]);
                        tfaddress.setText(fields[5]);
                        tfphone.setText(fields[6]);
                        tfemail.setText(fields[7]);
                        tfeducation.setText(fields[8]);

                        lblEmpID.setText(cEmpID.getSelectedItem()); // Set the selected item to the text field

                        // Break the loop since we have found the matching empId
                        break;
                    }
                }
            }
            reader.close(); // Close the file
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Action listener for the combo box
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
                            lblname.setText(fields[1]);
                            tffname.setText(fields[2]);
                            lbldob.setText(fields[3]);
                            tfsalary.setText(fields[4]);
                            tfaddress.setText(fields[5]);
                            tfphone.setText(fields[6]);
                            tfemail.setText(fields[7]);
                            tfeducation.setText(fields[8]);

                            lblEmpID.setText(cEmpID.getSelectedItem()); // Set the selected item to the text field

                            // Break the loop since we have found the matching empId
                            break;
                        }
                    }
                    reader.close(); // Close the file
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Showing Button - Add Details
        updateBtn = new JButton("Update Details");
        updateBtn.setBounds(200, 500, 200, 60);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        Font buttonFont = updateBtn.getFont().deriveFont(16f);
        updateBtn.setFont(buttonFont);
        updateBtn.addActionListener(this);
        add(updateBtn);

        // Showing Button - Back
        backBtn = new JButton("Back");
        backBtn.setBounds(500, 500, 200, 60);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        Font buttonFont2 = backBtn.getFont().deriveFont(16f);
        backBtn.setFont(buttonFont2);
        backBtn.addActionListener(this);
        add(backBtn);

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
        // If the Update button is clicked
        if (ae.getSource() == updateBtn) {
            // Specify the file path where you have stored the employee details
            String filePath = "employees.txt";

            // Create a StringBuilder to build the updated content
            StringBuilder updatedContent = new StringBuilder();

            // Read the file and retrieve the employee details based on empId
            List<String> employeeRecords = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split the line by comma to extract individual fields
                    String[] fields = line.split(",");

                    // Check if the first field (empId) matches the desired empId
                    if (fields.length > 0 && fields[0].equals(empId) || fields[0].equals(cEmpID.getSelectedItem())) {
                        // Update the employee details
                        String fname = tffname.getText();
                        String salary = tfsalary.getText();
                        String address = tfaddress.getText();
                        String phone = tfphone.getText();
                        String email = tfemail.getText();
                        String education = tfeducation.getText();

                        if (empId.isEmpty()) {
                            empId = cEmpID.getSelectedItem();
                        }

                        // Check if all required fields are filled
                        if (!fname.isEmpty() && !salary.isEmpty() && !address.isEmpty() && !phone.isEmpty()
                                && !email.isEmpty() && !education.isEmpty()) {
                            // Create the updated data line
                            String updatedLine = empId + "," + lblname.getText() + "," + fname + "," + lbldob.getText()
                                    + "," + salary + "," + address + "," + phone + "," + email + "," + education;

                            // Add the updated line to the list of employee records
                            employeeRecords.add(updatedLine);
                        } else {
                            // Show an error message
                            JOptionPane.showMessageDialog(null, "Please provide all required information!");
                            return; // Exit the method without updating the data
                        }
                    } else {
                        // Add the existing line to the list of employee records
                        employeeRecords.add(line);
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "An error occurred while retrieving data.");
                e.printStackTrace();
            }

            // Write the updated content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String record : employeeRecords) {
                    writer.write(record);
                    writer.newLine();
                }
                writer.flush();

                // Show a success message
                JOptionPane.showMessageDialog(null, "Data updated successfully!");
                setVisible(false); // Set the visibility of the current frame to false
                new Home(); // Navigate to the Home screen
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "An error occurred while updating data.");
                e.printStackTrace();
            }

        } // If the Back button is clicked
        else if (ae.getSource() == backBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new Home(); // Navigate to the Home screen
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee(""); // Create an instance of the AddEmployee class
    }
}
