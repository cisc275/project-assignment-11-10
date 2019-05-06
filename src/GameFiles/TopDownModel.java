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
	public ClapperRail cr;
    public Fox f;
    public Nest nest;

    int count = 0; // used to check clock
    
    final int LEFT_BOUND = 0;
    final int BOUND_OFFSET = 134;
    final int RIGHT_BOUND = 800;
    final int CLOCK_TICK_CHECK = 100;
    
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	for(Integer key: keyPresses) {
	    	if(key.equals(39)) { //right arrow key
				cr.setxSpeed(cr.getMOVE_AMOUNT());
			}
			else if(key.equals(37)) { //left arrow key
				cr.setxSpeed(-1*cr.getMOVE_AMOUNT());
			}
			else if(key.equals(38)) { //up arrow key
				cr.setySpeed(-1*cr.getMOVE_AMOUNT());
			}
			else if(key.equals(40)) { //down arrow key
				cr.setySpeed(cr.getMOVE_AMOUNT());
			}
    	}
    }
    
    public TopDownModel() {
    	cr = new ClapperRail(400,200,100,100,new Polygon(),super.createImage(), 0, 0);
    	f = new Fox(200,200,100,100,new Polygon(), null, 3, 3, cr);
    	nest = new Nest(100, 100, 75, 75, new Polygon(), null, 0);
		game = new ArrayList<GameObject>();
		game.add(cr);
		game.add(f);
		game.add(nest);
		
    }
    
    
    /**
     * 
     * @param array list of GameObjects
     * updates the location of all moving objects and then calls the collision method
     */
    public void updateLocation(ArrayList<GameObject> g) {
    	for (GameObject a : g) {
			a.move();
			a.collision(g);		
			
		}
    }
    
    
    /**
     * 
     * @param an array list of GameObjects
     * 
     * checks all Game objects against all others in the game, calls polymorphic collision expressions 
     * when there is an intersection (not implemented yet)
     */
    
    
  
    /**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		new Controller("topDown");
		
	}

	
	
}