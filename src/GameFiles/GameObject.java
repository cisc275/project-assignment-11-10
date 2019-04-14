package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Super class for every object in the game  
 *
 */
public class GameObject {
	/**
	 * y coordinate for this gameObject on screen
	 */
	private int y;
	/**
	 * x coordinate for this gameObject on screen
	 */
	private int x; 
	/**
	 * image that will represent the gameObject on screen
	 */
	private File imgPose; 
	/**
	 * width of the gameObject on screen
	 */
	private int width; 
	/**
	 * height of the gameObject on screen
	 */
	private int height;
	/**
	 * minimum x coordinate for this gameObject
	 */
	private int xMin; 
	/**
	 * maximum x coordinate for this gameObject
	 */
	private int xMax; 
	/**
	 * minimum y coordinate for this gameObject
	 */
	private int yMin;
	/**
	 * maximum y coordinate for this gameObject
	 */
	private int yMax; 

	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMaxa
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	public GameObject(int y, int x, File imgPose, int width, int height, int xMin, 
			int xMax, int yMin, int yMax) {
	}
	
	public GameObject() {
		
	}

	/**
	 * 
	 * @param a
	 * @return true if there's a collision false otherwise
	 * 
	 * this method compares the x and y coordinates of the gameObjects also 
	 * taking into consideration each ones width and heights to check whether 
	 * or not there has been a collision
	 * 
	 */
	public boolean collidesWith(GameObject a) {

		return true;
	}
	/**
	 * 
	 * parameters: None
	 * returns: None
	 *  
	 *  this method will be defined in subclasses so that each object knows
	 *  how to handle a collision in the even collidesWith returns true.
	 */
	public void collisions() {

	}
	
	public BufferedImage getImage() {
		return null;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public File getImgPose() {
		return imgPose;
	}

	public void setImgPose(File imgPose) {
		this.imgPose = imgPose;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getxMin() {
		return xMin;
	}

	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMin() {
		return yMin;
	}

	public void setyMin(int yMin) {
		this.yMin = yMin;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
}
