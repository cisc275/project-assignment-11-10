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
	
	private TopDownModel topDownModel;
	private TopDownView topDownView;
	private SideScrollModel sideScrollModel;
	private SideScrollView sideScrollView;
	private Timer time;
	private Action drawAction;
	boolean collision;
	String selected;
	ArrayList<GameObject> game;
	Osprey o;

	
	public Controller(String selection) {
		selected = selection;
		if(selected.equals("topDown")) {
			game = new ArrayList<GameObject>();
			topDownModel = new TopDownModel(10,10,10,10);
			game.add(new ClapperRail(100,100,100,300,new Polygon(),topDownModel.createImage2()));
			game.add(new Fox(400,400,100,300,new Polygon(),topDownModel.createImage2()));
			game.add(new Stick(200,200,100,300,new Polygon(),topDownModel.createImage2(),5));
			game.add(new Bush(500, 550,100,300,new Polygon(),topDownModel.createImage2()));
			game.add(new Bush(0, -60,100,300,new Polygon(),topDownModel.createImage2()));
			topDownView = new TopDownView(game);
			topDownView.addKeyListener(this);

		}
		else if(selected.equals("sideScroll")) {
			Background backOne = new Background();
			Background backTwo = new Background(backOne.getImageWidth(), 0);
			o = new Osprey(100, 100, 50, 50, new Polygon(), null, -5, 0, false);
			Trash t = new Trash(850, 650, 50, 50, new Polygon(), null,  -4);
			Fish f = new Fish(800, 650, 50, 50, new Polygon(), null, -10);
			AirCurrent a = new AirCurrent(900, 150, 50, 50, new Polygon(), null, -3);
			game = new ArrayList<GameObject>();
			game.add(o);
			game.add(f);
			game.add(t);
			game.add(a);
			
			sideScrollModel = new SideScrollModel();
			
			sideScrollView = new SideScrollView(game, backOne, backTwo);
			sideScrollView.addKeyListener(this);
			
			
		}
		for(GameObject g:game) {
			System.out.println(g);
		}
		//topDownView.addActionListener(this);
		//game = new ArrayList<GameObject>();
		//game.add(new GameObject(pic,100,100));
		//System.out.println("DID IT DO ANYTHING DIFFERENT????????????????????");
		//game.add(new GameObject(topDownModel.createImage2(),400,400));
		//System.out.println("HOW ABOUT NOW?????????????????");
		//game.add(new GameObject(topDownModel.createImage3(),200,200));
	}
	
	public void topDownStart() {
		//System.out.println("topDownStart is starting");
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			//System.out.println("im performing actions");
    			collision = topDownModel.updateLocation(game);
    			topDownView.updateView(game,collision);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}
	public void sideScrollStart() {
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			//System.out.println("im performing actions");
    			sideScrollModel.advanceWorld(game);
    			sideScrollView.updateView(game);
    		}
    	};
    	
    	time = new Timer(50, drawAction);
    	time.start();
	}
/*
	private void addKeyListener(KeyListener keyListener) {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("pressed");
		if(e.getKeyCode() == 39) { //right arrow key
			if(selected.equals("topDown")) {
				topDownModel.setxChg(5);
				//collision = topDownModel.updateLocation(game);
				//topDownView.updateView(game,collision);
			}
		}
		else if(e.getKeyCode() == 37) { //left arrow key
			//xIncr = -5;
			if(selected.equals("topDown")) {
				topDownModel.setxChg(-5);
				//collision = topDownModel.updateLocation(game);
				//topDownView.updateView(game,collision);
			}
		}
		else if(e.getKeyCode() == 38) { //up arrow key
			//yIncr = -5;
			if(selected.equals("topDown")) {
				topDownModel.setyChg(-5);
				//collision = topDownModel.updateLocation(game);
				//topDownView.updateView(game,collision);
			}
			else if(selected.equals("sideScroll")) {
				o.setYSpeed(-5);
			}
		}
		else if(e.getKeyCode() == 40) { //down arrow key
			//yIncr = 5;
			if(selected.equals("topDown")) {
				topDownModel.setyChg(5);
				//collision = topDownModel.updateLocation(game);
				//topDownView.updateView(game,collision);
			}
			else if(selected.equals("sideScroll")) {
				o.setYSpeed(5);
			//	sideScrollModel.advanceWorld(game);
				// sideScrollView.updateView(game);
			}
		}
		
		else if (e.getKeyCode() == 32) {
			if (selected.equals("sideScroll")){
				o.dive();
		//		sideScrollModel.advanceWorld(game);
			//	sideScrollView.updateView(game);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(selected.equals("topDown")) {
			topDownModel.setxChg(0);
			topDownModel.setyChg(0);
		}
	}
	
	
}
