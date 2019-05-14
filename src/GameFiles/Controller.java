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



public class Controller implements KeyListener, ActionListener{
	private Model model;
	private View view;
	private Timer time;

	private Action drawAction;
	String selected;
	ArrayList<GameObject> game;
	HashSet<Integer> keyPresses = new HashSet<>();
	
	
	public Controller(String selection) {
		
		selected = selection;
		
		if (selected.equals("sel")){
			view = new SelectionView();
			view.addActionListener(this);	
		}

		
		if(selected.equals("topDown")) {
			// clapper rail game
		
			game = new ArrayList<GameObject>();
			model = new TopDownModel();
			game.add(((TopDownModel)model).cr);
			game.add(((TopDownModel)model).f);
			game.add(((TopDownModel)model).nest);
			
			game.add(new Powerup(10 * 2, (int) (10 * 0.91), 50, 50));
			game.add(new Stick(300,300,40,40));
			game.add(new Stick(500, 250 ,40,40));
			game.add(new Stick(400, 400 ,40,40));
			game.add(new TutorialObject(300, 150, 50, 50, Constants.ANIMATION_SPACEBAR));
			Bush b1 = new Bush(500, 500,150,150);
			game.add(b1);
			((TopDownModel)model).cr.bushArr.add(b1);
			Bush b2 = new Bush(600, 20,150,150);
			game.add(b2);
			((TopDownModel)model).cr.bushArr.add(b2);
			Bush b3 = new Bush(20, 450,175,175);
			game.add(b3);
			((TopDownModel)model).cr.bushArr.add(b3);
			
			view = new TopDownView(game);
			view.addKeyListener(this);
			this.start();

		}
		// sideScroll game
		else if(selected.equals("sideScroll")) {
			game = new ArrayList<GameObject>();
			
			
			
			
			Background backOne = new Background(0, 0, 1920, 1080);
			
			Trash t = new Trash(1920 + 200, 1080 - (1080 / 3), 
					1920 / 20, 1080/ 15);
			Trash t2 = new Trash(1920 + 20, 1080 - (1080 / 9), 
					1920 / 20, 1080/ 15);
			Fish f = new Fish(1920 + 400, (int) (1080 * 0.87), 
					(int) (1920 * 0.05), (int) (1080 * 0.05));
			Fish f2 = new Fish(1920 + 250, 600, 50, 50);
			Fish f3 = new Fish(1920 + 100, 650, 50, 50);
			Powerup p = new Powerup(100, 200, 50, 50);
			AirCurrent a = new AirCurrent(1920 + 20, 55, 250, 250);
			AirCurrent a2 = new AirCurrent(1920  + 100, 100, 200, 200);
			AirCurrent a3 = new AirCurrent(1920  + 500, 200, 200, 200);
			Mate m = new Mate(1920 + 400, 200, 200, 50); // suposed to be 50 50, this is for the memes
			model = new SideScrollModel();	
			
			game.add(backOne);
			game.add(p);
			game.add(((SideScrollModel)model).o);
			game.add(f);
			game.add(f2);
			game.add(f3);
			game.add(t);
			game.add(t2);
			game.add(a);
			game.add(a2);
			game.add(a3);
			game.add(m);
			view = new SideScrollView(game);
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
    			model.updateLocation(game);
    			view.updateView(game);
    			if (Mate.caughtUp) {
    				View.frame.dispose();
    				new Quiz("sides");
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
		switch (e.getKeyCode()) {
			case 192:
				try {
					Serialize.dumpGame(model);
				/*
				 * NonControllable nc = new NonControllable(1200, 50, 552, 31);
				 * nc.setImgFileName(Constants.ANIMATION_MODEL_DUMP_STATUS_MSG);
				 * model.game.add(nc);
				 */
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
