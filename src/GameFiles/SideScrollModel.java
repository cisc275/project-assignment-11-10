package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


/**
 * all logic for the side scroll game
 *
 */
public class SideScrollModel extends Model {
		
	/**
	 * a list of the buttons in our game
	 */
	private Fish fish;
	private Trash trash1;
	private Trash trash2;
	private Trash trash3;
	private Osprey osprey;
	
	int worldXSpeed;
	
	public SideScrollModel() {
		worldXSpeed = -10;
		
	}
	
	
	public void advanceWorld(ArrayList<GameObject> g) {
		g.get(1).setX(g.get(1).getX()+worldXSpeed);
		g.get(2).setX(g.get(2).getX()+worldXSpeed);
		g.get(3).setX(g.get(3).getX()+worldXSpeed);
		g.get(4).setX(g.get(4).getX()+worldXSpeed);
		g.get(5).setX(g.get(5).getX()+worldXSpeed);
		
		if((g.get(1).getX()) <= 0) {
			g.get(1).setX(800);
		}
		if((g.get(2).getX()) <= 0) {
			g.get(2).setX(800);
		}
		if((g.get(3).getX()) <= 0) {
			g.get(3).setX(800);
		}
		
		
	}
	
	public void advanceBird(ArrayList<GameObject> g, int yDirec) {
			g.get(0).setY(g.get(0).getY()+yDirec);
	}
	/*
	public void dive(ArrayList<GameObject> g) {
		if(!isDiving) {
			System.out.println("am i here?");
			currY = g.get(0).getY();
			advanceBird(game,50);
		}
	}
	*/
	
	/**
	 * 
	 * this method will contain the logic for moving the background image
	 * to create the illusion that the foreground images are moving
	 */
	
	/**
	 *  
	 * this method will contain the logic for advancing the icon on 
	 * the minimap to show progress during the birds migration
	 */
	public void miniMap(ArrayList<GameObject> g) {
		g.get(0).setY(g.get(0).getY() + 5);
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller("sideScroll");
		controller.sideScrollStart();
		
	}
	
	public BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("red_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public BufferedImage createImage2(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
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
	
	public BufferedImage createImage4(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("brown_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
}