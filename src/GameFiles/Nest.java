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
	
	public Nest(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int sticks) {
		super(x,y,width,height,hitbox,img);
		this.numSticks = sticks;
	}
	
	
	/**
	 * checks for collisions
	 * @param an arrayList of GameObjects
	 * @author Peter Jenny
	 */
	public void collision(ArrayList<GameObject> g) {
		//System.out.println("checking nest");
		//System.out.println("hitbox " + this.hitbox.getBounds());
		for (GameObject a : g) {
			if(this != a) {
				if (this.collidesWith(a)){
					System.out.println("there is coll: " + numSticks + " A " + a + " : this " + this);
					a.handleCollision(this);
				}
			}
		}		
	}
	
	
	
	
	public void drawSticks() {
		if(numSticks == 1) {
			try {
	    		BufferedImage b = ImageIO.read(new File("brown_square.png"));
	    		super.img = b;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
		}
		else if(numSticks == 2) {
			try {
	    		BufferedImage b = ImageIO.read(new File("Trash.png"));
	    		super.img = b;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
		}
		else if(numSticks == 3) {
			try {
	    		BufferedImage b = ImageIO.read(new File("Winner.png"));
	    		super.img = b;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	
	/**
	 * handles collision with stick
	 * @param a stick
	 * @author Peter Jenny
	 */
	
	/*
	 * public void handleCollision(Stick s) { System.out.
	 * println("*****************************************************nest collide");
	 * numSticks += 1; s.hitbox.reset(); }
	 */

}
