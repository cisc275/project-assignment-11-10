package GameFiles;

import java.awt.Polygon;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


/**
 * represents the osprey in the top down view game 
 *
 */
public class Osprey extends Bird {
	
	static int xSpeed;
	int ySpeed;
	// for storing y before diving
	int currY;
	boolean isDiving;
	static double distance;
	static double maxDistance = 500;
	BufferedImage[] imgs = new BufferedImage[3];
	final int MAX_Y_SPEED;
	
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 * @param ySpeed
	 * @param isDiving
	 * @param currY
	 * 
	 * a constructor that takes values for all fields except currY as input parameters
	 */

	public Osprey(int x, int y, int width, int height) {
		super(x, y, width, height);
		//createImage();
		this.imgFileName = Constants.IMG_OSPREY;
		this.img = imgs[0];
		Osprey.xSpeed = -10;
		this.ySpeed = 0;
		this.isDiving = false;
		distance = 0;
		MAX_Y_SPEED = (int)(height/3);
		this.setType(Type.OSPREY);
	}

	public static int getXSpeed() {
		return Osprey.xSpeed;
	}

	public void setXSpeed(int xSpeed) {
		Osprey.xSpeed = xSpeed;
	}
	
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public int getYSpeed() {
		return this.ySpeed;
	}
	public int getMaxYSpeed() {
		return MAX_Y_SPEED;
	}
	
	/**
	 * this method will be called whenever the user presses the dive button
	 * at which point the bird will dive into the water and possibly collect 
	 * fish or trash. the logic for this action will be contained here.
	 * @author tim Mazzarelli
	 */
	public void dive() {
		if (this.hitbox.ypoints[0] <= Constants.OSPREY_WATER_LEVEL) {
		this.img = imgs[1];
		this.isDiving = !this.isDiving;
		this.ySpeed = Constants.OSPREY_DIVESPEED;
		this.currY = this.hitbox.ypoints[0];
		this.hitbox.translate(0, this.ySpeed);
		}
	}
	
	/**
	 * moves the osprey according to location and ySpeed determined by key inputs
	 * @param g
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {
		this.hitbox.translate(0, this.ySpeed);
		
		distance -= Osprey.xSpeed; 
		if (this.hitbox.ypoints[0] >= (View.frame.getHeight() * 0.9)) {
			this.ySpeed = -Constants.OSPREY_DIVESPEED;
		}
		if ((this.hitbox.ypoints[0] == this.currY) && (this.isDiving == true)) {
			this.isDiving = !this.isDiving;
			this.ySpeed = 0;
		}
		if ((this.hitbox.ypoints[0] >= Constants.OSPREY_WATER_LEVEL) && (this.isDiving == false)) {
			this.hitbox.reset();
			this.hitbox.addPoint(this.x, Constants.OSPREY_WATER_LEVEL);
			this.hitbox.addPoint(x, Constants.OSPREY_WATER_LEVEL + height);
			this.hitbox.addPoint(x + width, Constants.OSPREY_WATER_LEVEL + height);
			this.hitbox.addPoint(x + width, Constants.OSPREY_WATER_LEVEL);
						
		}
		if ((this.hitbox.ypoints[0] <= 0)) {
			this.hitbox.reset();
			this.hitbox.addPoint(this.x, 0);
			this.hitbox.addPoint(x, height);
			this.hitbox.addPoint(x + width, height);
			this.hitbox.addPoint(x + width, 0);
		
			
		}
		
	}
	
	/**
	 * checks for collision in ArrayList of gameobjects and sends to handle accordingly
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
	
	// creates image for Osprey
	private BufferedImage[] createImage(){
		
		try {
			if (Constants.BOOL_HARVEY) imgs[2] = ImageIO.read(new File(Constants.IMG_THARVEY));
			else {  
				imgs[0] = ImageIO.read(new File(Constants.IMG_OSPREY));
				imgs[1] = ImageIO.read(new File(Constants.IMG_OSPREY_DIVE));
			}
			return imgs;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
