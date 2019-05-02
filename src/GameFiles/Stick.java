package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * attributes for all sticks in the game
 *
 */
public class Stick extends Collectable{
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param id
	 * @param benefit
	 * @param count
	 * @param holding
	 * @param onScreen
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	/*
	 (int y, int x, File imgPose, int width, int height, int xMin, 
			int xMax, int yMin, int yMax, int id, int benefit, boolean isDiving, int currY, int xSpeed,
			int ySpeed) {
	 */
//	public Stick(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax, int id,
//			int benefit, boolean isDiving, int currY, int xSpeed,
//			int ySpeed, int count, boolean holding, boolean onScreen) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit, isDiving, currY, xSpeed,
//				ySpeed);
//	}
	public Stick(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.setType(Type.STICK);
	}
	public Stick(BufferedImage pic, int xloc, int yloc) {
		super(pic,xloc,yloc);
		this.setType(Type.STICK);
	}
	public Stick(String string, int i, int j) {
		super(string,i,j);
		this.setType(Type.FOX);
	}
	public Stick(int i, int j) {
		super("stick.png",i,j);
		this.setType(Type.FOX);
	}
	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr
	 * @author andrew thompson
	 */
	public void handleCollision(ClapperRail cr) {
		cr.handleCollision(this);
	}
	/**
	 * the number of sticks the that have been collected
	 */
	static int count; 
	/**
	 * whether or not the bird is holding the stick
	 */
	static boolean holding;
	/**
	 * whether or not a stick is currently on screen
	 */
	static boolean onScreen;
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Stick.count = count;
	}
	public static boolean isHolding() {
		return holding;
	}
	public static void setHolding(boolean holding) {
		Stick.holding = holding;
	}
	public static boolean isOnScreen() {
		return onScreen;
	}
	public static void setOnScreen(boolean onScreen) {
		Stick.onScreen = onScreen;
	} 
	
}
