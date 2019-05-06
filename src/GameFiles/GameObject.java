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
 * @author wolginm
 */

public class GameObject {
	
	/**
	 *  The string of the file where the image is located
	 */
	protected String imgFileName;
	
	/**
	 * The objects hit box
	 */
	protected Polygon hitbox;
	
	/**
	 *  The image to be displayed
	 */
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
	 * @param x
	 * @param y 
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * 
	 * A constructor that takes values for all fields as input parameters
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
	 * 
	 * @param a
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
	 * 
	 * parameters: None
	 * returns: None
	 *  
	 *  this method will be defined in subclasses so that each object knows
	 *  how to handle a collision in the even collidesWith returns true.
	 */
	public void collision(ArrayList<GameObject> gameObjects) {}
	
	
	/**
	 * GameObjects version of this method has no effects.
	 * 
	 * @param g Takes the GameObject to handle its collison.
	 */
	public void handleCollision(GameObject g) {
		/*
		 * There is nothing here.
		 * 
		 * To entertain you dear reader, please enjoy this,
		 * 
		 * 	SIR BEDEVERE: And that, my liege, is how we know the earth to be banana-shaped.
			ARTHUR: This new learning amazes me, Sir Bedevere. Explain again how sheep's bladders may be employed to prevent earthquakes.
			BEDEVERE: Oh, certainly, sir.
			SIR LANCELOT: Look, my liege!
			[trumpets]
			ARTHUR: Camelot!
			SIR GALAHAD: Camelot!
			LANCELOT: Camelot!
			PATSY: It's only a model.
			ARTHUR: Shh! Knights, I bid you welcome to your new home. Let us ride... to... Camelot!
			[in medieval hall]
			KNIGHTS: We're Knights of the Round Table. We dance whene'er we're able. We do routines and chorus scenes With footwork impeccable. We dine well here in Camelot. We eat ham and jam and spam a lot.
			[dancing]
			We're Knights of the Round Table. Our shows are formidable, But many times we're given rhymes That are quite unsingable. We're opera mad in Camelot. We sing from the diaphragm a lot.
			[in dungeon]
			PRISONER: [clap clap clap clap]
			[in medieval hall]
			KNIGHTS: [tap-dancing]
			In war we're tough and able, Quite indefatigable. Between our quests we sequin vests and impersonate Clark Gable. It's a busy life in Camelot.
			MAN: I have to push the pram a lot.
			[outdoors]
			ARTHUR: Well, on second thought, let's not go to Camelot. It is a silly place.
			KNIGHTS: Right. Right.
		 * 
		 */
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
	public BufferedImage getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
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


	public void handleCollision(ClapperRail cr) {
		// TODO Auto-generated method stub
		
	}


	public void handleCollision(Fox f) {
		// TODO Auto-generated method stub
		
	}


	public void handleCollision(Nest n) {
		// TODO Auto-generated method stub
		
	}


 	
	
}
