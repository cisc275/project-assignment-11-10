package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
/**
 * Model clapperrail game
 *
 */
public class TopDownModel extends Model {
	int xloc = 0;
    int yloc = 0;
    int xChg = 0;
    int yChg = 0;
    int imgWidth = 0;
    int imgHeight = 0;
    int frameWidth = 0;
    int frameHeight = 0;
	//ArrayList<GameObject> game;

    
    public TopDownModel(int x, int y, int imgW, int imgH) {
    	imgWidth = x;
		imgHeight = y;
		frameWidth = imgW;
		frameHeight = imgH;
		//game = new ArrayList<GameObject>();
		//game.add(new GameObject(createImage(),100,100));
    }
    public void setVel(int xvel, int yvel) {
    	xChg = 12*xvel;
    	yChg = 12*yvel;
    	System.out.println();
    }
    public void updateLocation() {
    	if(xloc+xChg > (imgWidth - frameWidth) || xloc+xChg < 0) {
        	xChg = 0;
        	
        }
        if(yloc+yChg > (imgHeight - frameHeight) || yloc+yChg < 0) {
        	yChg = 0;
        }
        xloc+=xChg;
        yloc+=yChg;
    }
	/**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		Controller theControl = new Controller();
		theControl.topDownStart();
	}
	public BufferedImage createImage(){
		System.out.println("Start of createImage");
    	BufferedImage bufferedImage;
    	System.out.println("Im about to try");
    	try {
    		System.out.println("im trying");
    		bufferedImage = ImageIO.read(new File("red_square.png"));
    		if (bufferedImage != null) {
    			System.out.println("im hella confused");
    		}
    		System.out.println("I succeded");
    		return bufferedImage;
    	} catch (IOException e) {
    		//System.out.println("im being caught");
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public BufferedImage createImage2(){
		BufferedImage bufferedImage;
		System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("blue_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	public BufferedImage createImage3(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("green_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	public int getX() {
		return xloc;
	}
	public int getY() {
		return yloc;
	}
	public int getXloc() {
		return xloc;
	}
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}
	public int getYloc() {
		return yloc;
	}
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}
	public int getxChg() {
		return xChg;
	}
	public void setxChg(int xChg) {
		this.xChg = xChg;
	}
	public int getyChg() {
		return yChg;
	}
	public void setyChg(int yChg) {
		this.yChg = yChg;
	}
	public int getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}
	public int getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	public int getFrameWidth() {
		return frameWidth;
	}
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}
	public int getFrameHeight() {
		return frameHeight;
	}
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}
}
