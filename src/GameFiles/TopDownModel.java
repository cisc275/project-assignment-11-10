package GameFiles;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
/**
 * Model clapperrail game
 *
 */
public class TopDownModel extends Model {
	/**
	 * clapper rail used by TDM
	 */
	public ClapperRail cr;
	
	/**
	 * fox used by TDM
	 */
    public Fox f;
    
    /**
     * nest used by TDM
     */
    public Nest nest;

    /**
     * clock checker
     */
    int count = 0; 
  
    
    /**
     * takes a hashset of integers and moves clapper rail accordingly
     * @param HashSet<Integer> keyPresses
     * @author andrew thompson
     */
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	cr.setxSpeed(0);
    	cr.setySpeed(0);
    	System.out.println(cr.xSpeed);
    	if(Powerup.power) {
    		System.out.println("************************************kill***************************************");
    		keyPresses.clear();
    		cr.setxSpeed(0);
        	cr.setySpeed(0);
        	Powerup.power = false;
    	}
    	for(Integer key: keyPresses) {
	    	switch(key) {
	    	
	    	case Constants.RIGHT:
	    		if(Powerup.power) {
	        		System.out.println("================================kill==============================");
	        		keyPresses.clear();
	        		cr.setxSpeed(0);
	            	cr.setySpeed(0);
	            	Powerup.power = false;
	        	}
	    		System.out.println("right pressed");
//	    		if(Powerup.power) {
//					cr.setxSpeed(0);
//					cr.setySpeed(0);
//					Powerup.power = false;
//				}
				cr.setxSpeed(cr.getMOVE_AMOUNT());
				
				break;
	    	case Constants.LEFT:
	    		if(Powerup.power) {
	        		System.out.println("================================kill==============================");
	        		keyPresses.clear();
	        		cr.setxSpeed(0);
	            	cr.setySpeed(0);
	        		Powerup.power = false;
	        	}
	    		System.out.println("left pressed");
				cr.setxSpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.UP:
	    		if(Powerup.power) {
	        		System.out.println("================================kill==============================");
	        		keyPresses.clear();
	        		cr.setxSpeed(0);
	            	cr.setySpeed(0);
	            	Powerup.power = false;
	        	}
				cr.setySpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.DOWN:
	    		if(Powerup.power) {
	        		System.out.println("================================kill==============================");
	        		keyPresses.clear();
	        		cr.setxSpeed(0);
	            	cr.setySpeed(0);
	            	Powerup.power = false;
	        	}
	    		cr.setySpeed(cr.getMOVE_AMOUNT());
				break;
			}
    	}
    }
  
    /**
     * initializes new TopDownModel and creates an ArrayList of GameObject
     * @author Tim Mazzarelli
     */
    public TopDownModel() {
    	cr = new ClapperRail(Constants.CLAPPER_RAIL_START_LOC_X, Constants.CLAPPER_RAIL_START_LOC_Y,
    			Constants.CLAPPER_RAIL_START_SIZE_X, Constants.CLAPPER_RAIL_START_SIZE_Y);
    	f = new Fox(Constants.FOX_START_LOC_X, Constants.FOX_START_LOC_Y, Constants.FOX_START_SIZE_X, Constants.FOX_START_SIZE_Y, cr);
    	nest = new Nest(25, 25, 50, 50);
		game = new ArrayList<GameObject>();
		game.add(cr);
		game.add(f);
		game.add(nest);	
    }
    
    
    /**
     * 
     * @param array list of GameObjects
     * updates the location of all moving objects and then calls the collision method
     * @author Tim Mazzarelli
     */
    public void updateLocation(ArrayList<GameObject> g) {
//    	if(Powerup.power) {
//    		//System.out.println("did the thing");
//			cr.setxSpeed(0);
//			cr.setySpeed(0);
//			Powerup.power = false;
//		}
    	//else {
    		//System.out.println("update answered false");
//    	}
    	ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
    	for (GameObject a : g) {
			a.move();
			a.collision(g);			
			if (a.removeObject()) toRemove.add(a);
		}
    	g.removeAll(toRemove);
    	if (Stick.count == Constants.TDM_UPDATELOCATION_STICK_COUNT) {
    		Model.gameOver = true;
    	}
    }
   
    /**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		new Controller("topDown");
		
	}

	
	
}