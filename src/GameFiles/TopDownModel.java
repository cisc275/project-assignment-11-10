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
	private Fox fox;
	private Bush bush1;
	private Bush bush2;
	private Bush bush3;
	private ClapperRail cl;
	private Fox foxhold;
	ArrayList<GameObject> gol;
	
	public TopDownModel(Fox fox, Bush bush1, Bush bush2, Bush bush3, ClapperRail cl, Fox foxhold) {
		this.fox = fox;
		this.bush1 = bush1;
		this.bush2 = bush2;
		this.bush3 = bush3;
		this.cl = cl;
		this.foxhold = foxhold;
		fox.setImgPose(createImage2());
		fox.setImgPose(createImage2());
		cl.setImgPose(createImage());
		bush1.setImgPose(createImage3());
		bush2.setImgPose(createImage3());
		bush3.setImgPose(createImage3());
		gol.add(fox);
		gol.add(bush1);
		gol.add(bush2);
		gol.add(bush3);
		gol.add(cl);
		gol.add(foxhold);
	}
	
	
	
	
	public void advanceWorld() {
		cl.setX(cl.getX() + cl.getxSpeed());
		cl.setY(cl.getY() + cl.getySpeed());
		if(((cl.getX() >= 380)&&(cl.getX() <= 420)) && 
				((cl.getY() >= 380)&&(cl.getY() <= 420))) {
			fox = null;
		}
		else if ((fox == null)&&(!(((cl.getX() >= 380)&&(cl.getX() <= 420))&&
				((cl.getY() >= 380)&&(cl.getY() <= 420))))) {
			fox = foxhold;
		}
		
	}
	
	
	
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
	public void miniMap() {
		
		
	}
	
	private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("red_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
	
	private BufferedImage createImage2(){
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
	private BufferedImage createImage3(){
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


	
	public static void main(String[] args) {
		Controller controller = new Controller("cr");
		controller.start();
		
	}
	
}
