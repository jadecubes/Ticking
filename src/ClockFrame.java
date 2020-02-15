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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ClockFrame extends JFrame {
 
	public ClockFrame(){
		int frameWidth = 1000;
		int frameHeight=1000;
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	setPreferredSize(new Dimension(frameWidth, frameHeight));   
    	

    	class ClockLayerPane extends JLayeredPane{
    		  protected void paintComponent(Graphics g) {
    			    super.paintComponent(g);
    			    try {
						g.drawImage(ImageIO.read(new File("./res/icon/back.png")), 0, 0, null);
			    	} catch (IOException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}    		
    	}
    	ClockLayerPane panel = new ClockLayerPane();
	    panel.setOpaque(true);    	
    	panel.setBackground(Color.YELLOW);
    	add(panel);

    	JClockHand.setParentContainerSize(new Dimension(frameWidth,frameWidth));
        AlarmHand aHand=new AlarmHand("./res/icon/alarmhand.png");
        aHand.setBounds(0, 0, frameWidth, frameHeight);
        panel.add(aHand);        	
    	
        HourHand hHand=new HourHand("./res/icon/hourhand.png");
    	hHand.setBounds(0, 0, frameWidth, frameHeight);
        panel.add(hHand);    	    	
        
    	MinuteHand mHand=new MinuteHand("./res/icon/minhand.png");
    	mHand.setBounds(0, 0, frameWidth, frameHeight);
        panel.add(mHand);

    	SecondHand sHand=new SecondHand("./res/icon/sechand.png");
    	sHand.setBounds(0, 0, frameWidth, frameHeight);
        panel.add(sHand);

        setTitle("Ticking Circus");
        pack();
        setVisible(true);
        
    }
}
