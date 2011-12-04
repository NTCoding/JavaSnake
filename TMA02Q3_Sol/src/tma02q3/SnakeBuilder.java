/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tma02q3;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public Polygon getDownwardFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x - headTipWidth, y);
        head.addPoint(x - headBaseWidth, y - headHeight);
        head.addPoint(x + headBaseWidth, y - headHeight);
        head.addPoint(x + headTipWidth, y);

        return head;
    }

    public Polygon getLeftFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x, y - headTipWidth);
        head.addPoint(x + headHeight, y - headBaseWidth);
        head.addPoint(x + headHeight, y + headBaseWidth);
        head.addPoint(x, y + headTipWidth);

        return head;
    }

    Polygon getRightFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x, y - headTipWidth);
        head.addPoint(x - headHeight, y - headBaseWidth);
        head.addPoint(x - headHeight, y + headBaseWidth);
        head.addPoint(x, y + headTipWidth);

        return head;
    }

    public Polygon buildTail(List<String> tailSegments, Point startPoint, int segmentLength)
    {
        Polygon tail = new Polygon();

        tail.addPoint(startPoint.x, startPoint.y);

        for(String segment: tailSegments)
        {
            if (segment.equals("up")) this.addDownPoint(tail, segmentLength);
            if (segment.equals("down")) this.addUpPoint(tail, segmentLength);
            if (segment.equals("left")) this.addRightPoint(tail, segmentLength);
            if (segment.equals("right")) this.addLeftPoint(tail, segmentLength);
        }

        return tail;
    }

    private void addDownPoint(Polygon tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.addPoint(lastPoint.x, lastPoint.y + segmentLength);
    }

    private void addUpPoint(Polygon tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.addPoint(lastPoint.x, lastPoint.y - segmentLength);
    }

    private void addRightPoint(Polygon tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.addPoint(lastPoint.x + segmentLength, lastPoint.y);
    }

    private void addLeftPoint(Polygon tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.addPoint(lastPoint.x - segmentLength, lastPoint.y);
    }

    private Point getLastPoint(Polygon tail)
    {
        int x = tail.xpoints[tail.npoints - 1];
        int y = tail.ypoints[tail.npoints - 1];

        return new Point(x, y);
    }
}
