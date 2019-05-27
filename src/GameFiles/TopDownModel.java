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
     * The tutorial power up
     */
    private Powerup tpow = null;
    
    /**
     * The tutorial stick
     */
    private Stick tstick = null;
    
    /**
     * The tutorial down arrow key
     */
    private TutorialObject tdown_key = null;
    
    /**
     * The tutorial up arrow key
     */
    private TutorialObject tup_key = null;
    
    /**
     * The tutorial left arrow key
     */
    private TutorialObject tleft_key = null;
    
    /**
     * The tutorial right arrow key
     */
    private TutorialObject tright_key = null;
    
    /**
     * The tutorial arrow
     */
    private TutorialArrow tarrow = null;
    
    /**
     * The game first bush
     */
    private Bush b1 = null;
    
    /**
     * The game first bush
     */
    private Bush b2 = null;
    
    /**
     * The game first bush
     */
    private Bush b3 = null;
    
    /**
     * The game first bush
     */
    private Bush b4 = null;
    
    /**
     * For comparing the Tutorial Arrows current height
     */
    private int tarrow_cur_height;
    
    /**
     * For comparing the Tutorial Arrows current width
     */
    private int tarrow_cur_width;

    
    /**
     * initializes new TopDownModel and creates an ArrayList of GameObject
     * @author Tim Mazzarelli
     */
    public TopDownModel() {
    	cr = new ClapperRail(Constants.CLAPPER_RAIL_START_LOC_X, Constants.CLAPPER_RAIL_START_LOC_Y,
    			Constants.CLAPPER_RAIL_START_SIZE_X, Constants.CLAPPER_RAIL_START_SIZE_Y);
    	nest = new Nest(Constants.NEST_X, Constants.NEST_Y, Constants.NEST_START_SIZE, Constants.NEST_START_SIZE);
		game = new ArrayList<GameObject>();
		inTutoral = true;
    }
  
    
    /**
     * takes a hashset of integers and moves clapper rail accordingly
     * @param  keyPresses	The HashSet of the current pressed keys.
     * @author andrew thompson
     */
    @Override
    public void handleMove(HashSet<Integer> keyPresses) {
    	cr.setxSpeed(Constants.CLAPPER_RAIL_START_XSPEED);
    	cr.setySpeed(Constants.CLAPPER_RAIL_START_YSPEED);
    	if(Quiz.answered == true) {
    		keyPresses.clear();
    		cr.setxSpeed(Constants.CLAPPER_RAIL_START_XSPEED);
        	cr.setySpeed(Constants.CLAPPER_RAIL_START_YSPEED);
        	Quiz.answered = false;
    	}
    	for(Integer key: keyPresses) {
	    	switch(key) {
	    	
	    	case Constants.RIGHT_KEY_CODE:
	    		//System.out.println("right pressed");
				cr.setxSpeed(Constants.BIRD_MOVE_AMOUNT);
				break;
	    	case Constants.LEFT_KEY_CODE:
	    	//	System.out.println("left pressed");
				cr.setxSpeed(-Constants.BIRD_MOVE_AMOUNT);
				break;
	    	case Constants.UP_KEY_CODE:
				cr.setySpeed(-Constants.BIRD_MOVE_AMOUNT);
				break;
	    	case Constants.DOWN_KEY_CODE:
	    		cr.setySpeed(Constants.BIRD_MOVE_AMOUNT);
				break;
			}
    	}
    }
  
   
     
    // No fox in by default
    /* (non-Javadoc)
     * @see GameFiles.Model#defaultSetup()
     */
    @Override
    protected void defaultSetup() {
    	game.add(nest);
    	game.add(cr);
		
		b1 = new Bush(Constants.BUSH_X_ARR[0], Constants.BUSH_Y_ARR[0], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b1);
		cr.bushArr.add(b1);
		
		b2 = new Bush(Constants.BUSH_X_ARR[1], Constants.BUSH_Y_ARR[1], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b2);
		cr.bushArr.add(b2);
		
		b3 = new Bush(Constants.BUSH_X_ARR[2], Constants.BUSH_Y_ARR[2], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b3);
		cr.bushArr.add(b3);
		
		b4 = new Bush(Constants.BUSH_X_ARR[3], Constants.BUSH_Y_ARR[3], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b4);
		cr.bushArr.add(b4);
    }
    
    /* (non-Javadoc)
     * @see GameFiles.Model#postTutorial()
     */
    @Override
    protected void postTutorial() {
    	f = new Fox(Constants.FOX_START_LOC_X, Constants.FOX_START_LOC_Y, Constants.FOX_START_SIZE_X, Constants.FOX_START_SIZE_Y, cr);
    	game.add(f);
    	game.add(new Powerup(Constants.FRAME_X * Constants.POWERUP_OFFSET, 
    				Constants.FRAME_Y - (int)(Constants.POWERUP_HEIGH * Constants.POWERUP_HEIGH_SCALE) - Constants.STICK_OFFSET_Y[0],
					(int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE), (int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE)));
		game.add(new Stick((int) ((Constants.FRAME_X * .5) - Constants.STICK_OFFSET_X[1]), Constants.STICK_OFFSET_Y[1],
					(int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		game.add(new Stick((int) (Constants.FRAME_X - Constants.STICK_OFFSET_X[2]), Constants.STICK_OFFSET_Y[2],
					(int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE))); 
	//	game.add(new Stick(400, 600, (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		game.add(new Stick(Constants.STICK_OFFSET_X[3], Constants.STICK_OFFSET_Y[3], (int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE)));
		
		Bush b4 = new Bush(Constants.BUSH_X_ARR[4], Constants.BUSH_Y_ARR[4], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b4);
		cr.bushArr.add(b4);
		Bush b5 = new Bush(Constants.BUSH_X_ARR[5], Constants.BUSH_Y_ARR[5], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b5);
		cr.bushArr.add(b5);
		Bush b6 = new Bush(Constants.BUSH_X_ARR[6], Constants.BUSH_Y_ARR[6], Constants.BUSH_SIZE, Constants.BUSH_SIZE);
		game.add(b6);
		cr.bushArr.add(b6);
    }
    
    /**
     *
     * updates the location of all moving objects and then calls the collision method
     * @param g Array list of GameObjects
     * @author Tim Mazzarelli
     * @author Mark Wolgin
     */
    public void updateLocation(ArrayList<GameObject> g) {
    	if (inTutoral) {
    		// This is nessasary for the game to work
    		for (GameObject a : g) {
				if (!a.equals(f) && !a.equals(tpow)) {
					a.move();
					a.collision(g);
				}
			}
    		
    		if (tup_key == null) {
    			tup_key = new TutorialObject(Constants.TO_UP_KEY_DEFAULT_X, Constants.TO_UP_KEY_DEFAULT_Y, 
    						Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_UP_KEY);
    			game.add(tup_key);
    		}
    		
    		if (tdown_key == null && tup_key != null) {
    			tdown_key = new TutorialObject(tup_key.x, tup_key.y + Constants.TO_KEY_OFFSET, Constants.TO_DEFAULT_SIZE,
    						Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_DOWN_KEY);
    			game.add(tdown_key);
    		}
    		
    		if (tleft_key == null && tup_key != null) {
    			tleft_key = new TutorialObject(tup_key.x - Constants.TO_KEY_OFFSET, tup_key.y + Constants.TO_KEY_OFFSET,
    						Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_LEFT_KEY);
    			game.add(tleft_key);
    		}
    		
    		if (tright_key == null && tup_key != null) {
    			tright_key = new TutorialObject(tup_key.x + Constants.TO_KEY_OFFSET, tup_key.y + Constants.TO_KEY_OFFSET, 
    						Constants.TO_DEFAULT_SIZE, Constants.TO_DEFAULT_SIZE, Constants.ANIMATION_RIGHT_KEY);
    			game.add(tright_key);
    		}
    		
    		if (tstick == null) {
    			tstick = new Stick(Constants.TO_STICK_DEFAULT_LOCATION, Constants.TO_STICK_DEFAULT_LOCATION,
    						(int)(Constants.STICK_SIZE * Constants.STICK_SCALE), (int)(Constants.STICK_SIZE * Constants.STICK_SCALE));
    			tstick.imgFileName = Constants.ANIMATION_TO_STICK;
    			game.add(tstick);
    		}
    		
    		if (tpow == null) {
    			tpow = new Powerup(Constants.FRAME_X + Constants.POWERUP_HEIGH, Constants.FRAME_Y - (int)(Constants.POWERUP_HEIGH * Constants.POWERUP_HEIGH_SCALE),
    						(int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE), (int)(Constants.POWERUP_SIZE * Constants.POWERUP_SCALE));
    			tpow.imgFileName = Constants.ANIMATION_CRAB;
    			game.add(tpow);
    		}
    		
    		if (f == null) {
    			f = new Fox(Constants.FRAME_X, Constants.FRAME_Y / Constants.FOX_HEIGHT_DIVISION_FACTOR, Constants.FOX_START_SIZE_X,
    						Constants.FOX_START_SIZE_Y, cr);
    			game.add(f);
    		}
    		
    		if (tarrow == null) {
    			tarrow_cur_height = (int)(tstick.hitbox.getBounds2D().getMaxY() - nest.hitbox.getBounds2D().getMaxY() - Constants.TA_OFFSET);
    			tarrow_cur_width = (int)(tstick.hitbox.getBounds2D().getMaxX() - nest.hitbox.getBounds2D().getMaxX() - Constants.TA_OFFSET);
    			tarrow = new TutorialArrow((int)nest.hitbox.getBounds2D().getMaxX(), (int)nest.hitbox.getBounds2D().getMaxY(), 
    					tarrow_cur_width, 
    					tarrow_cur_height,
    					Constants.ANIMATION_ARROW_STATIC);
    			tarrow.curImgTickCount = 0;
				game.add(tarrow);
    		}

    		//---------------------------------------------
    		//	This is the code for the arrow to move well
    		//---------------------------------------------
    		if (tstick.visible) {
    			int tarrow_new_height = (int)(tstick.hitbox.getBounds2D().getMaxY() - nest.hitbox.getBounds2D().getMaxY() - Constants.TA_OFFSET);
    			int tarrow_new_width = (int)(tstick.hitbox.getBounds2D().getMaxX() - nest.hitbox.getBounds2D().getMaxX() - Constants.TA_OFFSET);
    			if (tarrow_new_width > Constants.TA_IMG_SAFTEY_MARGIN && tarrow_new_height > Constants.TA_IMG_SAFTEY_MARGIN) {
	    			tarrow.height = (int)(tstick.hitbox.getBounds2D().getMaxY() - nest.hitbox.getBounds2D().getMaxY() - Constants.TA_OFFSET);
	    			tarrow.width = (int)(tstick.hitbox.getBounds2D().getMaxX() - nest.hitbox.getBounds2D().getMaxX() - Constants.TA_OFFSET);
	    			tarrow.resetPoly();
	    			if (tarrow_new_height != tarrow_cur_height || tarrow_new_width != tarrow_cur_width) {
	        			tarrow.curImg ++;
	    			}
	    			tarrow_cur_height = tarrow_new_height;
	    			tarrow_cur_width = tarrow_new_width;
    			}
    			else {
    				tarrow.visible = false;
    				game.remove(tarrow);
    			}
    		}
    		else if (f.visible) {
    			if (b3.imgFileName.equals(Constants.ANIMATION_BUSH)) {
    				tup_key.visible = tdown_key.visible = tright_key.visible = tleft_key.visible = false;
    				game.remove(tup_key);
    				game.remove(tdown_key);
    				game.remove(tright_key);
    				game.remove(tleft_key);
    				b3.imgFileName = Constants.ANIMATION_BUSH_GLOW;
    			}
    			else if (!cr.hitbox.getBounds2D().intersects(b1.hitbox.getBounds2D()) && f.hitbox.getBounds2D().getMinY() > 0) {
    				f.move();
    				f.collision(game);
    			}
    			else if (cr.hitbox.getBounds2D().intersects(b1.hitbox.getBounds2D())) {
    				f.move();
				}
    			else {
    				f.visible = false;
    				game.remove(f);
    			}
    		}
    		else if (tpow.visible){
				if (b3.imgFileName.equals(Constants.ANIMATION_BUSH_GLOW)) {
					b3.imgFileName = Constants.ANIMATION_BUSH;
				}
				else if (tpow.hitbox.getBounds2D().getCenterX() > b1.hitbox.getBounds2D().getCenterX()) {
					tpow.move();
				}
				if (Powerup.power) {
					Powerup.power = false;
					tpow.visible = false;
					game.remove(tpow);
				}
    		}
    		else {
	    		this.postTutorial();
	    		Model.inTutoral = false;
    		}
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
    		ClapperRail.lives += Constants.POWERUP_LIFE_INCREASE_RATE;
    		Quiz.correct = false;
    	}
    }
   
    /**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		new Controller(Constants.TOP_DOWN_STRING);
		
	}

	
	
}