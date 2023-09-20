package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

public class PlaceholderTextField extends JTextField {

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