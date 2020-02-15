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

public class JClockHand extends JComponent implements ClockHand{
   
    protected BufferedImage hImage;
    protected Calendar currentTime= Calendar.getInstance();   
    protected static Dimension parentPanelSize=new Dimension();
    private double middleX = parentPanelSize.getWidth() / 2d;
    private double middleY = parentPanelSize.getHeight() / 2d;
    public JClockHand(String path){
    	assert path.length()>0;
    }
    public JClockHand(){
    	
    }
    public void setIconPath(String iconPath){
    	try {
			hImage = ImageIO.read(new File(iconPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    protected void translateHand(Graphics2D g2d){
    	g2d.translate(middleX, middleY); 
    }
    protected double getCurrHourAngleRad(){
    	currentTime.setTime(new Date(System.currentTimeMillis()));
        int hour = currentTime.get(Calendar.HOUR);
        int min =  currentTime.get(Calendar.MINUTE);
    	return ( (hour + min/60d)/12d )*2*Math.PI-(Math.PI/2);
    }
    public void rotate(Graphics2D g2d,BufferedImage img,double angleRad){
    	assert (parentPanelSize.getWidth()>0 && parentPanelSize.getHeight()>0);
    	g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.rotate(angleRad,0,0);
        g2d.drawImage(img, 0, 0, this);     	
    } 
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    }
    protected Point translateClockHandPos(Point p){
        int x = (int)(p.getX()-middleX);
        int y = (int)(p.getY()-middleY);
    	return new Point(x,y);
    }
    public static void setParentContainerSize(Dimension d){
    	parentPanelSize.setSize(d);
    }
    
}