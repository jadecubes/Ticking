/*
 * author: Yu-Fang Juan
 * date:Feb 20th, 2017
 * title: Ticking Circus
 * All rights reserved.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.awt.image.*;
import javafx.application.Platform;

public class AlarmHand extends JClockHand implements MouseListener, MouseMotionListener{
    
    private Timer timer;
    private double angleToRotate=0;
    private boolean isValidMouseDragMode=false;
    private double curMousePressRad = 0d;
    ClockMMPlayer mmPlayer;
    public AlarmHand(String iconPath) {
        setIconPath(iconPath);
        mmPlayer = new ClockMMPlayer("./res/sound/alarm.wav");
        timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	double diff = normalizeRad(getCurrHourAngleRad())-normalizeRad(angleToRotate);
    		    if(diff < Math.toRadians(1d) && diff> Math.toRadians(-1d)) {  		    	
    		    	mmPlayer.setLooping(true);
    		    	mmPlayer.play();
    		    }
    		    else {
    		    	mmPlayer.stop();    		    	
    		    }
            }
        });
        timer.start();
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        Graphics2D g2d = (Graphics2D) g.create();
        translateHand(g2d);
        rotate(g2d,hImage,angleToRotate); 
        g2d.dispose();
    }


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = (new Point(e.getX(),e.getY()));
	    curMousePressRad=getAngleRadfromPosition(p);
		
		double diff = (angleToRotate-curMousePressRad);
		if(diff < Math.toRadians(3d) && diff> Math.toRadians(-3d))
			isValidMouseDragMode=true;
		else 
			isValidMouseDragMode=false;
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isValidMouseDragMode = false;
	}
    private double getAngleRadfromPosition(Point p){
    	Point p2 = translateClockHandPos(p); 
    	double originalAngleRad = Math.atan2(p2.getX(), p2.getY());        

    	return normalizeRad(Math.PI/2-originalAngleRad);
    }
    private double normalizeRad(double r){
        while(r>=Math.PI*2)
        	r-=Math.PI*2;
        while(r<0)
        	r+=Math.PI*2;
    	return r;
    }
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = (new Point(e.getX(),e.getY()));
	    double curRad=getAngleRadfromPosition(p);	
        //get angle of mouse move
        if(isValidMouseDragMode){  
                angleToRotate = curRad;                
    		    repaint();

	    }

		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}