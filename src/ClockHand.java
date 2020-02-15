import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public interface ClockHand {
	public void rotate(Graphics2D g2d,BufferedImage img,double angleRad);
	public void setIconPath(String iconPath);
	public Dimension getPreferredSize();
}