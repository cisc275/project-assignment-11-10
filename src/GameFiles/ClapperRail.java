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
	boolean hidden; 
	/**
	 * describes if the bird has a stick
	 */
	boolean carryStick; 
	
	final private int MOVE_AMOUNT = 10;
	
	public ClapperRail(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width,height,hitbox,img);
		this.setType(Type.CLAPPERRAIL);
	}
	
  
	public void move() {
		x = x + MOVE_AMOUNT;
	}
	public boolean isHidden() {
		return hidden;
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
	
	public void handleCollision(Stick stick) {
		System.out.println("handling collision with stick");
	}
	public void handleCollision(Bush bush) {
		System.out.println("handling collision with bush");
	}
	public void handleCollision(Fish fish) {
		System.out.println("handling collision with fish");
	}
	public void handleCollision(Fox fox) {
		System.out.println("handling collision with fox");
	}
	
	
	/**
	 * @param takes an ArrayList of GameObject and checks each object (not itself) for collisions
	 * @author andrew thompson
	 */
	@Override
	public void collision(ArrayList<GameObject> gameObjects) {
		for(GameObject g: gameObjects) {
			g.handleCollision(this);
		}
	}
}
