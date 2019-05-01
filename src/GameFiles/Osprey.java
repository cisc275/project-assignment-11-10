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
	int currY;
	boolean isDiving;
	final double AC = 0.2;
	final int DIVESPEED = 50;
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param speed
	 * @param type
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */

	public Osprey(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, double xSpeed, 
			int ySpeed, boolean isDiving) {
		super(x, y, width, height, hitbox, img);
		this.img = createImage();
		Osprey.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.isDiving = isDiving;
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
	 */
	public void dive() {
		this.isDiving = !this.isDiving;
		this.ySpeed = DIVESPEED;
		this.currY = this.hitbox.ypoints[0];
		this.hitbox.translate(0, this.ySpeed);
		}
	
	@Override
	public void move() {
		this.hitbox.translate(0, this.ySpeed);
		if (this.hitbox.ypoints[0] >= 600) {
			this.ySpeed = -DIVESPEED;
		}
		if ((this.hitbox.ypoints[0] == this.currY) && (this.isDiving == true)) {
			this.ySpeed = 0;
			this.isDiving = !this.isDiving;
			
		}
	}
	
	@Override
	public void collision(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			if (this.collidesWith(a)){
				a.handleCollision(this);
			}
		}		
	}
	
	public void handleCollision(Osprey o) {
	}
	
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("red_square.png"));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
