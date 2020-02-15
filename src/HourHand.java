/*
 * author: Yu-Fang Juan
 * date:Feb 20th, 2017
 * title: Ticking Circus
 * All rights reserved.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.awt.image.*;

public class HourHand extends JClockHand{
    
    private Timer timer;

    public HourHand(String iconPath) {
        setIconPath(iconPath);
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        translateHand(g2d);

        double angle = getCurrHourAngleRad();
        rotate(g2d,hImage,angle);  
        g2d.dispose();
    }


}