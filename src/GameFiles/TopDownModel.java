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
    
    /*
     * checks time for active powerup
     */
   // int pwrCount = 0;
  
    
    /**
     * takes a hashset of integers and moves clapper rail accordingly
     * @param HashSet<Integer> keyPresses
     * @author andrew thompson
     */
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	cr.setxSpeed(0);
    	cr.setySpeed(0);
    //	System.out.println(cr.xSpeed);
    	if(Powerup.power) {
    		//System.out.println("************************************kill***************************************");
    		keyPresses.clear();
    		cr.setxSpeed(0);
        	cr.setySpeed(0);
        	Powerup.power = false;
    	}
    	for(Integer key: keyPresses) {
	    	switch(key) {
	    	
	    	case Constants.RIGHT_KEY_CODE:
	    		//System.out.println("right pressed");
				cr.setxSpeed(cr.getMOVE_AMOUNT());
				break;
	    	case Constants.LEFT_KEY_CODE:
	    	//	System.out.println("left pressed");
				cr.setxSpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.UP_KEY_CODE:
				cr.setySpeed(-cr.getMOVE_AMOUNT());
				break;
	    	case Constants.DOWN_KEY_CODE:
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
		inTutoral = false;
    }
    
    @Override
    protected void defaultSetup() {
    	game.add(cr);
		game.add(f);
		game.add(nest);
		
		Bush b1 = new Bush(500, 500,150,150);
		game.add(b1);
		cr.bushArr.add(b1);
		
		Bush b2 = new Bush(600, 20,150,150);
		game.add(b2);
		cr.bushArr.add(b2);
		
		Bush b3 = new Bush(20, 450,175,175);
		game.add(b3);
		cr.bushArr.add(b3);
    }
    
    @Override
    protected void postTutorial() {
    	game.add(new Powerup(Constants.FRAME_X, Constants.FRAME_Y - (int)(Constants.POWERUP_HEIGH * Constants.POWERUP_HEIGH_SCALE),
				(int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE), (int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE)));
		game.add(new Stick(300,300,(int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		game.add(new Stick(500, 250, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE))); 
		game.add(new Stick(400, 400, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		game.add(new TutorialObject(300, 150, 483, 110, Constants.ANIMATION_SPACEBAR));
		game.add(new TutorialObject(700, 300, 122, 122, Constants.ANIMATION_UP_KEY));
    }
    
    /**
     * 
     * @param array list of GameObjects
     * updates the location of all moving objects and then calls the collision method
     * @author Tim Mazzarelli
     */
    public void updateLocation(ArrayList<GameObject> g) {
    	if (inTutoral) {
    		postTutorial();
    	} else {
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
    }
    
    
    /**
     * handles power up effect
     * @author Peter Jenny
     */
    public void handlePwr() {
    	if(Quiz.correct) {
    		cr.lives += 1;
    		Quiz.correct = false;
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