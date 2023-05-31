package employeemanagement;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class RoundedButton extends JButton {

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
