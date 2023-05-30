/*
 * Employee Creation
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description: It provides a form for entering employee information such as name, date of birth, salary, address, contact details, and education.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

// Code implementation and logic go here
public class AddEmployee extends JFrame implements ActionListener {

    // Declaring Date Chooser variable
    JDateChooser dcdob;
    // Declaring drop down variable
    JComboBox cbeducation;
    // Declaring normal text variable
    JLabel lblempId;
    // Declaring Button variable
    JButton addBtn, backBtn;
    // Declaring Input TextField variable
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    AddEmployee() {
        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Showing heading
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(0, 30, 900, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Set heading alignment to center
        add(heading);

        // Showing Text name
        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        // Text Field input
        tfname = new JTextField();
        tfname.setBounds(170, 150, 150, 30);
        add(tfname);

        // Showing Text father name
        JLabel labelfname = new JLabel("Father's Name :");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        // Text Field input
        tffname = new JTextField();
        tffname.setBounds(550, 150, 150, 30);
        add(tffname);

        // Showing Text date of birth
        JLabel labeldob = new JLabel("Date of Birth :");
        labeldob.setBounds(50, 190, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        // shwoing callender
        dcdob = new JDateChooser();
        dcdob.setBounds(170, 190, 150, 30);
        add(dcdob);

        // Showing Text salary
        JLabel labelsalary = new JLabel("Salary :");
        labelsalary.setBounds(400, 190, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        // Text Field input
        tfsalary = new JTextField();
        tfsalary.setBounds(550, 190, 150, 30);
        add(tfsalary);

        // Showing Text Address
        JLabel labeladdress = new JLabel("Address :");
        labeladdress.setBounds(50, 240, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        // Text Field input
        tfaddress = new JTextField();
        tfaddress.setBounds(170, 240, 150, 30);
        add(tfaddress);

        // Showing Text Phone
        JLabel labelphone = new JLabel("Phone :");
        labelphone.setBounds(400, 230, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        // Text Field input
        tfphone = new JTextField();
        tfphone.setBounds(550, 230, 150, 30);
        add(tfphone);

        // Showing Text Email
        JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(50, 290, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        // Text Field input
        tfemail = new JTextField();
        tfemail.setBounds(170, 290, 150, 30);
        add(tfemail);

        // Showing Text Higest Education
        JLabel labeleducation = new JLabel("Higest Education :");
        labeleducation.setBounds(400, 270, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        // DropDrown Box to select Option
        String courses[] = {"BBA", "BCA", "BA", "BTECH", "MBA", "BSC", "MBBS", "MSC"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(550, 270, 150, 30);
        add(cbeducation);

        // Showing Text Employee Id
        JLabel labelempId = new JLabel("Employee ID :");
        labelempId.setBounds(50, 340, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        // Text Field input
        lblempId = new JLabel("" + number);
        lblempId.setBounds(170, 340, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        // Showing Button - Add Details
        addBtn = new JButton("Add Details");
        addBtn.setBounds(200, 500, 200, 60);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        Font buttonFont = addBtn.getFont().deriveFont(16f);
        addBtn.setFont(buttonFont);
        addBtn.addActionListener(this);
        add(addBtn);

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
        // If the Add button is clicked
        if (ae.getSource() == addBtn) {
            // Retrieve input values from text fields and other components
            String name = tfname.getText();
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String empId = lblempId.getText();

            // Get the date from the JDateChooser
            Date date = dcdob.getDate();

            // Check if all required fields are filled
            if (!name.isEmpty() && !fname.isEmpty() && !salary.isEmpty() && !address.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !education.isEmpty() && date != null) {
                // Create a SimpleDateFormat instance to specify the desired date format
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy");
                // Format the date without the comma
                String dob = dateFormat.format(date);

                String data = empId + "," + name + "," + fname + "," + dob + "," + salary + "," + address + "," + phone + "," + email + "," + education; // Create a string with the data

                // Specify the file path where you want to store the data
                String filePath = "employees.txt";

                // Create a BufferedWriter object to write the data to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    // Write the data to the file
                    writer.write(data);
                    writer.newLine(); // Add a new line to separate the data from other data
                    writer.flush(); // Flush the data to the file system to ensure it is written to disk successfully

                    // Show a success message
                    JOptionPane.showMessageDialog(null, "Data stored successfully!");
                    setVisible(false); // Set the visibility of the current frame to false
                    new Home(); // Navigate to the Home screen
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "An error occurred while storing data.");
                    e.printStackTrace();
                }
            } else {
                // Show an error message
                JOptionPane.showMessageDialog(null, "Please provide all required info!");
            }
        } // If the Back button is clicked
        else if (ae.getSource()
                == backBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new Home(); // Navigate to the Home screen
        }
    }

    public static void main(String[] args) {
        new AddEmployee(); // Create an instance of the AddEmployee class
    }
}
