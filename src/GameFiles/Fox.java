package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents the Fox object in the clapperrail game 
 *
 */
public class Fox extends Controllable {
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
	public Fox(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax,
			boolean isDiving, int currY, int xSpeed, int ySpeed) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY,xSpeed,ySpeed);
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
	public BufferedImage getImg() {
		BufferedImage buffImg;
		try {
    		buffImg = ImageIO.read(new File(System.getProperty("user.dir").replace("\\","/")+"/imgs/fox.png"));
    		return buffImg;
		} catch (IOException e) {
    		e.printStackTrace();
    	}
		return null;
	}
}
