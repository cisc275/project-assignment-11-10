package GameFiles;
import java.awt.Polygon;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
/**
 * Super class for every object in the game  
 * @author wolginm
 */

public class GameObject implements Serializable{
	
	/**
	 * serialVersionUID autogenerated
	 */
	private static final long serialVersionUID = -333987237480412477L;

	/**
	 *  The array of strings of the file where the image is located
	 */
	protected String[] imgFileName;
	
	/**
	 * The objects hit box
	 */
	protected Polygon hitbox;
	
	/**
	 *  The file path image to be displayed
	 */
	protected String img;
	
	/**
	 * the string for the scaled image
	 */
	
	protected String scaledImg;
	
	/**
	 * y coordinate for this gameObject on screen
	 */
	protected int y;
	/**
	 * x coordinate for this gameObject on screen
	 */
	protected int x; 
	/**
	 * image that will represent the gameObject on screen
	 */
	private File imgPose; 
	/**
	 * width of the gameObject on screen
	 */
	protected int width; 
	/**
	 * height of the gameObject on screen
	 */
	protected int height;
	
	/**
	 * index of Animation array
	 */
	protected int curImg;
	
	/**
	 * number of ticks for the animation
	 */
	protected int curImgTickCount;
	
	/**
	 * whether or not you can see an object on the screen
	 */
	protected boolean visible;
	
	/**
	 * random object used randomly throughout program
	 */
	protected Random randy;

	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hitbox = new Polygon();
		this.curImg = Constants.GAME_OBJECT_START_IMAGE;
		this.curImgTickCount = Constants.GAME_OBJECT_START_IMAGE;
		this.visible = true;
		randy = new Random();
		resetPoly();
	}
	
	
	/**
	 * 
	 *  Resets Polygon with its origin at x, y and its size to be its width and height
	 * 
	 * @author Timothy Mazzarelli
	 */
	public void resetPoly() {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x, y + height);
		this.hitbox.addPoint(x + width, y + height);
		this.hitbox.addPoint(x + width, y);
	}
	
	
	/**
	 * 
	 * @param a GameObject
	 * @return true if there's a collision false otherwise
	 * 
	 * this method compares the x and y coordinates of the gameObjects also 
	 * taking into consideration each ones width and heights to check whether 
	 * or not there has been a collision
	 * 
	 * @author Timothy Mazzarelli
	 */
	
	public boolean collidesWith(GameObject a) {
		return this.hitbox.getBounds2D().intersects(a.hitbox.getBounds2D());
		}
	
	/**
	 * will be defined in subclasses and tell each object how to move
	 */
	
	public void move() {};
	
	/**  
	 *  this method will be defined in subclasses so that each object knows
	 *  how to handle a collision in the even collidesWith returns true.
	 * @param gameObjects ArrayList of GameObjects
	 */
	public void collision(ArrayList<GameObject> gameObjects) {}
	
	
	/**
	 * GameObjects version of this method has no effects. overridden in subclasses
	 * 
	 * @param g Takes the GameObject to handle its collison.
	 */
	public void handleCollision(GameObject g) {
		
	}
	
	
	public boolean removeObject() {
		return !visible;
	}
	
	
	/**
	 * returns the String that is actually the path to each image
	 * @return String
	 */
	public String getImage() {
		
		return img;
	}
	
	/**
	 * used to handle animation and what tick you are on
	 * @param constant The rate to change the image by
	 * @author Andrew Thompson
	 * @author Mark Wolgin
	 */
	
	public void animate(int constant) {
		this.curImgTickCount ++;
		if (curImgTickCount == constant) {
			curImg = (curImg + 1) % this.imgFileName.length;
			curImgTickCount = 0;
		}	
	}
		

	/**
	 * @return the hitbox
	 */
	public Polygon getHitbox() {
		return hitbox;
	}


	/**
	 * @param hitbox the hitbox to set
	 */
	public void setHitbox(Polygon hitbox) {
		this.hitbox = hitbox;
	}


	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * @return the imgPose
	 */
	public File getImgPose() {
		return imgPose;
	}


	/**
	 * @param imgPose the imgPose to set
	 */
	public void setImgPose(File imgPose) {
		this.imgPose = imgPose;
	}


	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * @return the imgFileName
	 */
	public String[] getImgFileName() {
		return imgFileName;
	}

	/**
	 * @param imgFileName the imgFileName to set
	 */
	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}

	/**
	 * @return the hitBox
	 */
	public Polygon getHitBox() {
		return hitbox;
	}

	/**
	 * @param hitbox the hitBox to set
	 */
	public void setHitBox(Polygon hitbox) {
		this.hitbox = hitbox;
	}

	/**
	 * overwritten in subclasses to handle collision
	 * @param o Game Osprey
	 */

	public void handleCollision(Osprey o) {
		// TODO Auto-generated method stub
	}

	/**
	 * overwritten in subclasses to handle collision
	 * @param cr Game ClapperRail
	 */
	public void handleCollision(ClapperRail cr) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * overwritten in subclasses to handle collision
	 * @param f Game Fox
	 */
	public void handleCollision(Fox f) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * overwritten in subclasses to handle collision
	 * @param n Game Nest
	 */
	public void handleCollision(Nest n) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return string
	 * to string method
	 */
	
	public String toString() {
		return this.getClass() + " X: " + x + " Y: " + y;
	}


 	
	
}
