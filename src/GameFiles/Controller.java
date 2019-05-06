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



public class Controller implements KeyListener{
	private Model model;
	private View view;
	private Timer time;
	private Action drawAction;
	String selected;
	ArrayList<GameObject> game;
	Osprey o;
	
	
	public Controller(String selection) {
		
		selected = selection;
		
		if (selected.equals("sel")){
			view = new SelectionView();
			view.addKeyListener(this);
		}

		
		if(selected.equals("topDown")) {
			// clapper rail game
			game = new ArrayList<GameObject>();
			model = new TopDownModel();
			game.add(((TopDownModel)model).cr);
			game.add(((TopDownModel)model).f);
			game.add(new Stick(300,300,40,80,new Polygon(),model.createImage4(), 0, 0));
			game.add(new Stick(500, 50 ,40,40,new Polygon(),model.createImage4(), 0, 0));
			game.add(new Stick(700, 700 ,80,40,new Polygon(),model.createImage4(), 0, 0));
			game.add(new Bush(500, 550,150,150,new Polygon(),model.createImage3()));
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
			o = new Osprey(100, 100, 50, 50, new Polygon(), null, -5, 0, false);
			Trash t = new Trash(850, 650, 50, 50, new Polygon(), null,  -8);
			Trash t2 = new Trash(900, 650, 50, 50, new Polygon(), null,  -16);
			Fish f = new Fish(800, 650, 50, 50, new Polygon(), null, -20);
			Fish f2 = new Fish(1000, 650, 50, 50, new Polygon(), null, -10);
			Fish f3 = new Fish(1200, 650, 50, 50, new Polygon(), null, -16);
			AirCurrent a = new AirCurrent(900, 95, 50, 50, new Polygon(), null, -6);
			AirCurrent a2 = new AirCurrent(1500, 300, 50, 50, new Polygon(), null, -16);
			AirCurrent a3 = new AirCurrent(1300, 200, 50, 50, new Polygon(), null, -12);
			Mate m = new Mate(1000, 200, 50, 50, new Polygon(), null, -1, false);
			game = new ArrayList<GameObject>();
			game.add(o);
			game.add(f);
			game.add(f2);
			game.add(f3);
			game.add(t);
			game.add(t2);
			game.add(a);
			game.add(a2);
			game.add(a3);
			game.add(m);
	
			model = new SideScrollModel();		
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
	public void keyTyped(KeyEvent e) {
	}

	// sets speed according to game input
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 39) { //right arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setxSpeed(((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
			else if (selected.equals("sel")) {
				new Controller("topDown");
				view.dispose();
			}
		}
		else if(e.getKeyCode() == 37) { //left arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setxSpeed(-((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
			else if(selected.equals("sel")) {
	        	new Controller("sideScroll");
				view.dispose();
			}
		}
		else if(e.getKeyCode() == 38) { //up arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setySpeed(-((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
			else if(selected.equals("sideScroll")) {
				if ((o.hitbox.xpoints[0] == 0) ||  (o.hitbox.xpoints[0] == 450))
				 o.setYSpeed(0);
				else {
				o.setYSpeed(-5);
			}
		}
		}
		else if(e.getKeyCode() == 40) { //down arrow key
			if(selected.equals("topDown")) {
				((TopDownModel)model).cr.setySpeed(((TopDownModel)model).cr.getMOVE_AMOUNT());
			}
			else if(selected.equals("sideScroll"))  {
				if ((o.hitbox.xpoints[0] == 0) ||  (o.hitbox.xpoints[0] == 450))
					 o.setYSpeed(0);
					else {
					o.setYSpeed(5);
				}
			}
		}
		
		else if (e.getKeyCode() == 32) {
			if (selected.equals("sideScroll")){
				o.dive();
			}

	}
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("anything?");

		// TODO Auto-generated method stub
		if(selected.equals("topDown")) {
			((TopDownModel)model).cr.setxSpeed(0);
			((TopDownModel)model).cr.setySpeed(0);
		}
	}

	
	
}
