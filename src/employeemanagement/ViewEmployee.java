/*
 * Employee Management - View and Update
 * Author: Akib Ahmed
 * Project: Employee Management System
 * Created: 2023-05-28
 * Last Modified: 2023-05-29
 * Description: The application reads the employee data from a file and allows users to interact with it.
 */
// Import statements and class declaration go here
package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

// Code implementation and logic go here
public class ViewEmployee extends JFrame implements ActionListener {

    JTable table; // Variable to hold the table component.
    DefaultTableModel model; // Variable to hold the model for the table.
    Choice cEmployeeId; // Variable to hold the Choice component
    JButton searchBtn, printBtn, updateBtn, backBtn; // Variables to hold the JButtons

    ViewEmployee() {
        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Showing heading
        JLabel heading = new JLabel("View Employees Details");
        heading.setBounds(0, 30, 1200, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Set heading alignment to center
        add(heading);

        JLabel searchlbl = new JLabel("Search by Employee Id: ");
        searchlbl.setFont(new Font("serif", Font.BOLD, 16));
        searchlbl.setBounds(20, 100, 180, 20);
        add(searchlbl);

        cEmployeeId = new Choice();
        cEmployeeId.setBounds(200, 100, 150, 20);

        table = new JTable(); // Create a new JTable instance

        String filePath = "employees.txt";
        model = new DefaultTableModel(); // Create a new DefaultTableModel instance
        model.addColumn("Employee ID"); // Add columns to the model
        model.addColumn("Name");
        model.addColumn("Father's Name");
        model.addColumn("DOB");
        model.addColumn("Salary");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Email");
        model.addColumn("Education");

        // Create a BufferedReader instance to read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Split the line into an array of values
                model.addRow(data); // Add a row to the model using the data array
                cEmployeeId.add(data[0]); // Add Employee ID to the Choice component
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        table.setModel(model); // Set the model on the table

        JScrollPane jsp = new JScrollPane(table); // Create a scroll pane and add the table to it
        jsp.setBounds(20, 190, 1140, 450);
        add(jsp); // Add the scroll pane to the container

        add(cEmployeeId); // Add the Choice component to the container

        // Showing button - Search
        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 140, 80, 20);
        searchBtn.addActionListener(this);
        add(searchBtn);

        // Showing button - Print
        printBtn = new JButton("Print");
        printBtn.setBounds(120, 140, 80, 20);
        printBtn.addActionListener(this);
        add(printBtn);

        // Showing button - Update
        updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 140, 80, 20);
        updateBtn.addActionListener(this);
        add(updateBtn);

        // Showing button - Back
        backBtn = new JButton("Back");
        backBtn.setBounds(320, 140, 80, 20);
        backBtn.addActionListener(this);
        add(backBtn);

        // Window screen size decleration
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

    public void actionPerformed(ActionEvent ae) {

        // If the Search button is clicked
        if (ae.getSource() == searchBtn) {
            String query = cEmployeeId.getSelectedItem();

            try {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(model); // Create a TableRowSorter with the table model
                table.setRowSorter(sorter); // Set the sorter on the table
                RowFilter<TableModel, Object> filter = RowFilter.regexFilter(query, 0); // Create a filter based on the selected Employee ID
                sorter.setRowFilter(filter); // Apply the filter to the table's sorter
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // If the Print button is clicked
        else if (ae.getSource() == printBtn) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // If the Update button is clicked
        else if (ae.getSource() == updateBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new UpdateEmployee(cEmployeeId.getSelectedItem()); // Create a new instance of the UpdateEmployee frame and pass Employee ID

        } // If the Back button is clicked
        else if (ae.getSource() == backBtn) {
            setVisible(false); // Set the visibility of the current frame to false
            new Home(); // Navigate to the Home screen
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();  // Create an instance of the ViewEmployee class
    }

}
