/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tma02q3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

/**
 *
 * @author Administrator
 */
public class SnakeBorder implements Border
{
    final int margin;
    final int pixelWidth;
    public SnakeBorder(int margin, int pixelWidth)
    {
        this.margin = margin;
        this.pixelWidth = pixelWidth;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        Color color = new Color(70, 21, 89);
        drawThickRectangle(g, color, getPixelWidth(), getMargin(), width, height);
    }

    private void drawThickRectangle(Graphics g, Color color, int pixels, int margin, int width, int height)
    {
        g.setColor(color);
        for (int i = 0; i < pixels; i++)
        {
            g.drawRect(i + margin, i + margin, (width - (margin * 2)) - (i * 2), (height - (margin * 2)) - (i * 2));
        }
    }

    @Override
    public Insets getBorderInsets(Component c)
    {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque()
    {
       return false;
    }

    private int getPixelWidth()
    {
        return this.pixelWidth;
    }

    private int getMargin()
    {
        return this.margin;
    }
}
