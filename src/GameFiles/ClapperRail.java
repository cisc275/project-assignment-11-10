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
	Bush closestBush;
	ArrayList<Bush> bushArr = new ArrayList<Bush>();
	
	
	final private int MOVE_AMOUNT = 10;
	
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
		x += xSpeed;
		y += ySpeed;
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
		findClosestBush();
		stillHiding();
		
	}
	
	
	/**
	 * searches through the bushArr for the closest, sets result as closestBush
	 * @author Peter Jenny
	 */
	public void findClosestBush() {
		double d = 0;
		Bush close = null;
		for(Bush b : bushArr) {
			double tmp;
			// distance formula
			double i = Math.pow(b.getX() - x, 2.0) + Math.pow((b.getY() - y), 2.0);
			tmp = Math.sqrt(i);
			System.out.println("Bush: " + b + ", x: " + b.getX() + ", y: " + b.getY() + " ,dist: " + tmp);
			if(tmp < d || d == 0) {
				d = tmp;
				close = b;
			}
		}
		closestBush = close;
		System.out.println("X: " + x + ", Y: " + y);
		System.out.println(closestBush);
	}
	
	
	/**
	 * checks to see if the CR is still hiding in the nearest bush
	 */
	public void stillHiding(){
		if (!this.collidesWith(closestBush)){
			System.out.println("not in bush");
			hidden = false;
		}
		else {
			System.out.println("!!!!! in bush !!!!");
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
