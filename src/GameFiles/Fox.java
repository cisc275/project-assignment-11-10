package GameFiles;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * represents the Fox object in the clapperrail game 
 *
 */
public class Fox extends Controllable {
	static String fileName="img/fox.png";
	double xSpeed;
	double ySpeed;
	double speed;
	ClapperRail c;
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 * @param ySpeed
	 * @param c
	 * 
	 * a constructor that takes values for all fields as input parameters
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
	
	/**
	 * overrides super method and checks arraylist for any possible collisions
	 * @param g
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void collision(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			if (this.collidesWith(a)){
				a.handleCollision(this);

			}
		}		
	}
	
	/**
	 * handles collision with clapperrail
	 * @param c
	 * @author tim Mazzarelli
	 */
	
	public void handleCollision(ClapperRail c) {
		c.hitbox.reset();
		c.hitbox.addPoint(x, y);
		c.hitbox.addPoint(x, y + height);
		c.hitbox.addPoint(x + width, y + height);
		c.hitbox.addPoint(x + width, y);
	
	}
	
	/**
	 * calculates distance between fox and clapperrail
	 * @param g
	 * @author tim Mazzarelli
	 */
		
	public double distance() {	
		int xDistance = this.hitbox.xpoints[0] - c.hitbox.xpoints[0];
		int	yDistance = this.hitbox.ypoints[0] - c.hitbox.ypoints[0];
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		}
		
	/**
	 * moves the fox according to calculated xSpeed and ySpeed 
	 * based on clapperrail position
	 * @param g
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {
		this.hitbox.translate(2 * (int) this.xSpeed, 2 * (int) this.ySpeed);
		this.xSpeed = ((c.hitbox.xpoints[0] - this.hitbox.xpoints[0]) * 
				(Math.sqrt(Math.pow(this.xSpeed, 2) + Math.pow(this.ySpeed,  2))) / distance());
		this.ySpeed = ((c.hitbox.ypoints[0] - this.hitbox.ypoints[0]) * 
				(Math.sqrt(Math.pow(this.xSpeed, 2) + Math.pow(this.ySpeed,  2))) / distance());	
	}
}	
