package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents air currents that osprey can use to fly faster 
 *
 */
public class AirCurrent extends Collectable {
	private static final double AC = 0.2;
	/**
	 * used to determine if the aircurrent will speed up or slow down the bird
	 */
	String direction; 
	/**
	 * describes if there is an aircurrent currently on screen
	 */
	boolean onScreen; 
	
	
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
	 * @param id
	 * @param benefit
	 * @param direction
	 * @param onScreen
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
//	public AirCurrent(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
//			int yMax, int id, int benefit, boolean isDiving, int currY, int xSpeed, int ySpeed,
//			String direction, boolean onScreen) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit, isDiving, currY, xSpeed,
//				ySpeed);
//	}
	public AirCurrent(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed) {
		super(x,y,width,height, hitbox, img, xSpeed);
		this.img = createImage();
		this.setType(Type.AIRCURRENT);
	}
	
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if((this.hitbox.xpoints[3] <= 0)) {
			this.hitbox.reset();
			this.hitbox.addPoint(x, y);
			this.hitbox.addPoint(x, y + height);
			this.hitbox.addPoint(x + width, y + height);
			this.hitbox.addPoint(x + width, y);
			System.out.println(this.hitbox.getBounds());
		}
	}
	
	@Override
	public void handleCollision(Osprey o) {
		o.setXSpeed(Osprey.getXSpeed() + AC);
	}
	
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("brown_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}

	

	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public boolean isOnScreen() {
		return onScreen;
	}


	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}
}

