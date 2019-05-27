package GameFiles;

import java.util.ArrayList;



public class Nest extends GameObject{
	
	/**
	 * the number of sticks that have been put in the nest
	 */
	protected int numSticks = 0;
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	public Nest(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.imgFileName = Constants.ANIMATION_NEST;
		this.curImg = randy.nextInt(imgFileName.length);
	}
	
	
	/**
	 * checks for collisions
	 * @param g an arrayList of GameObjects
	 * @author Peter Jenny
	 */
	
	@Override
	public void collision(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			a.handleCollision(this);
		}
	}
	
		
}
