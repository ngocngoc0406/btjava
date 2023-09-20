package test;

import javax.swing.*;
import java.awt.*;

public class PlaceHolder extends JFrame {

    public PlaceHolder() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Placeholder TextField Example");

        // Create a placeholder text field
        PlaceholderTextField textField = new PlaceholderTextField("Enter text...");

        // Set the preferred size of the text field
        textField.setPreferredSize(new Dimension(200, 30));

        // Add the text field to the frame
        add(textField);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlaceHolder example = new PlaceHolder();
            example.setVisible(true);
        });
    }

    // Custom JTextField implementation with placeholder text
    private static class PlaceholderTextField extends JTextField {

        private String placeholder;

        public PlaceholderTextField(String placeholder) {
            this.placeholder = placeholder;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (getText().isEmpty()) {
                Font previousFont = getFont();
                Color previousColor = getForeground();

                // Set the placeholder font and color
                Font placeholderFont = previousFont.deriveFont(Font.ITALIC);
                Color placeholderColor = Color.GRAY;

                setFont(placeholderFont);
                setForeground(placeholderColor);

                // Draw the placeholder text at the left offset
                int leftOffset = 5;
                g.drawString(placeholder, leftOffset, (getHeight() + g.getFontMetrics().getAscent()) / 2);

                // Restore the original font and color
                setFont(previousFont);
                setForeground(previousColor);
            }
        }
    }
}

