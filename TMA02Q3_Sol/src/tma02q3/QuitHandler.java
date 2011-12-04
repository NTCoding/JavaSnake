/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tma02q3;

import bsh.This;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Administrator
 */
public class QuitHandler extends WindowAdapter
{

    public QuitHandler()
    {

    }

    public void windowClosing (WindowEvent e)
    {
        System.exit(0);
    }
}
