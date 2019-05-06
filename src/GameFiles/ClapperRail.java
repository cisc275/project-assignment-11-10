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
		this.hitbox.translate(this.xSpeed, this.ySpeed);
		if (this.hitbox.ypoints[0] <= 0) {
				int x1 = this.hitbox.xpoints[0]; 
				int x2 = this.hitbox.xpoints[1];
				int x3 = this.hitbox.xpoints[2];
				int x4 = this.hitbox.xpoints[3];
				this.hitbox.reset();
				this.hitbox.addPoint(x1, 0);
				this.hitbox.addPoint(x2, height);
				this.hitbox.addPoint(x3, height);
				this.hitbox.addPoint(x4, 0);	
			}
		if (this.hitbox.ypoints[1] >= 750) {
			int x1 = this.hitbox.xpoints[0]; 
			int x2 = this.hitbox.xpoints[1];
			int x3 = this.hitbox.xpoints[2];
			int x4 = this.hitbox.xpoints[3];
			this.hitbox.reset();
			this.hitbox.addPoint(x1, 750 - height);
			this.hitbox.addPoint(x2, 750);
			this.hitbox.addPoint(x3, 750);	
			this.hitbox.addPoint(x4, 750 - height);
		}
		
		if (this.hitbox.xpoints[0] <= 0) {
			int y1 = this.hitbox.ypoints[0]; 
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			this.hitbox.reset();
			this.hitbox.addPoint(0, y1);
			this.hitbox.addPoint(0, y2);
			this.hitbox.addPoint(width, y3);
			this.hitbox.addPoint(width, y4);
		}
		
		if (this.hitbox.xpoints[2] >= 780) {
			int y1 = this.hitbox.ypoints[0]; 
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			this.hitbox.reset();
			this.hitbox.addPoint(780 - width, y1);
			this.hitbox.addPoint(780 - width, y2);
			this.hitbox.addPoint(780, y3);
			this.hitbox.addPoint(780, y4);
			
		}
		
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
