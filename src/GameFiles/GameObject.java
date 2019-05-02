package GameFiles;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
/**
 * Super class for every object in the game  
 *
 */
public class GameObject {
	protected String imgFileName;
	protected Polygon hitbox;
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
	protected int width; 
	/**
	 * height of the gameObject on screen
	 */
	protected int height;
	/**
	 * minimum x coordinate for this gameObject
	 */
	
	
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

	public GameObject(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hitbox = hitbox;
		this.img = img;
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x, y + height);
		this.hitbox.addPoint(x + width, y + height);
		this.hitbox.addPoint(x + width, y);
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
	
	public void move() {};
	
	public boolean collidesWith(GameObject a) {
		return this.hitbox.getBounds2D().intersects(a.hitbox.getBounds2D());
		}
	/**
	 * 
	 * parameters: None
	 * returns: None
	 *  
	 *  this method will be defined in subclasses so that each object knows
	 *  how to handle a collision in the even collidesWith returns true.
	 */
	public void collision(ArrayList<GameObject> gameObjects) {}
	
	public void handleCollision(GameObject g) {
		
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
			//System.out.println("GameObject doesn't hold the answers");
		}
		return img;
	}
	/**used to scale the assigned buffered image to the width and height of the object
	 * @return buffered image that is the same size ass the object
	 * @author andrew thompson
	 */
	public BufferedImage getScaledImg(){
	    BufferedImage resizedImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(this.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	    g2.dispose();
	    return resizedImg;
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
		return hitbox;
	}

	/**
	 * @param hitBox the hitBox to set
	 */
	public void setHitBox(Polygon hitbox) {
		this.hitbox = hitbox;
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




	public void handleCollision(Osprey o) {
		// TODO Auto-generated method stub
		
	}


 	
	
}
