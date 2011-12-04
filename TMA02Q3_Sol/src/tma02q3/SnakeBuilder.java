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
        head.addPoint(x - headBaseWidth, y);
        head.addPoint(x - headTipWidth, y - headHeight);
        head.addPoint(x + headTipWidth, y - headHeight);
        head.addPoint(x + headBaseWidth, y);

        return head;
    }

    public Polygon getDownwardFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x - headBaseWidth, y);
        head.addPoint(x - headTipWidth, y + headHeight);
        head.addPoint(x + headTipWidth, y + headHeight);
        head.addPoint(x + headBaseWidth, y);

        return head;
    }

    public Polygon getLeftFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x, y - headBaseWidth);
        head.addPoint(x - headHeight, y - headTipWidth);
        head.addPoint(x - headHeight, y + headTipWidth);
        head.addPoint(x, y + headBaseWidth);

        return head;
    }

    Polygon getRightFacingHead(int x, int y, int headTipWidth, int headBaseWidth, int headHeight)
    {
        Polygon head = new Polygon();
        head.addPoint(x, y);
        head.addPoint(x, y - headBaseWidth);
        head.addPoint(x + headHeight, y - headTipWidth);
        head.addPoint(x + headHeight, y + headTipWidth);
        head.addPoint(x, y + headBaseWidth);

        return head;
    }

    public List<Point> buildTail(List<String> tailSegments, Point startPoint, int segmentLength)
    {
        List<Point> tail = new ArrayList<Point>();

        tail.add(startPoint);

        for(String segment: this.getTailFrontFirst(tailSegments))
        {
            if (segment.equals("up")) this.addDownPoint(tail, segmentLength);
            if (segment.equals("down")) this.addUpPoint(tail, segmentLength);
            if (segment.equals("left")) this.addRightPoint(tail, segmentLength);
            if (segment.equals("right")) this.addLeftPoint(tail, segmentLength);
        }

        return tail;
    }

    private Iterable<String> getTailFrontFirst(List<String> tailSegments)
    {
        List<String> reversed = new ArrayList<String>();

        for (int i = tailSegments.size() - 1; i >= 0; i--)
        {
            reversed.add(tailSegments.get(i));
        }

        return reversed;
    }

    private void addDownPoint(List<Point> tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.add(new Point(lastPoint.x, lastPoint.y + segmentLength));
    }

    private void addUpPoint(List<Point> tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.add(new Point(lastPoint.x, lastPoint.y - segmentLength));
    }

    private void addRightPoint(List<Point> tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.add(new Point(lastPoint.x + segmentLength, lastPoint.y));
    }

    private void addLeftPoint(List<Point> tail, int segmentLength)
    {
        Point lastPoint = this.getLastPoint(tail);
        tail.add(new Point(lastPoint.x - segmentLength, lastPoint.y));
    }

    private Point getLastPoint(List<Point> tail)
    {
       return tail.get(tail.size() - 1);
    }


}
