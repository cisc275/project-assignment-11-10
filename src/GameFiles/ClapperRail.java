package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * represents the clapperrail for the side scroll game 
 *
 */
public class ClapperRail extends Bird {

	/**
	 * describes if the bird's coordinates matches with that of a bush on screen
	 */
	boolean hidden = false; 
	/**
	 * describes if the bird has a stick
	 */
	boolean carryStick; 
	
	int xSpeed;
	int ySpeed;
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 * @param ySpeed
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public ClapperRail(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, 
			int xSpeed, int ySpeed) {
		super(x,y,width,height,hitbox,img);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.setType(Type.CLAPPERRAIL);
	}
	
	/**
	 * moves clapperrail according to x and y speed
	 * @param g
	 * @author tim Mazzarelli
	 */
  
	public void move() {
		if (this.hitbox.xpoints[0] <= 0 || this.hitbox.xpoints[3] >= 770) {
			this.xSpeed = -2 * this.xSpeed;
		}
		if (this.hitbox.ypoints[0] <= 0 || this.hitbox.ypoints[2] >= 770) {
			this.ySpeed = -2 * this.ySpeed;
		}
		
		this.hitbox.translate(this.xSpeed, this.ySpeed);
	}
	
	
	
	public void setHidden(boolean hidden) {
		
		this.hidden = hidden;
	}

	public boolean isCarryStick() {
		return carryStick;
	}

	public void setCarryStick(boolean carryStick) {
		this.carryStick = carryStick;
	}
	
	
	/**
	 * handles collision with fox f 
	 * @param f
	 * @author tim Mazzarelli
	 */
	
	public void handleCollision(Fox f) {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x, y + height);
		this.hitbox.addPoint(x + width, y + height);
		this.hitbox.addPoint(x + width, y);
	
	}
	
	
	/**
	 * @param takes an ArrayList of GameObject and checks each object (not itself) for collisions
	 * @author andrew thompson
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
	 * @return the xSpeed
	 */
	public int getxSpeed() {
		return xSpeed;
	}


	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}


	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}


	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
}
