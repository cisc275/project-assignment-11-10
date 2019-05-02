package GameFiles;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents the Fox object in the clapperrail game 
 *
 */
public class Fox extends Controllable {
	static String fileName="fox.png";
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param speed
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	/*
	 public Controllable(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
	 */
	public Fox(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width,height,hitbox, img);
		this.setType(Type.FOX);
		try {
    		this.img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
    		e.printStackTrace();
    	}
	}

	/**
	 * @param None
	 * @return true if the bird is visible false otherwise
	 * 
	 * this method will scan within a predetermined range to see if the bird's location is within 
	 * the foxes view if so true will be returned. false otherwise 
	 */
	public boolean birdVisible() {
		
		return false;
	}
	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr
	 * @author andrew thompson
	 */
	public void handleCollision(ClapperRail cr) {
		cr.handleCollision(this);
	}
}
