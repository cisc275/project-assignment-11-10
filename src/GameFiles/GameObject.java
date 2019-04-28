package GameFiles;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Super class for every object in the game  
 *
 */
public class GameObject {
	String imgFileName;
	Polygon hitBox;
	protected BufferedImage img;
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
	
	private boolean isDiving;
	
	private int currY;
	
	private int xSpeed;
	
	private int ySpeed;
	
	private Type type;

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
	 * @param isDiving
	 * @param currY
	 * @param xSpeed
	 * @param ySpeed
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
//	public GameObject(int y, int x, File imgPose, int width, int height, int xMin, 
//			int xMax, int yMin, int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
//	}
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		int xs[] = {x, x, x+width, x+width};
		int ys[] = {y, y+height, y, y+height};
		this.hitBox = new Polygon(xs, ys, 4);
		type = Type.GAMEOBJECT;
	}
	
	public GameObject(BufferedImage pic, int xloc, int yloc) {
		img = pic;
		x = xloc;
		y = yloc;
		int xs[] = {xloc, xloc, xloc+img.getWidth(), xloc+img.getWidth()};
		int ys[] = {yloc, yloc+img.getHeight(), yloc, yloc+img.getHeight()};
		this.hitBox = new Polygon(xs, ys, 4);
		type = Type.GAMEOBJECT;
	}
	
	public GameObject(String path, int xloc, int yloc) {
		img = createImage(new File(path));
		x = xloc;
		y = yloc;
		int xs[] = {xloc, xloc, xloc+img.getWidth(), xloc+img.getWidth()};
		int ys[] = {yloc, yloc+img.getHeight(), yloc, yloc+img.getHeight()};
		this.hitBox = new Polygon(xs, ys, 4);
		type = Type.GAMEOBJECT;
	}

	/**
	 * @param imgFileName
	 * @param hitBox
	 * @param img
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param isDiving
	 * @param currY
	 * @param xSpeed
	 * @param ySpeed
	 */
	public GameObject(String imgFileName, Polygon hitBox, BufferedImage img, int y, int x, File imgPose, int width,
			int height, int xMin, int xMax, int yMin, int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
		super();
		this.imgFileName = imgFileName;
		this.hitBox = hitBox;
		this.img = img;
		this.y = y;
		this.x = x;
		this.imgPose = imgPose;
		this.width = width;
		this.height = height;
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
		this.isDiving = isDiving;
		this.currY = currY;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		type = Type.GAMEOBJECT;
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
	
	@Override
	public String toString() {
		return this.type.toString() + ", X pos: " + this.x + ", Y pos: " + this.currY;
	}
	
	public BufferedImage createImage(File path) {
		BufferedImage g;
		try {
    		//System.out.println("im trying");
    		g = ImageIO.read(path);
    		
    		//System.out.println("I succeded");
    		return g;
    	} catch (IOException e) {
    		//System.out.println("im being caught");
    		e.printStackTrace();
    	}
		return null;
	}
	
	public BufferedImage getImage() {
		if (img != null) {
			System.out.println("GameObject doesn't hold the answers");
		}
		return img;
	}
	public void setImage(BufferedImage pic) {
		this.img = pic;
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
	
	public void setisDiving(boolean isDiving) {
		this.isDiving = isDiving;
	}
	
	public boolean getisDiving() {
		return isDiving;
	}
	
	public void setcurrY(int currY) {
		this.currY = currY;
	}
	
	public int getcurrY() {
		return currY;
		
	}
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public int getxSpeed() {
		return xSpeed;
	}
	
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * @return the imgFileName
	 */
	public String getImgFileName() {
		return imgFileName;
	}

	/**
	 * @param imgFileName the imgFileName to set
	 */
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	/**
	 * @return the hitBox
	 */
	public Polygon getHitBox() {
		return hitBox;
	}

	/**
	 * @param hitBox the hitBox to set
	 */
	public void setHitBox(Polygon hitBox) {
		this.hitBox = hitBox;
	}

	/**
	 * @return the isDiving
	 */
	public boolean isDiving() {
		return isDiving;
	}

	/**
	 * @param isDiving the isDiving to set
	 */
	public void setDiving(boolean isDiving) {
		this.isDiving = isDiving;
	}

	/**
	 * @return the currY
	 */
	public int getCurrY() {
		return currY;
	}

	/**
	 * @param currY the currY to set
	 */
	public void setCurrY(int currY) {
		this.currY = currY;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	
}
