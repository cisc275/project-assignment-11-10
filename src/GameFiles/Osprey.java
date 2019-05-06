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
	
	static double xSpeed;
	int ySpeed;
	// for storing y before diving
	int currY;
	boolean isDiving;
	final double AC = 1;
	final int DIVESPEED = 50;
	static double distance;
	static double maxDistance = 1500;
	
	
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

	public Osprey(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, double xSpeed, 
			int ySpeed, boolean isDiving) {
		super(x, y, width, height, hitbox, img);
		this.img = createImage();
		Osprey.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.isDiving = isDiving;
		distance = 0;
		this.setType(Type.OSPREY);
	}

	public static double getXSpeed() {
		return Osprey.xSpeed;
	}

	public void setXSpeed(double xSpeed) {
		Osprey.xSpeed = xSpeed;
	}
	
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	/**
	 * this method will be called whenever the user presses the dive button
	 * at which point the bird will dive into the water and possibly collect 
	 * fish or trash. the logic for this action will be contained here.
	 * @author tim Mazzarelli
	 */
	public void dive() {
		if (this.hitbox.xpoints[0] >= 350) {
		}
		else {
		this.isDiving = !this.isDiving;
		this.ySpeed = DIVESPEED;
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
		if (this.hitbox.ypoints[0] >= 600) {
			this.ySpeed = -DIVESPEED;
		}
		if ((this.hitbox.ypoints[0] == this.currY) && (this.isDiving == true)) {
			this.isDiving = !this.isDiving;
			this.ySpeed = 0;
		}
		if ((this.hitbox.ypoints[0] >= 350) && (this.isDiving == false)) {
			this.hitbox.reset();
			this.hitbox.addPoint(this.x, 350);
			this.hitbox.addPoint(x, 350 + height);
			this.hitbox.addPoint(x + width, 350 + height);
			this.hitbox.addPoint(x + width, 350);
			
			
			
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
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("img/Tharvey.png"));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
