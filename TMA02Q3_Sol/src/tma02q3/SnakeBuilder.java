/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tma02q3;

import java.awt.Polygon;

/**
 *
 * @author Administrator
 */
public class SnakeBuilder
{

    public Polygon getUpwardFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x - headTipWidth, y);
        head.addPoint(x - headBaseWidth, y + headHeight);
        head.addPoint(x + headBaseWidth, y + headHeight);
        head.addPoint(x + headTipWidth, y);

        return head;
    }

}
