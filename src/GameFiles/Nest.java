package GameFiles;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Nest extends GameObject{
	
	protected int numSticks = 0;
	
	public Nest(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width,height,hitbox,img);
		this.img = createImage();
	}
	
	
	/**
	 * checks for collisions
	 * @param an arrayList of GameObjects
	 * @author Peter Jenny
	 */
	
	
	

	private BufferedImage createImage(){
		BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("img/brown_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	/**
	 * handles collision with stick
	 * @param a stick
	 * @author Peter Jenny
	 */
	
	
	 public void handleCollision(Stick s) { 
		 System.out.println("*****************************************************nest collide");
		 numSticks += 1; 
		 s.hitbox.reset(); }
	 

}
