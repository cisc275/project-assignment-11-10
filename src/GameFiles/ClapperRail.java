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
	Bush closestBush;
	
	/**
	 * an array of Bushes
	 */
	ArrayList<Bush> bushArr = new ArrayList<Bush>();
	
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public ClapperRail(int x, int y, int width, int height) {
		super(x,y,width, height);
		this.setType(Type.CLAPPERRAIL);
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.imgFileName = Constants.ANIMATION_THARVEY;
		this.curImg = randy.nextInt(imgFileName.length);
		//this.img = createImage();
	}
	
	
	/**
	 * moves clapperrail according to x and y speed
	 * @param none
	 * @author tim Mazzarelli
	 */
  
	public void move() {
		this.hitbox.translate(this.xSpeed, this.ySpeed);
		boundaries();
		
	}
	
	/**
	 * handles collision with fox f 
	 * @param f
	 * @author tim Mazzarelli
	 */
	
	public void handleCollision(Fox f) {
		resetPoly();
	
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
			double i = Math.pow(b.getX() - hitbox.xpoints[0], 2.0) + Math.pow((b.getY() - hitbox.ypoints[0]), 2.0);
			tmp = Math.sqrt(i);
			System.out.print(b + ";           ");
			if(tmp < d || d == 0) {
				d = tmp;
				close = b;
			}
		}
		System.out.println();
		System.out.println("CR ========== " + hitbox.getBounds());
		closestBush = close;
		System.out.println(close);
		System.out.println();
		
	}
	
	
	/**
	 * checks to see if the CR is still hiding in the nearest bush
	 * @author Peter Jenny
	 */
	public void stillHiding(){
		if (!this.collidesWith(closestBush)){
			
			hidden = false;
		}
		else {
			
		}
	}
	
	/**
	 * 
	 * @param hidden
	 */
	
	public void setHidden(boolean hidden) {
		
		this.hidden = hidden;
	}
	
	/**
	 * 
	 * @return carryStick
	 */

	public boolean isCarryStick() {
		return carryStick;
	}

	/**
	 * 
	 * @param carryStick
	 */
	public void setCarryStick(boolean carryStick) {
		this.carryStick = carryStick;
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
	
//	private BufferedImage createImage(){
//    	BufferedImage bufferedImage;
//    	try {
//    		bufferedImage = ImageIO.read(new File(Constants.IMG_THARVEY));
//    		return bufferedImage;
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    	return null;
//    }
}
