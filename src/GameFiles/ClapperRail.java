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
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public ClapperRail(int x, int y, int width, int height) {
		super(x,y,width, height);
		this.setType(Type.CLAPPERRAIL);
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.imgFileName = Constants.IMG_THARVEY;
		//this.img = createImage();
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
		
		if (this.hitbox.ypoints[1] >= View.frame.getHeight()) {
			int x1 = this.hitbox.xpoints[0];
			int x2 = this.hitbox.xpoints[1];
			int x3 = this.hitbox.xpoints[2];
			int x4 = this.hitbox.xpoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(x1, View.frame.getHeight() - height);
			this.hitbox.addPoint(x2, View.frame.getHeight());
			this.hitbox.addPoint(x3, View.frame.getHeight());
			this.hitbox.addPoint(x4, View.frame.getHeight() - height);			
		}
		if (this.hitbox.xpoints[3] >= View.frame.getWidth()) {
			int y1 = this.hitbox.ypoints[0];
			int y2 = this.hitbox.ypoints[1];
			int y3 = this.hitbox.ypoints[2];
			int y4 = this.hitbox.ypoints[3];
			
			this.hitbox.reset();
			this.hitbox.addPoint(View.frame.getWidth() - width, y1);
			this.hitbox.addPoint(View.frame.getWidth() - width, y2);
			this.hitbox.addPoint(View.frame.getWidth(), y3);
			this.hitbox.addPoint(View.frame.getWidth(), y4);		
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
			double i = Math.pow(b.getX() - x, 2.0) + Math.pow((b.getY() - y), 2.0);
			tmp = Math.sqrt(i);
			if(tmp < d || d == 0) {
				d = tmp;
				close = b;
			}
		}
		closestBush = close;
		
	}
	
	
	/**
	 * checks to see if the CR is still hiding in the nearest bush
	 */
	public void stillHiding(){
		if (!this.collidesWith(closestBush)){
			
			hidden = false;
		}
		else {
			
		}
	}
	
	private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(Constants.IMG_THARVEY));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
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
