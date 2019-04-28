package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents the bush(es) that the clapperrail can use to hide
 *
 */
public class Bush extends NonControllable {

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
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	/*
	 (int y, int x, File imgPose, int width, int height,
	int xMin, int xMax, int yMin, int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed)
	 */
//	public Bush(int y, int x, File imgPose, int width, int height,
//			int xMin, int xMax, int yMin, int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY, xSpeed, ySpeed);
//	}
	public Bush(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.setType(Type.BUSH);
	}
	public Bush(BufferedImage pic, int xloc, int yloc) {
		super(pic,xloc,yloc);
		this.setType(Type.BUSH);
	}
	public Bush(String string, int i, int j) {
		super(string,i,j);
		this.setType(Type.BUSH);
	}
	public BufferedImage gtImage() {
		BufferedImage buffImg;
		try {
    		buffImg = ImageIO.read(new File("bush.png"));
    		return buffImg;
		} catch (IOException e) {
    		e.printStackTrace();
    	}
		return null;
	}

}
