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
	double xSpeed;
	double ySpeed;
	double speed;
	ClapperRail c;
	
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
	public Fox(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, 
			double xSpeed, double ySpeed, ClapperRail c) {
		super(x,y,width,height,hitbox, img);
		this.setType(Type.FOX);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.c = c;
		try {
    		this.img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	public double distance() {
		
			int xDistance = this.hitbox.xpoints[0] - c.hitbox.xpoints[0];
		
		
		int	yDistance = this.hitbox.ypoints[0] - c.hitbox.ypoints[0];
		
		
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
	
		
	}

	@Override
	public void move() {
		this.xSpeed = ((c.hitbox.xpoints[0] - this.hitbox.xpoints[0]) * 
				(Math.sqrt(Math.pow(this.xSpeed, 2) + Math.pow(this.ySpeed,  2))) / distance());
		this.ySpeed = ((c.hitbox.ypoints[0] - this.hitbox.ypoints[0]) * 
				(Math.sqrt(Math.pow(this.xSpeed, 2) + Math.pow(this.ySpeed,  2))) / distance());
		
		this.hitbox.translate((int) this.xSpeed, (int) this.ySpeed);

		

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
