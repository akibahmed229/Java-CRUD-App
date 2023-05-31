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
import java.awt.geom.RoundRectangle2D;
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
    RoundedButton addBtn, backBtn;
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
        addBtn = new RoundedButton("Add Details");
        addBtn.setBounds(200, 500, 200, 60);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        addBtn.setFont(new Font("serif", Font.PLAIN, 20));
        addBtn.addActionListener(this);
        add(addBtn);

        // Showing Button - Back
        backBtn = new RoundedButton("Back");
        backBtn.setBounds(500, 500, 200, 60);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        // Create a font with a larger size
        backBtn.setFont(new Font("serif", Font.PLAIN, 20));
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
