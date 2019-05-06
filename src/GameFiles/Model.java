package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Model {
	/**
	 * a list of the objects in our game
	 */
	ArrayList<GameObject> game;
	
	public void updateLocation(ArrayList<GameObject> game) {
		// TODO Auto-generated method stub
		
	}
	public void advanceWorld(ArrayList<GameObject> game) {
		
	}

	public ArrayList<GameObject> getGame() {
		return game;
	}
	public void handleMove(HashSet<Integer> keyPresses) {}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	} 
	
	
	public void collide(ArrayList<GameObject> arr) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getType().equals(Type.CLAPPERRAIL) || arr.get(i).getType().equals(Type.OSPREY) || arr.get(i).getType().equals(Type.FOX)) {
				for(int j = i+1; j < arr.size(); j++) {
					System.out.println("Collision found between " + i + " and " + j);
					arr.get(i).collidesWith(arr.get(j));
				}
			}
		}
	}
	public BufferedImage createImage(){
		//System.out.println("Start of createImage");
    	BufferedImage bufferedImage;
    	//System.out.println("Im about to try");
    	try {
    		//System.out.println("im trying");
    		bufferedImage = ImageIO.read(new File("img/THarvey.png"));
    		
    		//System.out.println("I succeded");
    		return bufferedImage;
    	} catch (IOException e) {
    		//System.out.println("im being caught");
    		e.printStackTrace();
    	}
    	return null;
    }
	
	
}
