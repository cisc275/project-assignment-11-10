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

	/**
	 * the number of lives the clapper rail has
	 */
	static int lives = Constants.CLAPPER_RAIL_INIT_LIVES;

	/**
	 * the bush that is closest to the clapper rail
	 */
	protected Bush closestBush;

	/**
	 * an array of Bushes
	 */
	protected ArrayList<Bush> bushArr = new ArrayList<Bush>();
	
	/**
	 *  will be used to indicate if the Clapper Rail has made a negative collision
	 */
	static public boolean negHitCr = false;
	
	/**
	 * will be used to indicate if the Clapper Rail has made a positive collision
	 */
	static public boolean posHitCr = false;

	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	public ClapperRail(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setType(Type.CLAPPERRAIL);
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.imgFileName = Constants.ANIMATION_CR_LEFT;
		this.curImg = randy.nextInt(imgFileName.length);
	}

	/**
	 * moves clapperrail according to x and y speed
	 * 
	 * @author tim Mazzarelli
	 */

	public void move() {
		this.hitbox.translate(this.xSpeed, this.ySpeed);
		boundaries();
		if (!(this.xSpeed == 0 && this.ySpeed == 0)) {
			this.animate(Constants.CLAPPER_RAIL_ANIMATION_TICK_RATE);
		}
		if(this.xSpeed < 0) {
			this.imgFileName = Constants.ANIMATION_CR_LEFT;
		}
		else if(this.xSpeed > 0) {
			this.imgFileName = Constants.ANIMATION_CR_RIGHT;
		}
	}

	/*
	 * handles collision with fox f
	 * 
	 * @param f
	 * @author tim Mazzarelli
	 *//*
		 * 
		 * public void handleCollision(Fox f) { resetPoly();
		 * 
		 * }
		 */

	/**
	 * @param takes an ArrayList of GameObject and checks each object (not itself)
	 *              for collisions
	 * @author andrew thompson
	 */
	@Override
	public void collision(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			if (this.collidesWith(a)) {
				a.handleCollision(this);
			}
		}
		findClosestBush();
		stillHiding();

	}

	/**
	 * searches through the bushArr for the closest, sets result as closestBush
	 * 
	 * @author Peter Jenny
	 */
	public void findClosestBush() {
		double d = 0;
		Bush close = null;
		for (Bush b : bushArr) {
			double tmp;
			// distance formula
			double i = Math.pow(b.getX() - hitbox.xpoints[0], 2.0) + Math.pow((b.getY() - hitbox.ypoints[0]), 2.0);
			tmp = Math.sqrt(i);
			if (tmp < d || d == 0) {
				d = tmp;
				close = b;
			}
		}
		closestBush = close;
	}

	/**
	 * checks to see if the CR is still hiding in the nearest bush
	 * 
	 * @author Peter Jenny
	 */
	public void stillHiding() {
		if (!this.collidesWith(closestBush)) {

			hidden = false;
		} else {

		}
	}

	/**
	 * Sets the hidden boolean
	 * @param hidden A boolean that will be used to set the local hidden value
	 * @author Mark Wolgin
	 */
	public void setHidden(boolean hidden) {

		this.hidden = hidden;
	}

	/**
	 * Return true if the stick is currently being carried.
	 * @return carryStick the boolean about carring the stick
	 * @author Mark Wolgin
	 */
	public boolean isCarryStick() {
		return carryStick;
	}

	/**
	 * Sets the carryStick boolean.
	 * @param carryStick The boolean to be set for the carryStick
	 * @author Mark Wolgin
	 */
	public void setCarryStick(boolean carryStick) {
		this.carryStick = carryStick;
	}

	/**
	 * Returns the xSpeed
	 * @return the xSpeed
	 * @author Mark Wolgin
	 */
	public int getxSpeed() {
		return xSpeed;
	}

	/**
	 * Sets the xSpeed
	 * @param xSpeed the xSpeed to set
	 * @author Mark Wolgin
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * Gets the ySpeed
	 * @return the ySpeed
	 * @author Mark Wolgin
	 */
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * Sets the ySpeed
	 * @param ySpeed the ySpeed to set
	 * @author Mark Wolgin
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
}
