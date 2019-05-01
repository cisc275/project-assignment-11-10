package GameFiles;

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
	
	public ClapperRail(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.setType(Type.CLAPPERRAIL);
	}
	
	public ClapperRail(BufferedImage pic, int xloc, int yloc) {
		super(pic,xloc,yloc);
		this.setType(Type.CLAPPERRAIL);
	}

	public ClapperRail(String string, int i, int j) {
		super(string,i,j);
		this.setType(Type.CLAPPERRAIL);
	}

	public ClapperRail(int i, int j) {
		super("cr.png",i,j);
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
		System.out.println("handling collision with ");
	}
	
	
	/**
	 * @param takes an ArrayList of GameObject and checks each object (not itself) for collisions
	 * @author andrew thompson
	 */
	@Override
	public void collision(ArrayList<GameObject> gameObjects) {
		for(GameObject g: gameObjects) {
			if(!this.equals(g) && this.collidesWith(g)) {
				g.handleCollision(this);
			}
		}
	}
}
