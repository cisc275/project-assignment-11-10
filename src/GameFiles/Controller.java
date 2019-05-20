package GameFiles;
import java.awt.EventQueue;

import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

/**
 * main controller for the game, starts and maintains all of our models and views
 * @author tmazz
 *
 */

public class Controller implements KeyListener, ActionListener{
	/**
	 *  for whichever model you are in
	 */
	private Model model;
	
	/**
	 * for whichever view you are in
	 */
	private View view;
	
	/**
	 * timer for the game
	 */
	private Timer time;
	
	/**
	 * action defined later for running game
	 */
	
	private Action drawAction;
	
	/**
	 * to determine whichever game you're in
	 */
	String selected;
	
	/**
	 * hashset of the keys that are being pressed, for key handling
	 */
	HashSet<Integer> keyPresses = new HashSet<>();
	
	/**
	 * Picks what to draw and control depending on the string you pass in
	 * @param selection
	 */
	public Controller(String selection) {
		
		selected = selection;
		
		if (selected.equals("sel")){
			view = new SelectionView(new ArrayList<GameObject>());
			view.addActionListener(this);	
		}

		if(selected.equals("topDown")) {
			// clapper rail game
			
			model = new TopDownModel();
			view = new TopDownView(model.game);
			model.defaultSetup();
			
			view.addKeyListener(this);
			this.start();
		}
		// sideScroll game
		else if(selected.equals("sideScroll")) {
			model = new SideScrollModel();	
			view = new SideScrollView(model.game);
			model.defaultSetup();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		// sidescroll game without tutorial
		else if(selected.equals("sideScrollNT")) {
			model = new SideScrollModel();	
			view = new SideScrollView(model.game);
			
			model.inTutoral = false;
			model.defaultSetup();
			model.postTutorial();
			
			view.addKeyListener(this);
			view.addActionListener(this);
			this.start();
		}
		
		
	}
		
	/**
	 * starts timers and actions for sideScroll
	 */
	public void start() {

		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.handlePwr();
    			model.updateLocation(model.game);
    			view.updateView(model.game);
    			if (Mate.caughtUp) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				new Quiz("sides");
    				time.stop();
    			}
    			else if(Stick.count == Constants.STICK_END_COUNT) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				View.frame.dispose();
    				new EndScreen();
    				time.stop();
    			}
    			else if(ClapperRail.lives == Constants.CLAPPER_RAIL_LIVES_END_STATE) {
    				for(GameObject g : model.game) {
    					g.visible = false;
    				}
    				View.frame.dispose();
    				new LoseScreen("cr");
    				time.stop();
    			}
    		}
    	};
    	time = new Timer(Constants.TIMER_TICK_RATE, drawAction);
    	time.start();
	}

	/**
	 * decides which button to follow
	 * @param e
	 * @author Tim Mazzarelli
	 */
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SelectionView.clapperRail) {
			view.dispose();
			new Controller("topDown");
		}
		else if (e.getSource() == SelectionView.osprey){
			view.dispose();
        	new Controller("sideScroll");
        }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	// sets speed according to game input
	
	/**
	 * adds keypress to set of currently pressed keys, gives set to model to handle
	 * @author andrew thompson
	 */
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		keyPresses.add(e.getKeyCode());
		model.handleMove(keyPresses);
		//System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
			case Constants.TILDA_KEY_CODE:
				try {
					Serialize.dumpGame(model);
				
					TutorialObject nc = new TutorialObject(1200, 50, 352, 18, Constants.ANIMATION_MODEL_DUMP_STATUS_MSG);
					model.game.add(nc);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case Constants.ONE_KEY_CODE:
					view.debugHitBoxes =  !view.debugHitBoxes;
					break;
			case Constants.ESCAPE_KEY_CODE:
				new Controller("sel");
				break;
		}
	}	
	/**
	 * removes keypress to set of currently pressed keys, gives set to model to handle
	 * @author andrew thompson
	 */
	@Override
	public synchronized void keyReleased(KeyEvent e) {
		keyPresses.remove(e.getKeyCode());
		model.handleMove(keyPresses);
		
		
	}

	
	
}
