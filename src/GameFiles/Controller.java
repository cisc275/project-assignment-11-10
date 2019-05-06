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
	//		game.add(((TopDownModel)model).f);
			game.add(((TopDownModel)model).nest);
			game.add(new Fish(3000, 700, 50, 50, new Polygon(), null, -16));
			game.add(new Stick(300,300,40,80,new Polygon(),model.createImage4(), 0, 0));
			game.add(new Stick(500, 250 ,40,40,new Polygon(),model.createImage4(), 0, 0));
			game.add(new Stick(400, 400 ,80,40,new Polygon(),model.createImage4(), 0, 0));
			game.add(new Bush(500, 500,150,150,new Polygon(),model.createImage3()));
			game.add(new Bush(600, 20,150,150,new Polygon(),model.createImage3()));
			game.add(new Bush(20, 450,175,175,new Polygon(),model.createImage3()));
			view = new TopDownView(game);
			view.addKeyListener(this);
			this.topDownStart();

		}
		// sideScroll game
		else if(selected.equals("sideScroll")) {
			Background backOne = new Background();
			Background backTwo = new Background(backOne.getImageWidth(), 0);
			Trash t = new Trash(850, 650, 50, 50, new Polygon(), null,  -8);
			Trash t2 = new Trash(900, 650, 50, 50, new Polygon(), null,  -16);
			Fish f = new Fish(800, 650, 50, 50, new Polygon(), null, -20);
			Fish f2 = new Fish(1000, 650, 50, 50, new Polygon(), null, -10);
			Fish f3 = new Fish(1200, 650, 50, 50, new Polygon(), null, -16);
			AirCurrent a = new AirCurrent(900, 95, 50, 50, new Polygon(), null, -6);
			AirCurrent a2 = new AirCurrent(1500, 300, 50, 50, new Polygon(), null, -16);
			AirCurrent a3 = new AirCurrent(1300, 200, 50, 50, new Polygon(), null, -12);
			Mate m = new Mate(1000, 200, 200, 50, new Polygon(), null, -1, false); // suposed to be 50 50, this is for the memes
			game = new ArrayList<GameObject>();
			model = new SideScrollModel();	
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
		
			view = new SideScrollView(game, backOne, backTwo);
			view.addKeyListener(this);
			this.sideScrollStart();
			
		}
	}
	
	/**
	 * starts timers and actions for topDown
	 */
	public void topDownStart() {
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.updateLocation(game);
    			view.updateView(game);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}
	
		
	/**
	 * starts timers and actions for sideScroll
	 */
	public void sideScrollStart() {
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			model.advanceWorld(game);
    			view.updateView(game);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
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
			new Controller("topDown");
		}
		else {
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
