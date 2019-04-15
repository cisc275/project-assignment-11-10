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
		
	
	private Fish fish;
	private Trash trash1;
	private Trash trash2;
	private Trash trash3;
	private Osprey osprey;
	ArrayList<GameObject> gol;
	
	public SideScrollModel(Fish fish, Trash trash1, Trash trash2, Trash trash3, Osprey osprey) {
		this.fish = fish;
		this.trash1 = trash1;
		this.trash2 = trash2;
		this.trash3 = trash3;
		this.osprey = osprey;
		osprey.setImgPose(createImage());
		fish.setImgPose(createImage2());
		trash1.setImgPose(createImage3());
		trash2.setImgPose(createImage3());
		trash3.setImgPose(createImage3());
		gol.add(fish);
		gol.add(trash1);
		gol.add(trash2);
		gol.add(trash3);
		gol.add(osprey);
	}
	
	
	
	
	public void advanceWorld() {
		osprey.setX(osprey.getX() + osprey.getxSpeed());
		osprey.setY(osprey.getY() + osprey.getySpeed());
		fish.setX(fish.getX()-1);
		trash1.setX(trash1.getX() -1);
		trash2.setX(trash2.getX() -1);
		trash3.setX(trash3.getX() -1);
		if((fish.getX() + 134) <= 0) {
			fish.setX(800);
		}
		if((trash1.getX() + 134) <= 0) {
			trash1.setX(800);
		}
		if((trash2.getX() + 134) <= 0) {
			trash2.setX(800);
		}
		if((trash3.getX() + 134) <= 0) {
			trash3.setX(800);
		}
		if (osprey.getY() >= 550) {
			osprey.speed = -50;
		}
		if ((osprey.getY() == osprey.getcurrY()) && (osprey.getisDiving() == true)) {
			osprey.setySpeed(0);
			osprey.setisDiving(!osprey.getisDiving());
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
	
	public static void main(String[] args) {
		Controller controller = new Controller("osp");
		controller.start();
		
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
	
}
